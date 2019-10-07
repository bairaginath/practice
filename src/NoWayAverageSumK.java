import java.util.Arrays;
import java.util.stream.IntStream;

public class NoWayAverageSumK {


    static int noWayAverageSum(int a[],int sum)
    {

        for(int i=a.length-1;i>=0;i--) {
            int b[]=new int[a.length-1];
            System.arraycopy(a,0,b,0,i);
            System.arraycopy(a,i+1,b,i,a.length-1-i);
            System.out.println(Arrays.toString(b));
        }



          return 0;

    }


    public static void main(String[] args) {
        int a[] = {3, 6, 2, 8, 7, 6, 5, 9};
        int K = 5;
        Arrays.sort(a);
        System.out.println(noWayAverageSum(a,K*a.length));
    }
}
