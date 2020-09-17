package lab4;

public class Sorter {
	private int max;
	private int min;
	private int[] array;
	
	public Sorter(int[] array)
	{
		this.max = 0;
		this.min = 0;
		this.array = array;
	}
	
	public int[] sort(SortStrategy strategy)
	{
		int[] sorted = strategy.sort(array);
		min = sorted[0];
		max = sorted[array.length - 1];
		return sorted;
	}
	
	public int getMax()
	{
		return max;
	}
	
	public int getMin()
	{
		return min;
	}
}
