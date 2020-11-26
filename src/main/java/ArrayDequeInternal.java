import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayDequeInternal<E> extends ArrayDeque<E> {

	transient int head;
	transient int tail;
	transient Object[] elements;
	
	public ArrayDequeInternal(){
		elements = new Object[16];
	}
	
	private void doubleCapacity() {
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }
	
	public void addFirst(E e) {
        if (e == null)
            throw new NullPointerException();
        head = (head - 1) & (elements.length - 1);
        System.out.println("head = "+head);
        elements[head] = e;
        if (head == tail)
            doubleCapacity();
    }
	
	public void addLast(E e) {
        if (e == null)
            throw new NullPointerException();
        System.out.println("tail = "+tail);
        elements[tail] = e;
        tail = (tail + 1) & (elements.length - 1);
        if (tail == head)
            doubleCapacity();
    }
	
	
	
		
	public static void main(String[] args) {
		ArrayDequeInternal<Integer> ad=new ArrayDequeInternal<Integer>();
		ad.addFirst(1);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(16);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(2);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(15);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(3);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(14);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(4);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(13);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(5);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(12);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(6);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(11);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(7);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(10);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(8);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(9);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addFirst(17);
		System.out.println(Arrays.deepToString(ad.elements));
		ad.addLast(32);
		ad.toString();
		System.out.println(Arrays.deepToString(ad.elements));
		
	}
 
}
/*
head = 15
[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1]
tail = 0
[16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1]
head = 14
[16, null, null, null, null, null, null, null, null, null, null, null, null, null, 2, 1]
tail = 1
[16, 15, null, null, null, null, null, null, null, null, null, null, null, null, 2, 1]
head = 13
[16, 15, null, null, null, null, null, null, null, null, null, null, null, 3, 2, 1]
tail = 2
[16, 15, 14, null, null, null, null, null, null, null, null, null, null, 3, 2, 1]
head = 12
[16, 15, 14, null, null, null, null, null, null, null, null, null, 4, 3, 2, 1]
tail = 3
[16, 15, 14, 13, null, null, null, null, null, null, null, null, 4, 3, 2, 1]
head = 11
[16, 15, 14, 13, null, null, null, null, null, null, null, 5, 4, 3, 2, 1]
tail = 4
[16, 15, 14, 13, 12, null, null, null, null, null, null, 5, 4, 3, 2, 1]
head = 10
[16, 15, 14, 13, 12, null, null, null, null, null, 6, 5, 4, 3, 2, 1]
tail = 5
[16, 15, 14, 13, 12, 11, null, null, null, null, 6, 5, 4, 3, 2, 1]
head = 9
[16, 15, 14, 13, 12, 11, null, null, null, 7, 6, 5, 4, 3, 2, 1]
tail = 6
[16, 15, 14, 13, 12, 11, 10, null, null, 7, 6, 5, 4, 3, 2, 1]
head = 8
[16, 15, 14, 13, 12, 11, 10, null, 8, 7, 6, 5, 4, 3, 2, 1]
tail = 7
[8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
head = 31
[8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 17]
tail = 16
[8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9, 32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 17]

*/