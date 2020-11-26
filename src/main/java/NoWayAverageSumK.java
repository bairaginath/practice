import java.util.Arrays;
import java.util.stream.IntStream;

public class NoWayAverageSumK {


    static int noWayAverageSum(int a[],int k,int sum)
    {
        System.out.println(Arrays.toString(a));
        if(a.length==1 && sum==a[0])
            return 1;
        if(a.length<=1)
            return 0;
//        int s=Arrays.stream(a).sum();
//        if(s==sum)
//            return 1;
        int total=0;
        for(int i=a.length-1;i>=0;i--) {
            int b[]=new int[a.length-1];
            System.arraycopy(a,0,b,0,i);
            System.arraycopy(a,i+1,b,i,a.length-1-i);
            //System.out.println(Arrays.toString(b));
            int x=noWayAverageSum(b,k,sum-a[i]);
            int y=noWayAverageSum(b,k,k*b.length);
            total+=(x+y);
        }
        return total;


    }


    public static void main(String[] args) {
       int a[] = {3, 6, 2, 8, 7, 6, 5, 9};
        //int a[] = {2,3};
        int K = 5;
        Arrays.sort(a);
        System.out.println(noWayAverageSum(a,K,K*a.length));
    }
}
