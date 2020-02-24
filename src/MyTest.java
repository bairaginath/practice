import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.IntStream;

public class MyTest {
	
	static int activityNotifications(int[] expenditure, int d) {
		ArrayList<Integer> list=new ArrayList<>();
		IntStream.range(0,d).forEach(i->list.add(expenditure[i]));
		PriorityBlockingQueue<Integer> queue=new PriorityBlockingQueue<>(list);	
		list.clear();
		int median;
		int result=0;
		for(int i=d;i<expenditure.length;i++){
			
			queue.drainTo(list);
			list.forEach(e->System.out.println("priority data"+e));
		if(d%2==1)
		{  median=list.stream().skip(d/2).findFirst().get(); median*=2;}
		else
			median=list.stream().skip(d/2-1).limit(2).reduce((x,y)->x+y).get();
		  System.out.println(median);
		  if(median<=expenditure[i])
			  result++;
		  System.out.println(list);
		  list.remove(Integer.valueOf(expenditure[i-d]));
		  
		  list.add(expenditure[i]);
		  queue=new PriorityBlockingQueue<>(list);
		  list.clear();
		}


		return result;
    }

	public static void main(String args[]) {
		
		int ex[]={2,3,4,2,3,6,8,4,5};
		int d=5;
//		System.out.println(activityNotifications(ex, d));
		
		PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(750);
        numbers.add(300);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);
        numbers.forEach(System.out::println);
        System.out.println(numbers.stream().skip(2).findFirst());
		
		
		

	}
}
