
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStream {

   public static void main(String args[]){
     int output=IntStream.range(1,10).reduce(7,(x,y)->x*y);
     System.out.println(output);
     List<Integer> list=IntStream.range(0,50).boxed().collect(Collectors.toCollection(LinkedList::new));
     System.out.println(list.size());
     Map<Integer,Long> map=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

     Map<Integer,Integer> map1=list.stream().collect(Collectors.toMap(Function.identity(),Function.identity()));
     Random random=new Random();
     //Stream.generate(random::nextInt).forEach(System.out::println);
     map1.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
             .forEach(System.out::println);


   }

   }
