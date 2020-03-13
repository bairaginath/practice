

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {


  static  void addOnCheckList()  {
        System.out.println("Inside addOnCheckList "+Thread.currentThread().getName());
      try {
          Thread.sleep(4000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

   static void placeOrder() 
    {
	   System.out.println("Inside placeOrder "+Thread.currentThread().getName());
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    static void makePayment() 
    {
 	   System.out.println("Inside makePayment "+Thread.currentThread().getName());
         try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
     }
    static void sendConformation()     {
 	   System.out.println("Inside sendConformation "+Thread.currentThread().getName());
       try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   }


    public static void main(String[] args) throws InterruptedException, ExecutionException  {
    	
    	 int processors = Runtime.getRuntime().availableProcessors();
    	 System.out.println(processors);
        //ExecutorService es= Executors.newFixedThreadPool(processors);
        
    	 CompletableFuture<Integer> finalResult =CompletableFuture.supplyAsync(() -> 10)
    			 .thenCompose(i->CompletableFuture.supplyAsync(() -> 10 + i));
    	 
    	 
    	 System.out.println(finalResult.get() == 20);
       
       

      }





}
