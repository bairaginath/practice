import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableExample {
	
	static  String addOnCheckList()  {
        System.out.println("Inside addOnCheckList "+Thread.currentThread().getName());
      try {
    	  Random r = new Random();
     	 int low = 1;
     	 int high = 10;
     	 int result = r.nextInt(high-low) + low;
			Thread.sleep(result*1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      return "";
  }

   static void placeOrder() 
    {
	   System.out.println("Inside placeOrder "+Thread.currentThread().getName());
        try {
        	Random r = new Random();
       	 int low = 1;
       	 int high = 10;
       	 int result = r.nextInt(high-low) + low;
			Thread.sleep(result*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    static void makePayment() 
    {
 	   System.out.println("Inside makePayment "+Thread.currentThread().getName());
         try {
        	 Random r = new Random();
        	 int low = 1;
        	 int high = 10;
        	 int result = r.nextInt(high-low) + low;
 			Thread.sleep(result*1000);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
     }
    static void sendConformation()     {
 	   System.out.println("Inside sendConformation "+Thread.currentThread().getName());
       try {
    	   Random r = new Random();
      	 int low = 1;
      	 int high = 10;
      	 int result = r.nextInt(high-low) + low;
			Thread.sleep(result*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   }

	
	public static void main(String[] args) {
		int processors = Runtime.getRuntime().availableProcessors();
   	 System.out.println(processors);
       ExecutorService es= Executors.newFixedThreadPool(processors);
      
//       CompletableFuture.supplyAsync(()->addOnCheckList(),es).thenRun(()->placeOrder());
       for(int i=0;i<1000;i++)
       CompletableFuture.runAsync(()->addOnCheckList(),es).thenRun(()->placeOrder());

//       CompletableFuture.supplyAsync(()->addOnCheckList(),es)).or.orTimeout(1, TimeUnit.SECONDS)
       
	}
	
	

}
