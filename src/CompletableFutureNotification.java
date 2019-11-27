import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;





public class CompletableFutureNotification {

    static List<Task> listTask=new ArrayList<>();
    static ExecutorService es= Executors.newFixedThreadPool(10);
    static CyclicBarrier barrier=new CyclicBarrier(3);

    class Producer implements Runnable
    {
        Queue<Integer> queue;
        Producer(Queue<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run() {


            System.out.println("inside producer");

            for(int i=0;i<5;i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
               // System.out.println("inserting at producer");
                queue.add(i);
            }




        }
    }

    interface Task {
        void doExecute(int value);
    }

    class EmailTask implements Task  {

        @Override
        public void doExecute(int value)  {
            try {
                Thread.sleep(10000);
                System.out.println("email service complete "+value);
            }catch (InterruptedException ie){}
        }
    }

    class SmsTask implements Task  {

        @Override
        public void doExecute(int value)  {
            try {
                Thread.sleep(6000);
                System.out.println("sms service complete "+value);
            }catch (InterruptedException ie){}
        }
    }

    class LoggingTask implements Task  {

        @Override
        public void doExecute(int value)  {
            try {
                Thread.sleep(1000);
                System.out.println("logging service complete "+value);
            }catch (InterruptedException ie){}
        }
    }



    class Consumer implements Runnable {
        Queue<Integer> queue;
        Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        void doExtra(){
            try {Thread.sleep(7000); } catch (InterruptedException ie) {}
        }

        @Override
        public void run() {
            System.out.println("inside consumer");
            ArrayBlockingQueue<Integer> aq=(ArrayBlockingQueue<Integer>)queue;
            for (int i = 0; i < 5; i++){
                try {
                    Integer value=aq.take();

                    List<Future> flist=new ArrayList<>();
                    long start=System.currentTimeMillis();
                    listTask.stream().forEach(task ->{
                        CompletableFuture<Void> cf = CompletableFuture.runAsync(()->task.doExecute(value));
                    });
                    doExtra();
                    System.out.println("total time " + (System.currentTimeMillis()-start)/1000);


                }catch (InterruptedException ie) {}
            }




        }
    }



    public static void main(String[] args) throws InterruptedException {
        Queue queue=new ArrayBlockingQueue<>(10);
        //Queue<Integer> queue=new SynchronousQueue<>();
        CompletableFutureNotification nh=new CompletableFutureNotification();
        listTask.add(nh.new EmailTask());
        listTask.add(nh.new SmsTask());
        listTask.add(nh.new LoggingTask());
        //listTask.add(nh.new LoggingTask());
        //listTask.add(nh.new LoggingTask());
        CompletableFutureNotification.Producer p=nh.new Producer(queue);
        CompletableFutureNotification.Consumer c=nh.new Consumer(queue);
        System.out.println("Main method");
        es.submit(p);
        es.submit(c);

    }
}



