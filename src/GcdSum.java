
import java.util.*;

public class GcdSum {
	
	public static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
	  
	
	


	
	
	public static void main(String args[]){
		int a[]={4,5,3,7,8,10,5,8};

		//int j=a.length-1;
		int K=6;
		int memo[][]=new int[(K/2)+1][a.length];
		int jump[][]=new int[(K/2)+1][a.length];
		for(int k=2;k<=K;k=k+2){
			//int index=a.length-1;
			for(int i=a.length-2;i>=0;i--)
			{ 
		      int max=memo[(k/2)][i+1];
			  //int index=jump[(k/2)][i+1];
			  int index=0;
			  int prevMax=max;
			  for(int j=i+1;j<a.length-(k-2);j++)
			  {  
		        int g=gcd(a[i],a[j]);				
		         max=Math.max(max,g+memo[k/2-1][j==a.length-1?j:j+1]);
				 index=max!=prevMax?j:index;
				 prevMax=max;				
			  }			  
			  memo[k/2][i]=max;
			  jump[k/2][i]=index;
			}
		}
		
		System.out.println("cost matrix ");
		Arrays.stream(memo).forEach(x->System.out.println(Arrays.toString(x)));
        System.out.println("jump matrix ");		
		Arrays.stream(jump).forEach(x->System.out.println(Arrays.toString(x)));	
	
		
		for(int k=K;k>=2;k=k-2)
		{
			   for(int i=0;i<a.length;i++)
			   {
				      if(jump[k/2][i]!=0)
					  { System.out.println(a[i]+" "+a[jump[k/2][i]]);break;}
			   }
		}
		
		
            			
		

		
		
		
	}
	
}