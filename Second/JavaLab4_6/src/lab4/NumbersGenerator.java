package lab4;

public class NumbersGenerator {
	private int[] array;
	private int size;
	private boolean isPrint;

	public NumbersGenerator(int size, boolean isPrint) {
		this.size = size;
		this.isPrint = isPrint;
	}

	public int[] classic(int min, int max) {
		array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = (int) (Math.random() * (max - min)) + min;
			if (isPrint)
				System.out.print(array[i] + " ");
		}
		return array;
	}

	public int[] sortedAscending() {
		array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
			if (isPrint)
				System.out.print(array[i] + " ");
		}
		return array;
	}

	public int[] sortedDescending() {
		array = new int[size];
		for (int i = size - 1; i > 0; i--) {
			array[i] = i;
			if (isPrint)
				System.out.print(array[i] + " ");
		}
		return array;
	}

	public int[] sortedHalf() {
		array = new int[size];
		int sub = 0;
		for (int i = 0; i < size; i++) {
			if (size / 2 > i)
				array[i] = i;
			else {
				sub++;
				array[i] = size - sub;
			}
		}
		if (isPrint)
			for (int i = 0; i < size; i++)
				System.out.print(array[i] + " ");
		return array;
	}

	public int[] sortedPermutations() {
		array = new int[size];
		int i0 = (int) (Math.random() * size - 1);
		int i1 = (int) (Math.random() * size - 1);
		for (int i = 0; i < size; i++)
			array[i] = i;

		int val = array[i1];
		array[i1] = array[i0];
		array[i0] = val;

		for (int i = 0; i < size; i++)
			if (isPrint)
				System.out.print(array[i] + " ");

		return array;
	}

	public int[] repeater(int min, int max) {
		array = new int[size];
		int[] base;
		int bSize = 0;
		if (size > 0 && size < 10)
			bSize = size / 2;
		else if (size >= 10 && size < 20)
			bSize = size / 5;
		else if (size >= 20 && size < 100)
			bSize = size / 10;
		else if (size >= 100 && size < 1000)
			bSize = size / 20;
		else
			bSize = size / 100;

		base = new int[bSize];
		for (int i = 0; i < bSize; i++)
			base[i] = (int) (Math.random() * (max - min)) + min;

		int numRepeats = size / bSize;
		int j = 0;
		for (int i = 0; i < size; i++) {
			array[i] = base[j];
			if(j == bSize - 1)
				j = 0;
			else
				j++;
		}
		
		for (int i = 0; i < size; i++)
			if (isPrint)
				System.out.print(array[i] + " ");
		return array;
	}
}
