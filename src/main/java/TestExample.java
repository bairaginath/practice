import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExample {
	
	
static	int fibo(int n,int memo[]) {
		
		if(n==1 || n==0 ||n==2)
			return 1;
		memo[n-1]=fibo(n-1,memo);
		memo[n-2]=fibo(n-2,memo);
		memo[n-3]=fibo(n-3,memo);
		  
		return memo[n-1]+memo[n-2]+memo[n-3];
		
	}
	
	
	public static void main(String[] args) {
		
		
		int memo[]=new int[10];
		int result=fibo(10,memo);
		System.out.println(Arrays.toString(memo));
				
				
	}

}
