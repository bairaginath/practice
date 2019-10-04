
import java.util.*;
import java.util.stream.*;

public class CoinChangeCount {
	
	
public static int coinChangeCount(int total,int [] coins)
{
	 int sum=0;
   Arrays.sort(coins);

   Map<Integer, Integer> map = IntStream.range(0, coins.length).boxed().collect(Collectors.toMap(i -> coins[i], i -> i ));
   map.put(0,0);
	  int max=coins[coins.length-1];
	  int min=coins[0];
	  int result[]=new int[max+1];
	  for(int i=max;i>=min;i--)
	  {  
		 if(map.get(i)!=null){
			 
		 for(int j=max;j>i;j--)
		 {
			 
			 result[j]+=map.get(j%i)!=null?result[j%i]+result[i]+1:0;
		 }
		 }
	  }
	  System.out.println(Arrays.toString(result));
	  sum=IntStream.range(0, result.length).map(x->result[x]).sum();   
   return sum+1;
      
}

	
	
public static void main(String args[]){
	
	System.out.println(coinChangeCount(10,new int[]{2,3,5,6}));
	System.out.println(coinChangeCount(4,new int[]{1,2,3}));
	System.out.println(coinChangeCount(1000,new int[]{1,2,5,10}));
	
	
}

	
	
}
