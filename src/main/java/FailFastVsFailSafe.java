import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class BreakFailFast<T> extends ArrayList<T> {

	public void decrementModCount() {
		this.modCount--;
	}

}

public class FailFastVsFailSafe {

	static void listModification(List<Integer> list) {
		Iterator<Integer> it = list.iterator();

		while (it.hasNext()) {
			Integer x = it.next();
			if (x == 7)
				list.remove(x);
		}
	}

	static void iteratorModification(List<Integer> list) {
		Iterator<Integer> it = list.iterator();

		while (it.hasNext()) {
			int x = it.next();
			if (x == 5)
				it.remove();
		}
	}

	public static void main(String[] args) {

		Stream<Integer> stream = IntStream.range(1, 11).boxed();
		Stream<Integer> stream1 = IntStream.range(1, 11).boxed();
		List<Integer> list = stream.collect(Collectors.toList());
		iteratorModification(list);
		System.out.println(list);
		List<Integer> list1 = stream1.collect(Collectors.toList());
		List<Integer> cowal = new CopyOnWriteArrayList<Integer>(list1);
		// cowal internally use COWSubListIterator, where remove method throws UOE
		try {
			iteratorModification(cowal);
		} catch (UnsupportedOperationException uoe) {
		}
		System.out.println(cowal);
		try {
			listModification(list);
		} catch (ConcurrentModificationException cme) {
		}
		System.out.println(list);

		listModification(cowal);
		System.out.println(cowal);

		BreakFailFast<Integer> ar = new BreakFailFast<>();
		ar.add(1);
		ar.add(2);
		ar.add(3);
		Iterator<Integer> it = ar.iterator();
		ar.add(4);
		ar.decrementModCount(); // if comment this line, will throw CME
		while (it.hasNext())
			System.out.println(it.next());

	}

}
