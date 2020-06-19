import java.util.concurrent.locks.LockSupport;

public class LockSupportExample {
	

	public static void main(String[] args) {

		Thread t1=new Thread(()->{
			LockSupport.park();
			System.out.println("in side thread1");
			
		});
		
		t1.start();
		
		Thread t2=new Thread(()->{
			System.out.println("in side thread2");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LockSupport.unpark(t1);
			
		});
		t2.start();
		
		
	}


}
