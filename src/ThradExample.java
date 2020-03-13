
public class ThradExample {
	
	public static void main(String[] args) {
		Runnable r1=()->System.out.println("james");
		Thread t1=new Thread(r1);
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(t1.isAlive());
		
	}
	

}
