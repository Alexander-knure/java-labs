package lab4;

public class ShellSort implements SortStrategy {
	@Override
	public int[] sort(int[] array) {
		long time = System.nanoTime();
		int n = array.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int key = array[i];
				int j = i;
				while (j >= gap && array[j - gap] > key) {
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = key;
			}
		}

		time = System.nanoTime() - time;
		System.out.printf("ShellSort: %,9.3f ms\n", time / 1_000_000.0);
		return array;
	}
}
