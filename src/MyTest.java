import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyTest {

	static int activityNotifications(int[] expenditure, int d) {
		

		ConcurrentSkipListMap<Integer, Long> cmap = Arrays.stream(expenditure, 0, d).boxed().collect(Collectors
				.groupingByConcurrent(Function.identity(), ConcurrentSkipListMap::new, Collectors.counting()));

		int median=0;
		int result = 0;
		for (int i = d; i < expenditure.length; i++) {
             System.out.println(cmap);
			if (d % 2 == 1) {
				long index = 0;
				median = 0;
				for (Entry<Integer, Long> e : cmap.entrySet()) {
					index = index + e.getValue();
					if (index >d / 2)
						{ median = e.getKey();break; }
					
				}

			} else {
				long index=0;
				median = 0;
				int c=0;
				for (Entry<Integer, Long> e : cmap.entrySet()) {
					index = index + e.getValue();
					if (index >= d / 2)
					{ median =median+e.getKey();c++; if(c==2)break;  }
						
					
				}
				
				
			}
			 
			 int dmedian=d%2==1?2*median:median;
			 System.out.println(dmedian);
			if (dmedian <= expenditure[i])
				result++;
			if(cmap.get(expenditure[i-d])==1)
				cmap.remove(Integer.valueOf(expenditure[i-d]));
			cmap.computeIfPresent(expenditure[i-d],(k,v)->v-1);
			Long value=cmap.computeIfPresent(expenditure[i],(k,v)->v+1);
			if(value==null)cmap.put(expenditure[i],Long.valueOf(1));
			
			

		}

		return result;
	}

	public static void main(String args[]) {

		int ex[] = { 2, 3, 4, 2, 3, 6, 8, 4, 5 };
		int d = 5;
		System.out.println(activityNotifications(ex, d));

	}
}
