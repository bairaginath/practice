

import java.util.*;
import java.util.stream.*;

public class OddCountDP {

     public static int oddCount(int a[][]){

     	int res=0;
     	int N=a.length;
     	int mem[]=a[0]; int temp[];
        for(int i=1;i<N;i++){
             temp=new int[mem.length*2];
             //System.out.println(temp.length);
             int x=0,j=0;
             for(;j<mem.length;j++)
             { temp[j]=mem[x]+a[i][0];x++ ;}
             x=0;
            for(;j<temp.length;j++)
             { temp[j]=mem[x]+a[i][1];x++ ;}
            mem=temp;
            //System.out.println(Arrays.toString(mem));

        }

        res=(int)Arrays.stream(mem).filter(x->x%2==1).count();
     	return res;
     }

	public static void main(String args[]){
		int a[][]=new int[][] {{12,2},{9,4},{11,6}};
        System.out.println(oddCount(a));

	}
}

