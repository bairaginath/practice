import java.util.Queue;
import java.util.concurrent.*;
import java.util.*;

public class NotificationHandler {

    static List<Task> listTask=new ArrayList<>();
    static ExecutorService es= Executors.newFixedThreadPool(10);
    static CyclicBarrier barrier=new CyclicBarrier(1);

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
                System.out.println("inserting at producer");
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

    @Override
    public void run() {
                System.out.println("inside consumer");
                ArrayBlockingQueue<Integer> aq=(ArrayBlockingQueue<Integer>)queue;
                    for (int i = 0; i < 5; i++){
                        try {
                            Integer value=aq.take();
                            System.out.println("========"+value+"========"+barrier.getNumberWaiting());
                           listTask.stream().forEach(task ->{
                               es.submit(()-> {
                                  // System.out.println("******"+value+"*******"+Thread.currentThread().getName()+"  "+barrier.getNumberWaiting());

                                   task.doExecute(value);
                                   try {
                                           barrier.await();
                                       } catch (InterruptedException | BrokenBarrierException bbe) {
                                       }


                               });
                           });
                           //barrier.reset();
                        }catch (InterruptedException ie) {}
                    }




    }
}



    public static void main(String[] args) throws InterruptedException {
        Queue queue=new ArrayBlockingQueue<>(10);
        //Queue<Integer> queue=new SynchronousQueue<>();
        NotificationHandler nh=new NotificationHandler();
        listTask.add(nh.new EmailTask());
        listTask.add(nh.new SmsTask());
        listTask.add(nh.new LoggingTask());
        //listTask.add(nh.new LoggingTask());
        //listTask.add(nh.new LoggingTask());
        NotificationHandler.Producer p=nh.new Producer(queue);
        NotificationHandler.Consumer c=nh.new Consumer(queue);
        System.out.println("Main method");
        es.submit(p);
        es.submit(c);

    }
}

