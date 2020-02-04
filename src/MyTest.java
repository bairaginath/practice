import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

class Java8Generic {
	
	static <T> T getObject(){
		return null;
	}
	
	static <T> T getNewObject(Class<T> gClass) {
		try {
			return gClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

public class MyTest {
	
	


    public static void main(String args[]){
      
      
       List<String> list=new ArrayList<>();
       list.add("james");
       list.add("world");
       list.add("james");
       list.add("bairagi");
       Map<String,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       map.forEach((k,v)->System.out.println(k+" "+v));
       
       map.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByKey())
       .forEach(e->System.out.println(e));
       
       Map<String,Long> map1=map.entrySet().stream().sorted(Map.Entry.comparingByKey())
       .collect(Collectors.toMap(Entry::getKey, Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
       
       System.out.println("=================");
       map1.entrySet().stream().forEach(System.out::println);
       
       System.out.println(Map.Entry.comparingByKey().getClass());
       System.out.println(Map.Entry.<String,Integer>comparingByKey().getClass().getName());
       
       String ob=Java8Generic.getObject();
       System.out.println(ob);
       String str=Java8Generic.getNewObject(String.class);
       System.out.println(str.getClass());
       
    }

      }
