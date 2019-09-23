


public class OddCount {
	
	public static int oddCount(int a[][],int N,int sum){
		
		if(N<=-1){
			System.out.println("sum "+sum);
			 return (sum%2);
	    }
		int x=oddCount(a,N-1,sum+a[N][0]);	 
		int y=oddCount(a,N-1,sum+a[N][1]);
		//System.out.println("x "+x+" y "+y);
      return x+y;		
	}
	
	
	
	
public static void main(String args[]){
	
	System.out.println(oddCount(new int[][]{{10,12},{8,6},{3,4},{1,2}},3,0));
	
}

}

   