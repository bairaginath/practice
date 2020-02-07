
import java.util.LinkedHashMap;

public class MyTest {

	public static void main(String args[]) {
		
		LinkedHashMap<Integer,String> map=new LinkedHashMap<>(16, .75f, true);
		map.put(1,"bairagi");
		map.put(1,"bairagi");
		map.put(2,"bairagi");
		map.put(3,"bairagi");
		map.put(4,"bairagi");
		map.put(5,"bairagi");
		
		map.forEach((k,v)->System.out.println(k+" "+v));
		map.get(3);
		map.forEach((k,v)->System.out.println(k+" "+v));
		

	}

}
