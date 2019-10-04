

public class Recursive {

  static long counter=0;
    static void recursive(int arr[]) {
        System.out.println("counter= "+(++counter));
	System.out.println(arr.hashCode());
	recursive(arr);
	}

	public static void main(String args[]){
	 int a[]={1,2,3,4,5,6,7,8,9,10};
	 recursive(a);
	 }


	 }
