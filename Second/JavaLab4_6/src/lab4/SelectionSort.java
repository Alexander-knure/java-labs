package lab4;

public class SelectionSort implements SortStrategy {
	@Override
	public int[] sort(int[] array) {
		long time = System.nanoTime();

		for (int i = 0; i < array.length; i++) {
			int min = array[i];
			int minId = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[j] < min) {
					min = array[j];
					minId = j;
				}
			int temp = array[i];
			array[i] = min;
			array[minId] = temp;
		}

		time = System.nanoTime() - time;
		System.out.printf("SelectionSort: %,9.3f ms\n", time / 1_000_000.0);
		return array;
	}
}
