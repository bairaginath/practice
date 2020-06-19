
public class RecursiveReverseLinkedListEaxmple {
	
	static class Node {
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	
	private static void reverse(Node prev,Node curr) {
		if(curr.next==null) 
			return;
		prev=curr;
		curr=curr.next;
		reverse(prev,curr);
		curr.next=prev;
		
	}
	
	static void reverse(Node node) {
		Node curr=node.next;
		Node prev=node;
		reverse(prev,curr);
		curr.next=prev;
		prev.next=null;
	}
	
	static void display(Node node) {
		
		
		while(node!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		//display(n1);
		reverse(n1);
		System.out.println("display method");
		display(n5);
		
		
		
	}

}
