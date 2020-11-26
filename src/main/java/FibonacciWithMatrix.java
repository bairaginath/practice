
public class FibonacciWithMatrix {

	/* function that returns nth Fibonacci number */
	static int fib(int n) {
		int F[][] = new int[][] { { 1, 1,1,1 }, { 1, 0,0,0 },{0,1,0,0},{0,0,1,0} };
		if (n == 0)
			return 0;
		power(F, n - 1);

		return F[0][0];
	}

	static void multiply(int mat1[][], int mat2[][]) {
		
		
		int i, j, k; 
		int N=4;
		int res[][]=new int[mat1[0].length][mat2.length];
        for (i = 0; i < N; i++) 
        { 
            for (j = 0; j < N; j++) 
            { 
                res[i][j] = 0; 
                for (k = 0; k < N; k++) 
                    res[i][j] += mat1[i][k]  
                                * mat2[k][j]; 
            } 
        }
        for( i=0;i<res.length;i++) {
        	mat1[i]=res[i];
        }
		
//		
//		int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
//		int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
//		int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
//		int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
//
//		F[0][0] = x;
//		F[0][1] = y;
//		F[1][0] = z;
//		F[1][1] = w;
	}

	/* Optimized version of power() in method 4 */
	static void power(int F[][], int n) {
		if (n == 0 || n == 1)
			return;
		int M[][] = new int[][] { { 1, 1,1,1 }, { 1, 0,0,0 },{0,1,0,0},{0,0,1,0} };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int n = 1;
		System.out.println(fib(n));
	}
}
