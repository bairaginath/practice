import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MyTest {
	
	static int activityNotifications(int[] expenditure, int d) {
		LinkedList<Integer> list=Arrays.stream(expenditure,0,d).sorted().boxed().
		collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
		int median;
		int result=0;
		for(int i=d;i<expenditure.length;i++){			
			
		if(d%2==1)
		{  median=list.stream().skip(d/2).findFirst().get(); median*=2;}
		else
			median=list.stream().skip(d/2-1).limit(2).reduce((x,y)->x+y).get();
		  //System.out.println(median);
		  if(median<=expenditure[i])
			  result++;
		  list.remove(Integer.valueOf(expenditure[i-d]));
		  for(int j=0;j<d-1;j++){
			 // System.out.println(list.get(j)+" add "+expenditure[i]);
			  if(list.get(j)>=expenditure[i])
			  {  list.add(j,expenditure[i]); break; }
		  }
		  if(list.size()==d-1)
			  list.add(expenditure[i]);
		  System.out.println(list);
		  
		}


		return result;
    }

	public static void main(String args[]) {
		
		int ex[]={2,3,4,2,3,6,8,4,5};
		int d=5;
		System.out.println(activityNotifications(ex, d));
		
		
		
		
		

	}
}
