package lab4;

public class BubbleSort implements SortStrategy {
	@Override
	public int[] sort(int[] array) {
		long time = System.nanoTime();
		
		for (int i = 0; i < array.length - 1; i++)
			for (int j = 0; j < array.length - i - 1; j++)
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
		
		time = System.nanoTime() - time;
		System.out.printf("BubbleSort: %,9.3f ms\n", time/1_000_000.0);
		return array;
	}
}
