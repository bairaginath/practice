package practice;


class Node<T> {
    private T data;
    private Node<T> next;
    Node(T data,Node<T> next){
        this.data=data;
        this.next=next;
    }
        public T getData(){
            return  this.data;
        }
        public void setData(T data){
            this.data=data;
        }
        public Node<T> getNext(){
            return this.next;
        }
        public void setNext(Node<T> next){
            this.next=next;
        }
    }
    
 class LinkedList<T> {
     protected Node<T> head;
     protected Node<T> tail;
     
     public boolean isEmpty(){
         return head==null&& tail==null ?true:false;
     }
     
     public void insertInFront(T data){
         Node node=new Node(data,null);
         if(head==null)
           { head=node; 
             tail=head;
             return; }
        node.setNext(head);
        head=node;
         
     }
     public void insertAtBack(T data){
         Node node=new Node(data,null);
         if(tail==null){
             tail=node;
             head=tail;
             return;
         }
         tail.setNext(node);
         tail=node;
     }
     public T deleteFromFront(){
    	 if(isEmpty())
    		 return null;
         T data=head.getData();
         head=head.getNext();
         if(head==null)
        	 tail=null;
         return data;
     }
     
     
 }
 
 class QueueByAggregation<T> {
     private LinkedList<T> qList;
     QueueByAggregation(){}
     
     public boolean isEmpty(){
         return this.qList==null?true:qList.isEmpty();
     }
     
     public void enqueue(T data){
         if(this.qList==null)
           this.qList=new LinkedList();
         this.qList.insertAtBack(data);
     }
     public T deque(){
         return this.qList.deleteFromFront();
     }
     
     public T peek(){
         return this.qList.isEmpty()?null:qList.head.getData();
     }
     

 }
 
 class StackByInheritance<T> extends LinkedList<T>{
     
     public void push(T data){
         insertInFront(data);
     }
     public T pop(){
         return deleteFromFront();
     }
     
     public T peek(){
         return isEmpty()? null :head.getData();
     }
 }
 
 
    
 public class CustomListSupportStackAndQueue {
    
    public static void main(String args[]){
        Node<Integer> node=new Node<>(1,null);
        QueueByAggregation<Integer> q=new QueueByAggregation<>();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.peek());
        StackByInheritance<Integer> s=new StackByInheritance<>();
        s.push(11);
        s.push(12);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        LinkedList<Integer> l=new LinkedList<>();
        l.insertAtBack(33);
        System.out.println(l.deleteFromFront());
        System.out.println(l.deleteFromFront());
        
    }
}