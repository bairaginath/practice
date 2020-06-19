import java.lang.reflect.Field;
import java.util.stream.IntStream;

import sun.misc.Unsafe;

public class UnsafeExample {
	
	private Unsafe unsafe;
    //private volatile long counter = 0;
    private  long counter = 0;
    private long offset;
    
    public UnsafeExample() throws Exception{
    	unsafe = getUnsafe();
        offset = unsafe.objectFieldOffset(UnsafeExample.class.getDeclaredField("counter"));
        System.out.println(offset);
    }
 
    private Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }
    
    public void normalIncrement() {
    	counter++;
    }
    
    public void increment() {
        long before = counter;
        //public final native boolean compareAndSwapLong(java.lang.Object arg0, long arg1, long arg2, long arg3);
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            System.out.println("inside increment "+Thread.currentThread().getName());
        	before = counter;
        }
    }
 
    public long getCounter() {
        return counter;
    }
    
    public static void main(String[] args) throws Exception {
		UnsafeExample ue=new UnsafeExample();
		//IntStream.range(0,Integer.MAX_VALUE).parallel().forEach(i->ue.increment());
		IntStream.range(0,101).parallel().forEach(i->ue.normalIncrement());
		
		System.out.println(ue.getCounter());
	}

}
