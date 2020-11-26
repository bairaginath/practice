
import java.util.*;

public class SubSeqDiffLessOne
{
	
	static int[] getTotalSubseq(int length){
		int subseq[]=new int[length];
		int j=length-2;
		for(int i=0;i<length-1;i++){
			subseq[j]=2*subseq[j+1]+1;
			j--;
		}
	return subseq;
	}
	
	
public static void main(String args[]){

  int a[]={1,6,2,1,9};

  //int a[]={1,6,2,1};
  int subseq[]=getTotalSubseq(a.length);
  //System.out.println(Arrays.toString(subseq));
  //int subseq[]={15,7,3,1,0};
  int memo[]=new int[a.length];
  for(int i=a.length-2;i>=0;i--){
	  memo[i]=2*memo[i+1];
	  for(int j=i+1;j<a.length;j++){		  
		  //memo[i]+=Math.abs(a[i]-a[j])<=1 ? 1+(a.length-(j+1))-memo[j]:0;
		  memo[i]+=Math.abs(a[i]-a[j])<=1 ? 1+subseq[j]-memo[j]:0;
		  //System.out.println(Arrays.toString(memo));
	  }	  
	  }
	  
   System.out.println(Arrays.toString(memo));
   System.out.println(memo[0]);
	  
  

}
	



}
