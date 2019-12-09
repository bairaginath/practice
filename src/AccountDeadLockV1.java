


import java.util.concurrent.locks.ReentrantLock;


public class AccountDeadLockV1 {
	
	class Account {
	     String Id;
	     int amount;

	     public Account(String Id, int amount) {
	           this.Id = Id;
	           this.amount = amount;
	     }

	     @Override
	     public String toString() {
	           return "Account [Id=" + Id + ", amount=" + amount + "]";
	     }

	}


     static ReentrantLock lock = new ReentrantLock();
     
     static void withDraw(Account a,int amount){
    	 
    	 try {
             Thread.sleep(4000);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
    	 a.amount=a.amount-amount;
     }

     static void transfer(Account from, Account to,int amoutToTranfer) {
           System.out.println(Thread.currentThread().getName() + " transfer  from " + from + " to " + to);

           lock.lock();
           if(from.amount-amoutToTranfer<0)
           {System.out.println(Thread.currentThread().getName()+"  No Money can't tranfer");
           lock.unlock();
           return;}
           System.out.println(Thread.currentThread().getName() + " entered LOCK block..");
           try {
                Thread.sleep(4000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }

           from.amount=from.amount-amoutToTranfer;
           to.amount=to.amount+amoutToTranfer;

           try {
                Thread.sleep(4000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName() + " from: " + from + ", to: " + to);
           lock.unlock();
           System.out.println(Thread.currentThread().getName() + " came out of LOCK block..");
     }

     public static void main(String[] args) {
    	 
    	 AccountDeadLockV1 ad=new AccountDeadLockV1();

           Account a =ad.new Account("a", 500);
           Account b =ad.new Account("b", 0);
           Thread t1 =new Thread(() -> transfer(a, b,500));
           Thread t2 = new Thread(() -> withDraw(a,500));
           t1.start();
           t2.start();

     }

}



