import java.util.*;

public class SubSetSumUniqueDigit
{
    static boolean isDifferentDigits(Object a, Object b){
        String str1=String.valueOf(a);
        String str2=String.valueOf(b);
        for(int i=0;i<str1.length();i++)
            if(str2.contains(String.valueOf(str1.charAt(i))))
                return false;
        return true;
    }
    static int subSetSum(int a[]){
        a=Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int sum[]=new int[a.length];
        String digit[]=Arrays.stream(a).mapToObj(e->String.valueOf(e)).toArray(String[]::new);
        sum[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            for(int j=i+1;j<a.length;j++)
            {
                 if(isDifferentDigits(digit[i],digit[j])){
                     sum[i]=a[i]+sum[j];
                     digit[i]+=digit[j];
                     break;
                 }
                 else if(isDifferentDigits(digit[i],a[j])){
                     sum[i]=a[i]+a[j];
                     digit[i]+=String.valueOf(a[j]);
                 }
            }

        }
        System.out.println(Arrays.toString(sum));

        return sum[0];
    }


    public static void main(String args[]){

       // int a[]={22,132,4,45,12,223};
        int a[]={1,21,32,4,5};
        System.out.println(subSetSum(a));


    }

}
