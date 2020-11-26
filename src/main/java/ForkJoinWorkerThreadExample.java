import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

class ARecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -4702976772011326493L;

    // Array to be summed
    private int[] intArray;

    // Start and end positions of the part of the array to be summed by this task
    private int start, end;

    public ARecursiveTask(int[] array, int start, int end) {
        this.intArray = array;
        this.start    = start;
        this.end      = end;
        //System.out.println("start "+start+" end "+end);
    }

    @Override
    protected Integer compute() {
        Integer      ret;
        WorkerThread thread = (WorkerThread) Thread.currentThread();

        thread.addTask();

        if (end - start > 100) {
            int            mid   = (start + end) / 2;
            ARecursiveTask task1 = new ARecursiveTask(intArray, start, mid);
            ARecursiveTask task2 = new ARecursiveTask(intArray, mid, end);

            invokeAll(task1, task2);
            ret = addResults(task1, task2);
        } else {
            int add = 0;

            for (int i = start; i < end; i++) {
                add += intArray[i];
            }

            ret = new Integer(add);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private Integer addResults(ARecursiveTask task1, ARecursiveTask task2) {
        int value;

        try {
            value = task1.get().intValue() + task2.get().intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            value = 0;
        } catch (ExecutionException e) {
            e.printStackTrace();
            value = 0;
        }

        return new Integer(value);
    }
}



class WorkerThreadFactory implements ForkJoinWorkerThreadFactory {
    @Override
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new WorkerThread(pool);
    }
}

class WorkerThread extends ForkJoinWorkerThread {
    private static ThreadLocal<Integer> taskCounter = new ThreadLocal<>();

    public WorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.printf("WorkThread %d: Initializing task counter.\n", this.getId());
        taskCounter.set(0);
    }

    @Override
    protected void onTermination(Throwable exception) {
        System.out.printf("WorkerThread %d: %d\n", getId(), taskCounter.get());
        super.onTermination(exception);
    }

    public void addTask() {
        int counter = taskCounter.get().intValue();

        counter++;
        taskCounter.set(counter);
    }
}

public class ForkJoinWorkerThreadExample {
	
	public static void main(String[] args) throws Exception {
        WorkerThreadFactory factory = new WorkerThreadFactory();
        ForkJoinPool        pool    = new ForkJoinPool(4, factory, null, false);

        // Create and initializes the elements of the array
        int array[] = new int[100000];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
 
        // Create a new Task to sum the elements of the array
        ARecursiveTask task = new ARecursiveTask(array, 0, array.length);

        // Send the task to the ForkJoinPool
        pool.execute(task);

        // Wait for the finalization of the task
        task.join();

        // Shutdown the pool
        pool.shutdown();

        // Wait for the finalization of the pool
        pool.awaitTermination(1, TimeUnit.DAYS);

        // Write the result of the task
        System.out.printf("Main: Result: %d\n", task.get());

        // Write a message indicating the end of the program
        System.out.printf("Main: End of the program\n");
    }

}
