
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class MyTest {
	
	public int[] notAlone(int[] nums, int val) {
		  int length=nums.length;
		  
		  int result[]=java.util.stream.IntStream.range(0,length).map(i->
		    {
		      if(i==0 || i==length-1)
		         return nums[i];
		      else if(nums[i]==val)
		        return Math.max(nums[i-1],nums[i+1]);
		      else
		    	  return nums[i];
			  
		    }
		  ).toArray();
		  return result;
		}

	public static void main(String args[]) {
			

       
	}

}
