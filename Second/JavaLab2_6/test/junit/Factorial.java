package junit;

public class Factorial {
	public double calculateFactorial(int x) {
		if (x == 0)
			return 1.00;
		return x * calculateFactorial(x - 1);
	}

}
