import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Task extends RecursiveAction {

	int arr[];

	Task(int arr[]) {
		this.arr = arr;
		//System.out.println("in side constructor");
	}

	public static int[] merge(int left[], int right[]) {
		int m = left.length;
		int n = right.length;
		int temp[] = new int[m + n];
		int i = 0, j = 0, k = 0;
		for (; i < m && j < n && k < m + n; k++) {
			if (left[i] < right[j]) {
				temp[k] = left[i];
				i++;
			} else {
				temp[k] = right[j];
				j++;
			}
		}
		if (i < m) {
			for (; i < m && k < m + n; i++, k++) {
				temp[k] = left[i];
			}
		}
		if (j < n) {
			for (; j < n && k < m + n; j++, k++) {
				temp[k] = right[j];
			}
		}

		return temp;

	}

	@Override
	protected void compute() {
		if (arr.length == 1)
			return;
		if (arr.length == 2) {
			if (arr[0] > arr[1]) {
				arr[1] = arr[0] + arr[1];
				arr[0] = arr[1] - arr[0];
				arr[1] = arr[1] - arr[0];
			}
		}
		int mid = arr.length >> 1;
		Task subtask1 = new Task(Arrays.copyOfRange(arr, 0, mid));
		Task subtask2 = new Task(Arrays.copyOfRange(arr, mid, arr.length));
		invokeAll(subtask1,subtask2);
		arr = merge(subtask1.arr, subtask2.arr);
	}

}

public class RecursiveActionExample {

	

	public static void main(String[] args) {
		
		int[] array = new Random().ints(100,1,100).toArray();		
		
	  System.out.println(Arrays.toString(array));
	  ForkJoinPool pool=new ForkJoinPool();
	  Task task=new Task(array);
	  pool.invoke(task);
	  System.out.println(Arrays.toString(task.arr));
	  
	
	}

}
