package lab4;

import java.util.Scanner;
 
/*6. Паттерн Strategy. 
 * Разработать модель выбора способов сортировки и 
 * поиска максимального/минимального значения массива 
 * числовых объектов.
 * */
public class Demo {
	private static int[] numbers;
	private static SortStrategy strategy;
	private static Sorter sorter;
	private static NumbersGenerator ng;
	enum Mode {
		DEFAULT, ASCENDING, DESCENDING, HALF, PERMUTATIONS, REPEATER;

		public static Mode getTypeByOrdinal(int ordinal) {
			for (Mode t : Mode.values())
				if (t.ordinal() == ordinal)
					return t;
			return null;
		}
	};

	private static void normalTest() {
		Scanner scan = new Scanner(System.in);
		int size;
		while(true) {
		System.out.println("Введите размер массива: ");
		size = scan.nextInt();
		if(size <= 0)
			System.out.println("Размер указан неверно!");
		else
			break;
		}
		numbers = new int[size];
		System.out.print("Введите способ генерации:\n" + "0 - Default [3, 8, 1...]" + "\n"
				+ "1 - Ascending [1, 2, 3...]" + "\n" + "2 - Descending [9, 8, 7...]" + "\n"
				+ "3 - Half [1, 2... 5, 9, 8... 6]" + "\n" + "4 - Permutations [1, 2, {8}... 6, 7, {3}, 9]" + "\n"
				+ "5 - Repeater [0, 1, 2, 0, 1, 2, 0, 1, 2...]" + "\n");
		Mode genMode = Mode.getTypeByOrdinal(scan.nextInt());
		System.out.print("Печатать массив y/n?\n");
		String userInput = scan.next();
		
		if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"))
			ng = new NumbersGenerator(size, true);
		else
			ng = new NumbersGenerator(size, false);
	       
		int min = 0, max = 0;
		switch (genMode) {
		case DEFAULT:
			System.out.print("Введите минимальное значение: ");
			min = scan.nextInt();
			System.out.print("Введите максимальное значение: ");
			max = scan.nextInt();
			numbers = ng.classic(min, max);
			break;
		case ASCENDING:
			numbers = ng.sortedAscending();
			break;
		case DESCENDING:
			numbers = ng.sortedDescending();
			break;
		case HALF:
			numbers = ng.sortedHalf();
			break;
		case PERMUTATIONS:
			numbers = ng.sortedPermutations();
			break;
		case REPEATER:
			System.out.println("Введите минимальное значение: ");
			min = scan.nextInt();
			System.out.println("Введите максимальное значение: ");
			max = scan.nextInt();
			numbers = ng.repeater(min, max);
			break;
		default:
			System.out.println("Ошибка: введите от 1 до 6");
			break;
		}
		System.out.println("\nСортировка...");
		int[] sorted;
		sorter = new Sorter(numbers);
		switch (genMode) {
		case DEFAULT:
			if (size >= 10000 && size < 100000)
				strategy = new InsertionSort();
			else if (size >= 1000)
				strategy = new InsertionSort();
			else if (size >= 100)
				strategy = new InsertionSort();
			else if (size >= 10)
				strategy = new InsertionSort();
			else if (size > 0)
				strategy = new InsertionSort();
			else
				strategy = new MarginSort();
			break;
		case ASCENDING:
			if (size >= 10000 && size < 100000)
				strategy = new InsertionSort();
			else if (size >= 1000)
				strategy = new InsertionSort();
			else if (size >= 100)
				strategy = new InsertionSort();
			else if (size >= 10)
				strategy = new InsertionSort();
			else if (size > 0)
				strategy = new InsertionSort();
			else
				strategy = new MarginSort();
			break;
		case DESCENDING:
			if (size >= 10000 && size < 100000)
				strategy = new InsertionSort();
			else if (size >= 1000)
				strategy = new InsertionSort();
			else if (size >= 100)
				strategy = new ShellSort();
			else if (size >= 10)
				strategy = new ShellSort();
			else if (size > 0)
				strategy = new ShellSort();
			else
				strategy = new MarginSort();
			break;
		case HALF:
			if (size >= 10000 && size < 100000)
				strategy = new ShellSort();
			else if (size >= 1000)
				strategy = new InsertionSort();
			else if (size >= 100)
				strategy = new InsertionSort();
			else if (size >= 10)
				strategy = new ShellSort();
			else if (size > 0)
				strategy = new ShellSort();
			else
				strategy = new MarginSort();
			break;
		case PERMUTATIONS:
			if (size >= 10000 && size < 100000)
				strategy = new ShellSort();
			else if (size >= 1000)
				strategy = new InsertionSort();
			else if (size >= 100)
				strategy = new MarginSort();
			else if (size >= 10)
				strategy = new InsertionSort();
			else if (size > 0)
				strategy = new SelectionSort();
			else
				strategy = new MarginSort();
			break;
		case REPEATER:
			if (size >= 10000 && size < 100000)
				strategy = new ShellSort();
			else if (size >= 1000)
				strategy = new QuickSort();
			else if (size >= 100)
				strategy = new InsertionSort();
			else if (size >= 10)
				strategy = new ShellSort();
			else if (size > 0)
				strategy = new ShellSort();
			else
				strategy = new MarginSort();
			break;
		default:
			break;
		}
		sorted = sorter.sort(strategy);
		System.out.println("Печатать результат (y/n)? ");
		userInput = scan.next();
		if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
			for (int i = 0; i < size; i++)
				System.out.print(sorted[i] + " ");
			System.out.println();
			System.out.println("MAX: " + sorter.getMax());
			System.out.println("MIN: " + sorter.getMin());
		} else
			System.out.println("END PROGRAM");
		
		scan.close();
	}

	private static void chooseSort(int size, SortStrategy s0, SortStrategy s1, SortStrategy s2, SortStrategy s3, SortStrategy s4, SortStrategy s5)
	{
		if (size >= 10000 && size < 100000)
			strategy = s0;
		else if (size >= 1000)
			strategy = s1;
		else if (size >= 100)
			strategy = s2;
		else if (size >= 10)
			strategy = s3;
		else if (size > 0)
			strategy = s4;
		else
			strategy = s5;
	}
	private static void sorts(int[] numbers) {
		int[] sorted;
		strategy = new BubbleSort();
		sorted = strategy.sort(numbers);
		strategy = new ShellSort();
		sorted = strategy.sort(numbers);
		strategy = new InsertionSort();
		sorted = strategy.sort(numbers);
		strategy = new SelectionSort();
		sorted = strategy.sort(numbers);
		strategy = new MarginSort();
		sorted = strategy.sort(numbers);
		strategy = new QuickSort();
		sorted = strategy.sort(numbers);
	}

	private static void sortTest() {
		int size = 1000, min = 0, max = 10;

		int[] numbers = new int[size];

		NumbersGenerator ng = new NumbersGenerator(size, false);

		System.out.println("------------1000-----------");
		System.out.println("Cтандартный");
		numbers = ng.classic(min, max);
		sorts(numbers);
		System.out.println();

		System.out.println("По возрастанию");
		numbers = ng.sortedAscending();
		sorts(numbers);
		System.out.println();

		System.out.println("По убыванию");
		numbers = ng.sortedDescending();
		sorts(numbers);
		System.out.println();

		System.out.println("Наполовину");
		numbers = ng.sortedHalf();
		sorts(numbers);
		System.out.println();

		System.out.println("С перестановкой");
		numbers = ng.sortedPermutations();
		sorts(numbers);
		System.out.println();

		System.out.println("Повтором");
		numbers = ng.repeater(min, max);
		sorts(numbers);
		System.out.println();

	}

	public static void main(String[] args) {
		// sortTest();
		normalTest();
	}
}
