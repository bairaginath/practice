
import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class MyStream {

   public static void main(String args[]){
     int output=IntStream.range(1,10).reduce(7,(x,y)->x*y);
     System.out.println(output);

   }

   }
