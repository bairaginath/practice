class Account
{
	String Id;
	public Account(String Id) {
		this.Id=Id;
	}
	
	@Override
	public String toString() {
		return this.Id;
	}
	
}


public class AccuntDeadLock {
	
	static void transfer(Account from,Account to){
		System.out.println(Thread.currentThread().getName()+" transfer  from "+from+" to "+to);
		
		synchronized(from){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(to){
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Account a=new Account("a");
		Account b=new Account("b");
		Thread t1=new Thread(()->transfer(a, b));
		Thread t2=new Thread(()->transfer(b, a));
		t1.start();
		t2.start();
		
		
	}

}
