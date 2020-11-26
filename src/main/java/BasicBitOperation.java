

import java.lang.annotation.Native;

public class BasicBitOperation {
	
	public static int countSetBits(int x)
	{
	    int count = 0;
	    while (x!=0)
	    {	      
	      x &= (x-1) ;
	      count++;
	    }
	    return count;
	}
	
	public static int add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	public static int subtract(int x, int y)
	{
	    // Iterate till there is no carry
	    while (y != 0)
	    {
	        // borrow contains common set bits of y and unset
	        // bits of x
	        int borrow = (~x) & y;
	 
	        // Subtraction of bits of x and y where at least
	        // one of the bits is not set
	        x = x ^ y;
	 
	        // Borrow is shifted by one so that subtracting it from
	        // x gives the required sum
	        y = borrow << 1;
	    }
	    return x;
	}
	
	
	public static int multiple(int a,int b){
		int result=0;
		while(a!=0){
			if(a%2==1){
				result+=b;
			}
			a>>=1;
	        b<<=1;
		}
		return result;
	}
	
	 
	public static int division(int a,int b){
		int result=0;
		while(a!=0){
			if(a%2==1){
				result+=b;
			}
			a>>=1;
	        b<<=1;
		}
		return result;
	}


    public static void main(String[] args) {
    	

    	int number=Integer.parseInt("0111111111111111111111111111111",2); //binary to decimal
    	System.out.println("number = "+number);
    	String binaryString=Integer.toBinaryString(number); // Decimal to Binary
    	System.out.println("binaryString "+binaryString);
    	
    	String octalString=Integer.toOctalString(number); 
		System.out.println("Integer to OctalString "+octalString);
		System.out.println("OctalString to Interger  "+Integer.parseInt(octalString,8));
		
		
		String hexaString=Integer.toHexString(number); 
		System.out.println("Integer to HexString "+hexaString);
		System.out.println("HexString to Interger  "+Integer.parseInt(hexaString,16));		
		int   hexa = 0x3fffffff;
		System.out.println("HexaString "+hexa);
		
    	//right shift >> (divid)
		System.out.printf("%d divid by 2  = %d\n",number,(number>>1));
		System.out.printf("%d divid by 2^%d  = %d\n",number,6,+(number>>6));
		System.out.println("right shift are not communicate 1>>5==5>>1 "+((1>>5)==(5>>1)));
		//left shift << (multiple)
		System.out.printf("%d multiple by 2  = %d\n",number,(number<<1));
		System.out.printf("%d multiple by 2^%d  = %d\n",number,6,+(number<<6));
		System.out.println("left shift are not communicate 4<<5==5<<4 "+((4<<5)==(5<<4)));
		
		//Round right shift (>>>)
		System.out.printf("%d divid by 2  = %d\n",number,(2147483641>>>1));
		System.out.printf("%d divid by 2^%d  = %d\n",number,6,+(2147483647>>>6));
		
		
		System.out.printf("Bitwise XOR %d^%d=%d \n",7,6,7^6);
		System.out.printf("Bitwise OR %d|%d=%d \n",7,6,7|6);
		System.out.printf("Bitwise AND %d&%d=%d \n",7,6,7&6);
		System.out.printf("1's components ~%d=%d \n",7,~7);
		System.out.printf("1's components ~%d=%d \n",-7,~(-7));
		
		String positiveBinaryString=Integer.toBinaryString(50);
		//positive values are store in normal binary  form and msb is 0
		System.out.println("PositveBinaryString of 50 "+positiveBinaryString);
		String negativeBinaryString=Integer.toBinaryString(-50);
		//negative values are store in two's complement form (i.e flip and add 1) and msb is 1
		System.out.println("NegativeBinaryString of -50 "+negativeBinaryString);
		
		System.out.println("positive binary string to integer "+Integer.parseInt(positiveBinaryString, 2));
		
		System.out.println("negative binary string to integer "+Integer.parseInt(negativeBinaryString.substring(1), 2));
		System.out.println("negative binary to two's complement to get original value "+(short)Integer.parseInt(negativeBinaryString.substring(1), 2));
	    System.out.println("countSetBits "+countSetBits(5));
	    System.out.println(add(5,-9));
	    System.out.println(subtract(-4,7));
	    System.out.println(Integer.toBinaryString(~7));
	    System.out.println(multiple(5,-6));
	    float floatValue=(float)3.14;
	    System.out.println("float to hexadecimal "+Float.toHexString(floatValue));
	    System.out.println(Integer.toBinaryString(-5));
	    System.out.println(Integer.toBinaryString(-5>>1));
	   
    }
   
}