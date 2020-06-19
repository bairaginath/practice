import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    Map<String,String> map = new HashMap<>();
    private StampedLock lock = new StampedLock();
 
    public void put(String key, String value){
        long stamp = lock.writeLock();
        
        System.out.println("inside put method "+stamp);
        
        try {
        	
            map.put(key, value);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
            lock.unlockWrite(stamp);
        }
    }

    public String readWithOptimisticLock(String key) {
    	//@return a stamp, or zero if exclusively locked
    	long stamp = lock.tryOptimisticRead();
    	System.out.println(Thread.currentThread().getName()+"inside get method "+stamp);
    String value = map.get(key);
      //Returns true if the lock has not been exclusively acquired
    
    if(!lock.validate(stamp)) {
        stamp = lock.readLock();
        try {
            return map.get(key);
        } finally {
            lock.unlock(stamp);               
        }
    }
    return value;
}
    
    public static void main(String[] args) {
		StampedLockDemo sl=new StampedLockDemo();
		
		
		new Thread(()->sl.put("james","ind"),"thread1").start();
		new Thread(()->sl.readWithOptimisticLock("james"),"thread2").start();
		new Thread(()->sl.readWithOptimisticLock("james"),"thread3").start();
	}
    
}

/* 
 * inside put method 384
thread2inside get method 0
thread3inside get method 0
*/
 
 
