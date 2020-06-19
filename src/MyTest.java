import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {

	
	
    
    public static void main(String[] args) throws Throwable{
       int arr[]= {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
    Map<Integer,Long> map=	Arrays.stream(arr)
    	.boxed().collect(Collectors.groupingBy(k->k,
    			LinkedHashMap::new,Collectors.counting()));
    
    Map<Integer,Long> map1=  map.entrySet().stream().sorted(
    		Map.Entry.<Integer,Long>comparingByValue().reversed())
    		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
    				
    				(v1,v2)->v1,LinkedHashMap::new));
       
    
    System.out.println(map1);
        
    }
    
}

   