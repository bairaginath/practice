import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Number;

public class ForEachVsStreamForEach {
	
	 static void simillary(List<Integer> list) {
		 
		 try {
			 list.forEach(i -> {
				System.out.println(i);
				System.out.println(50 / i );
			}); 
			
		 } catch(Exception e) {e.printStackTrace();}
		 try {
		 list.stream().forEach(i-> {
				System.out.println(i);
			System.out.println(50/i);
			});
		 }catch(Exception e) {e.printStackTrace();}

		
	}

	public static void main(String[] args) {

		int a[] = { 0, 1, 2, 3, 4, 5, 6 };

		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

		
		simillary(list);
	}

}
