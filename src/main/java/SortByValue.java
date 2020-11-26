

import java.lang.*;
import java.util.*;


public class SortByValue {

   public static void main(String args[]){
         Map<String,Integer> map=new HashMap<>();
	 map.put("bairagi",5);
	 map.put("james",35);
	 map.put("kuna",4);

	 map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue()).forEach(e-> System.out.println(e.getKey()));


   }
 

}
