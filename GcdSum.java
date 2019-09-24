
import java.util.*;

public class GcdSum {
	
	public static int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
	  
	
	

public static int gcdSum(int a[],int memo[][],int k,int i,int j)
{
	if(k<=1)
		return 0;
	if(j-i<=k)
		return 0;
	if(memo[i][j]!=0)
		return memo[i][j];
	int max=0;
	 for(int x=i+1;x<j-(k-2);x++){
		 memo[i][x]=gcd(a[i],a[x]);
		 System.out.println(x);
	     memo[x+1][j]=gcdSum(a,memo,k-2,x+1,j);
		 max=Math.max(max,memo[i][x]+memo[x+1][j]);
	 }
	 memo[i][i]=max;
	 return max;
}
	
	
	public static void main(String args[]){
		int a[]={4,5,3,7,8,10,5,8};
		//int j=a.length-1;
		int K=4;
		int memo[][]=new int[(K/2)+1][a.length];
		int jump[][]=new int[(K/2)+1][a.length];
		for(int k=2;k<=K;k=k+2){
			for(int i=a.length-2;i>=0;i--)
			{ 
		      int max=memo[(k/2)][i+1];
			  int index=jump[(k/2)][i+1];
			  int prevMax=max;
			  for(int j=i+1;j<a.length-(k-2);j++)
			  {  
		        int g=gcd(a[i],a[j]);				
		         max=Math.max(max,g+memo[k/2-1][j==a.length-1?j:j+1]);
				 index=max!=prevMax?j:index;
				 prevMax=max;
				 System.out.println("i "+i+" j "+j+" k "+k+" g "+g+" max"+max+" index"+index);
			  }
			  memo[k/2][i]=max;
			  jump[k/2][i]=index;
			}
		}
			
			
			
		
		//for(int i=0;i<j-(k-2);i++)
		//gcdSum(a,memo,k,i,j);		
		Arrays.stream(memo).forEach(x->System.out.println(Arrays.toString(x)));
        System.out.println("jump index ");		
		Arrays.stream(jump).forEach(x->System.out.println(Arrays.toString(x)));		
		//System.out.println(Arrays.toString(memo));
		
		
		
	}
	
}