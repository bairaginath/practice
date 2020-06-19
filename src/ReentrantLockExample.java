import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	
	static int max=Integer.MAX_VALUE;

	static class Producer implements Runnable {
		static final int capacity = 10;
		
		Queue<Integer> queue;
		ReentrantLock lock;
		Condition emptyCondition;
		Condition fullCondition;

		Producer(Queue<Integer> queue, ReentrantLock lock, Condition emptyCondition, Condition fullCondition) {
			this.queue = queue;
			this.lock = lock;
			this.emptyCondition = emptyCondition;
			this.fullCondition = fullCondition;
		}

		@Override
		public void run() {

			this.lock.lock();
			System.out.println("inside producer");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}

			for (int i = 1;i<max; i++) {
				if (queue.size() == capacity)
					try {
						emptyCondition.signalAll();
						fullCondition.await();
						;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				queue.add(i);
				System.out.println("Inside producer*********" + i);
			}
            emptyCondition.signal();
			this.lock.unlock();

		}
	}

	static class Consumer implements Runnable {
		Queue<Integer> queue;
		ReentrantLock lock;
		Condition emptyCondition;
		Condition fullCondition;

		Consumer(Queue<Integer> queue, ReentrantLock lock, Condition emptyCondition, Condition fullCondition) {
			this.queue = queue;
			this.lock = lock;
			this.emptyCondition = emptyCondition;
			this.fullCondition = fullCondition;
		}

		@Override
		public void run() {

			System.out.println("inside consumer");
			lock.lock();
			if (queue.isEmpty()) {

				try {
					emptyCondition.await();
				} catch (Exception e) {
				}
			}

			for (int i = 0; i <max; i++) {
				System.out.println("Inside consumer=========" + queue.poll());
				if (queue.isEmpty()) {
					fullCondition.signalAll();
					try {
						emptyCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			lock.unlock();

		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		ReentrantLock lock = new ReentrantLock();
		Condition emptyCondition = lock.newCondition();
		Condition fullCondition = lock.newCondition();
		Producer p = new Producer(queue, lock, emptyCondition, fullCondition);
		Consumer c = new Consumer(queue, lock, emptyCondition, fullCondition);
		System.out.println("Main methond");
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t2.start();
		t1.start();
	}
}
