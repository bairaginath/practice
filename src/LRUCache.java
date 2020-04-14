import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache<T> {
	LinkedList<T> cache;
	Set<T> checkForElementPresent; // maximum capacity of cache,used check element present or not 
	int frameSize;

	LRUCache(int frameSize) {
		this.frameSize = frameSize;
		this.cache = new LinkedList<>();
		this.checkForElementPresent = new HashSet<>();
	}

	public void refer(T t) {
		System.out.println("input "+t);
		/*
		 * The found page may not be always the last element, even if it's an
		 * intermediate element that needs to be removed and added to the start of the
		 * Queue
		 */
		if (checkForElementPresent.contains(t)) {
			cache.removeLastOccurrence(t);
		} else {
			if (cache.size() >= frameSize) {
				T lastElement = cache.removeLast();
				checkForElementPresent.remove(lastElement);
			}
			
			checkForElementPresent.add(t);
		}
		cache.addFirst(t);
		System.out.println(cache);
	}
	
	public T getFirstElementFromCache() {
		return cache.getFirst();
	}
	
	public static void main(String[] args) {
		LRUCache<Integer> lru=new LRUCache<Integer>(3);
		int arr[]= {1,2,1,3,2,3,1,5,3,5,4,4,7,6};
		Arrays.stream(arr).forEach(lru::refer);
	}

}
