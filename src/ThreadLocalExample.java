
class Req implements Runnable {
	
	ThreadLocal<Integer> header;
	
	int localCounter=0;
	
	public Req(){
		
		header=ThreadLocal.withInitial(()->0);
		
	}

	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		localCounter++;
		header.set(header.get()+1);
		System.out.println(name+" localCounter= "+localCounter+" threadlocal= "+header.get());
       		
	}
	
}

public class ThreadLocalExample {
	
	public static void main(String[] args) {
		ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
		tl.set(44);
		System.out.println(tl.get());
		ThreadLocal<Integer> tl1 = ThreadLocal.withInitial(() -> 5);
		System.out.println(tl1.get());

		ThreadLocal<String> tl2 = new ThreadLocal<String>() {
          
			 protected String initialValue() {return "james";};
		};
		System.out.println(tl2.get());
		
		Req req=new Req();
		for(int i=1;i<=10;i++)
		{
			Thread t=new Thread(req,"Thread-"+i);
			t.start();
		}
	}

}

/* 
44
5
james
Thread-2 localCounter= 2 threadlocal= 1
Thread-1 localCounter= 2 threadlocal= 1
Thread-3 localCounter= 3 threadlocal= 1
Thread-4 localCounter= 4 threadlocal= 1
Thread-5 localCounter= 5 threadlocal= 1
Thread-6 localCounter= 6 threadlocal= 1
Thread-7 localCounter= 7 threadlocal= 1
Thread-8 localCounter= 8 threadlocal= 1
Thread-9 localCounter= 9 threadlocal= 1
Thread-10 localCounter= 10 threadlocal= 1
 */
