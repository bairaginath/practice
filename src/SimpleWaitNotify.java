import java.util.LinkedList;
import java.util.Queue;







public class SimpleWaitNotify {
	
	class Producer implements Runnable {
		Queue<Integer> queue;
		public Producer(Queue<Integer> queue) {
			this.queue=queue;
		}
		@Override
		public void run() {
	        synchronized(this.queue){
	        	for(int i=1;i<=10;i++){
	        		try {
	        			Thread.sleep(1000);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}
	        		queue.offer(i);
	        		System.out.println("element "+i+" enqueue on queue");
	        	}
	        	queue.notify();
	     
		}
		
	}
		
	}
	
	class Consumer implements Runnable {
		Queue<Integer> queue;
		public Consumer(Queue<Integer> queue) {
			this.queue=queue;
		}
		@Override
		public void run() {
	        synchronized(this.queue){
	        	if(queue.isEmpty()) {
	        		try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
	        		
	        	}
	        	for(int i=1;i<=10;i++){
	        		try {
	        			Thread.sleep(1000);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}
	        		System.out.println("element "+queue.poll()+" from queue");
	        	}
	     
		}
		
	}
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
		SimpleWaitNotify swn=new SimpleWaitNotify();
		SimpleWaitNotify.Producer p=swn.new Producer(queue);
		SimpleWaitNotify.Consumer c=swn.new Consumer(queue);
		new Thread(c).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(p).start();
	
		
	}
	

	
	

}
