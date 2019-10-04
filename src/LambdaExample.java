import java.util.function.Function;

@FunctionalInterface
interface Uninary<E> {

    E apply();

}
public class LambdaExample {

       
      String name="jamesbond";
      public String getName(){
       return this.name;
       }
       public static void main(String args[]){
           LambdaExample le=new LambdaExample();
           Uninary<String> fun=le::getName;
	   System.out.println(fun.apply());
	   }



}




