
import java.util.*;

public class GcdSum {
	
	public static int gcd(int x,int y)
	{
	  int max=Math.max(x,y);
	  int min=Math.min(x,y);
	  if(max%min==0)
		  return min;
	  return gcd(max,max%min);
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
		int j=a.length-1;
		int memo[][]=new int[j+1][j+1];
		int k=4;
		for(int i=0;i<j-(k-2);i++)
		gcdSum(a,memo,k,i,j);		
		Arrays.stream(memo).forEach(x->System.out.println(Arrays.toString(x)));		
		//System.out.println(Arrays.toString(memo));
		
		
		
	}
	
}