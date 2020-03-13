

import java.util.*;


public class SubArraySum {
	
	static int subArraySum(int a[],int memo[][],int k,int l)
	{
		if(l>=a.length)
			return 0;
	  int max=Integer.MIN_VALUE;	  
	  for(int j=l ;j<a.length;j++){
		  for(int i=0;i<k;i++){
		  max=Math.max(max,memo[i][j]+subArraySum(a,memo,k,j+i+2));
	  }
	  }
	  return max;
	}
	  
		  
	  
	
	
	
	public static void main(String args[]){
		
		int a[]={-1,2,-3,4,5};
		//int a[]={1,1,1,1,1};
		int k=1;
		//int k=1;
		int memo[][]=new int[k][a.length];
		
		for(int i=0;i<k;i++)
		{ 
	      int l=0;
		   while(l<=i){ memo[i][0]+=a[l];l++; }
		   for(int j=1;j<a.length;j++)
		   {
			   //System.out.println(i+" "+j+" "+(j+i));
			   memo[i][j]=j+i<a.length?memo[i][j-1]-a[j-1]+a[j+i]:0;
		   }
		}
		Arrays.stream(memo).forEach(x-> System.out.println(Arrays.toString(x)));
		
		System.out.println(subArraySum(a,memo,k,0));
		
		
	}
	
}
		
		
		
	