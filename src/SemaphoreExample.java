import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample implements Runnable {
	
	Semaphore lock;
	
	
	public SemaphoreExample(Semaphore lock) {
		this.lock=lock;
	}

	@Override
	public void run() {
		
		String name=Thread.currentThread().getName();
		System.out.println("inside run method "+name);
		try {
			lock.acquire();
			System.out.println("lock acquired "+name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		ExecutorService es=Executors.newCachedThreadPool();
		Semaphore lock=new Semaphore(1);
		
		for(int i=0;i<10;i++) {
			es.submit(new SemaphoreExample(lock));
		}
	}

}
