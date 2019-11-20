import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BQNotificationHandler {

    class Producer implements Runnable
    {
        Queue<Integer> queue;
        Producer(Queue<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run() {


            System.out.println("inside producer");

            for(int i=0;i<100;i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println("inserting at producer");
                queue.add(i);
            }




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
            ArrayBlockingQueue aq=(ArrayBlockingQueue)queue;
            for (int i = 0; i < 100; i++){
                try {
                    System.out.println("========"+aq.take()+"========");
                }catch (InterruptedException ie) {}
            }




        }
    }



    public static void main(String[] args) throws InterruptedException {
        Queue queue=new ArrayBlockingQueue<>(10);
       // Queue<Integer> queue=new SynchronousQueue<>(); //using synchronous queue achive IPC
        BQNotificationHandler nh=new BQNotificationHandler();
        BQNotificationHandler.Producer p=nh.new Producer(queue);
        BQNotificationHandler.Consumer c=nh.new Consumer(queue);
        System.out.println("Main methond");
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        t2.start();
        t1.start();

    }
}

