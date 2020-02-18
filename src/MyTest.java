
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Person {
	String name;
	String age;
	Person(String name,String age){
		this.name=name;
		this.age=age;
	}
	
	public String getAge() {
		return age;
	}
	
public String getName() {
	return name;
}
}
public class MyTest {
	
	static String parse(Person p){
		return p.age;
	}
	

	

	public static void main(String args[]) {
		List<Person> list=new ArrayList<>();
		list.add(new Person("bairagi1","30"));
		list.add(new Person("bairagi2","31"));
		list.add(new Person("bairagi3","30"));
		list.add(new Person("bairagi4","32"));
		
		Stream<String> strS=Stream.of("bairagi","nath","behera");
		List<String> slist=strS.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
		System.out.println(slist);
		
		
		
		Map<String,String> map=
				list.stream().collect(Collectors
				.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.joining(",","[","]"))));
		
		System.out.println(map);
		
		
		Map<String,Set<Person>> map1=
				list.stream().collect(Collectors
				.groupingBy(Person::getAge,TreeMap::new,Collectors.toSet()));
		
		System.out.println(map1);
				
			
		

//		 String output=map.entrySet().stream().map(e->
//		 {
//			 String combine=e.getValue().stream().map(Person::getName)
//	 .collect(Collectors.joining(",", "[", "]"));
//			 return e.getKey()+"="+combine;
//		 
//		 }).collect(Collectors.joining(",","",""));
		 
		// System.out.println(map);


	}

}
