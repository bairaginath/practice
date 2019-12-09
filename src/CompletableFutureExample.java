

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {


  static  void addOnCheckList()  {
        System.out.println("Inside addOnCheckList "+Thread.currentThread().getName());
      try {
          Thread.sleep(4000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

    void placeOrder() throws InterruptedException
    {
        Thread.sleep(4000);
    }

    void makePayment() throws InterruptedException
    {
        Thread.sleep(4000);
    }
    void sendConformation() throws InterruptedException
    {

        Thread.sleep(4000);
    }


    public static void main(String[] args)  {

        ExecutorService es= Executors.newFixedThreadPool(10);

       CompletableFuture<Void> cf = CompletableFuture.runAsync(()->addOnCheckList())
               .runAsync(()->addOnCheckList(),es);

      }





}
