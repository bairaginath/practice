
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.util.converter.CharacterStringConverter;

public class MyTest {

	static String findLongestPalindrome(String str) {
		
		String s[] = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			s[i] = String.valueOf(str.charAt(i));
		}
		Map<String, Long> map = Arrays.stream(s)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		String beg = "", mid = "", end = "";

		for (String x : map.keySet()) {
			if (map.get(x) % 2 == 1) {
				mid = x;
				map.put(x, map.get(x) - 1);
			} else{
				
				for (int i = 0; i < map.get(x) / 2; i++)
					beg += x;
			}
			System.out.println("mid="+mid+" beg="+beg);
		}
		end = beg;

		end = new String(new StringBuilder(beg).reverse());
		return beg + mid + end;

	}

	public static void main(String args[]) {
		System.out.println(findLongestPalindrome("abbaccd"));
		Arrays.stream(new int[]{1,2,3,4});
		"bairagi".chars().boxed().forEach(System.out::println);;

	}

}
