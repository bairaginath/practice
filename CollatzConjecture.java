
import java.util.*;
import java.util.stream.*;

public class CollatzConjecture {

public static int collatzSeq(int n,Map<Integer,Integer> map){

	if(n==1){
		map.put(n,1);
		return 1;
	}
	if(map.get(n)!=null)
		return map.get(n);

	if(n%2==1){
		int x=collatzSeq(n*3+1,map);
		map.put(n,x+1);
		return x+1;
	}
	int x=collatzSeq(n/2,map);
		map.put(n,x+1);
		return x+1;


}


	public static void main(String args[]){
         Map<Integer,Integer> map=new HashMap<>();
         int n=50;
         for(int i=2;i<n;i++)
         collatzSeq(i,map);
     
		Map.Entry<Integer,Integer> entry= map.entrySet().stream().sorted(Map.Entry.
			<Integer,Integer> comparingByValue().reversed()).findFirst().orElse(null);

		System.out.println(entry.getKey()+"  "+entry.getValue());

	}
}