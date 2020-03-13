


public class Permutation
{
	
	   static void perm(String pre,String suffix){
		   if(suffix.length()<=1)
		       return;
		   
		   if(suffix.length()==2)
		   { 
	          System.out.println(pre+suffix);
	          System.out.println(pre+suffix.charAt(1)+suffix.charAt(0));
			   return ;
		   }
		   
		   for(int i=0;i<suffix.length();i++){
			  char p=suffix.charAt(i);
              String rest=suffix.replace(String.valueOf(p),"");			  
              perm(pre+p,rest);	
              		  
		   }
		   
		   
	   }
	   
	   
	   public static void main(String args[]){
         perm("","123456");		   
	   }
}