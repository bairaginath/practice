

import java.util.Arrays;
import java.util.stream.IntStream;

public class UnrollLinkedList<T> {
	final int capacity;
	Unode<T> header;
	Unode<T> current;
	public UnrollLinkedList(int capacity){
		this.capacity=capacity;
	}
	class Unode<T>{
		Unode<T> next;
		int cursor=0;
		T data[];
		Unode(){
			this.next=null;
			this.data=(T[])new Object[capacity];
		}
		
	}
	
	void insert(T t) {
		if(header==null) {
			header=new Unode<T>();
			header.data[header.cursor]=t;
			header.cursor++;
			current=header;
		}
		else if(current.cursor<=capacity-1) {
			current.data[current.cursor]=t;
			current.cursor++;
		}
		else {
			Unode newNode=new Unode<T>();
			int shiftFromPoint=(capacity/2)+1;
			System.arraycopy(current.data,shiftFromPoint,newNode.data,0,
					capacity-shiftFromPoint);
			newNode.cursor=capacity-shiftFromPoint;
			current.cursor=shiftFromPoint;
			newNode.data[newNode.cursor]=t;
			newNode.cursor++;
			newNode.next=current.next;
			current.next=newNode;
			current=newNode;
		}
		System.out.println(current+Arrays.deepToString(current.data));
	}
	
	void display() {
		Unode<T> curr=header;
		while(curr!=null) {
			for(int i=0;i<curr.cursor;i++)
				System.out.println(curr.data[i]);
			curr=curr.next;
		}
	}
	
	public static void main(String[] args) {
		int n=10;
		UnrollLinkedList<Integer> ull=new UnrollLinkedList<Integer>(5);
		IntStream.rangeClosed(1,n).forEach(x->ull.insert(x));
		ull.display();
		
		}
	
	
	

}
