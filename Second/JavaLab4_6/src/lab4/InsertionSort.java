package lab4;

public class InsertionSort implements SortStrategy {
	@Override
	public int[] sort(int[] array) {

		long time = System.nanoTime();

		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = i - 1;
			while (j >= 0 && current < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			// в этой точке мы вышли, так что j так же -1
			// или в первом элементе, где текущий >= a[j]
			array[j + 1] = current;
		}

		time = System.nanoTime() - time;
		System.out.printf("InsertionSort: %,9.3f ms\n", time / 1_000_000.0);
		return array;
	}
}
