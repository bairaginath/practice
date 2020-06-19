import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class RecursiveTaskExample {
	
	static class Task extends RecursiveTask<Integer> {
	    private static final long serialVersionUID = -4702976772011326493L;

	    // Array to be summed
	    private int[] intArray;

	    // Start and end positions of the part of the array to be summed by this task
	    private int start, end;

	    public Task(int[] array, int start, int end) {
	        this.intArray = array;
	        this.start    = start;
	        this.end      = end;
	        //System.out.println("start "+start+" end "+end);
	    }

	    @Override
	    protected Integer compute() {
	        Integer      ret;

	        if (end - start > 100) {
	            int            mid   = (start + end) / 2;
	            Task task1 = new Task(intArray, start, mid);
	            Task task2 = new Task(intArray, mid, end);

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

	    private Integer addResults(Task task1, Task task2) {
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
	    
	    public static void main(String[] args) {
	    	int array[] = new int[100000];
	    	Arrays.fill(array, 1);
	    	ForkJoinPool pool=new ForkJoinPool();
	  	    Task task=new Task(array,0,array.length);
	  	    pool.execute(task);
	  	    Integer result=task.join();
	  	  System.out.println(result);
	    	
		}
	}


}
