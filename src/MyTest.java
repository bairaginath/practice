
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class MyTest {

	public static void main(String args[]) {
		
		Map<Integer, String> studentsById = new HashMap<>();
		studentsById.put(1, "Foo");
		studentsById.put(2, "Bar");
		studentsById.put(3, "Baz");
		studentsById.put(4, "Qux");
		 
		List<Map.Entry<Integer, String>> shuffledStudentEntries
		 = new ArrayList<>(studentsById.entrySet());
		Collections.shuffle(shuffledStudentEntries);
		Map<Integer,String> aftershuffle=shuffledStudentEntries.stream()
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v1,
						()->new LinkedHashMap<>()));
		aftershuffle.entrySet().forEach(System.out::println);
		

	}

}
