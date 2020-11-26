import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable
{
    Queue<Integer> queue;
    Producer(Queue<Integer> queue){
        this.queue=queue;
    }
    
    @Override
    public void run() {

        synchronized (this.queue){
            System.out.println("inside producer");
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            for(int i=0;i<100;i++)
                queue.add(i);
            queue.notify();
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


        synchronized (this.queue) {
            System.out.println("inside consumer");
            if(queue.isEmpty()) {

                try {
                    queue.wait();
                } catch (Exception e) {
                }
            }

            for (int i = 0; i < 100; i++)
                System.out.println("========"+queue.poll()+"========");


        }
    }
}


public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue=new LinkedList<>();
        Producer p=new Producer(queue);
        Consumer c=new Consumer(queue);
        System.out.println("Main methond");
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        t2.start();
        t1.start();

    }
}


