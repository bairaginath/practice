
import java.util.*;

public class PatternSearch
{
	  static int [] piTable(String pattern){
		  int i=0,j=1,n=pattern.length();
		   int p[]=new int [n];
		   while(i<n-1 && j<n && i<j){
			   if(pattern.charAt(i)==pattern.charAt(j))
				   i++;
			   else {
				   if(i!=0)
					   i=p[i-1];
			   }
			   p[j]=i;
			   j++;
		   }
		   
		   
		   return p;
	   }
	   
	   
	   static int kmpSearch(String text,String pattern){
		    
        int p[]=piTable(pattern);
		System.out.println(Arrays.toString(p));
        int j=0,i=0;        		
           while(j<pattern.length() && i<text.length()) {
			   System.out.println("i= "+i+" j= "+j);
			    if(pattern.charAt(j)!=text.charAt(i))
				{	j= j==0?0:p[j-1]; i=j==0?i+1:i; }
				else 
				{ j++;i++;}
			   
		   }		   
		   if(j==pattern.length())
			   return i-j;
		   else
			  return -1;
		}
		   
		   
			
		  
	
	
	
	
	public static void main(String args[]){
		
		//System.out.println(Arrays.toString((piTable("aabaabaaa")));
		System.out.println(kmpSearch("bairaginath","nath"));
		System.out.println(kmpSearch("abxabcabcaby","abcaby"));
		
	}
   



 }
