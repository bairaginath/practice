


public class LambdaExample {

       
      String name="james";
      public String getName(){
       return this.name;
       }
       public void main(String args[]){
           LambdaExample le=new LambdaExample();
	   System.out.println(le::getName);
	   }

	   }




