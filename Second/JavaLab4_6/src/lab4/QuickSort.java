package lab4;

public class QuickSort implements SortStrategy {
	@Override
	public int[] sort(int[] array) {
		long time = System.nanoTime();

		quickSort(array, 0, array.length - 1);

		time = System.nanoTime() - time;
		System.out.printf("QuickSort: %,9.3f ms\n", time / 1_000_000.0);
		return array;
	}

	private void quickSort(int[] array, int begin, int end) {
		if (end <= begin)
			return;
		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	private int partition(int[] array, int begin, int end) {
		int pivot = end;

		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;

		return counter;
	}
}
