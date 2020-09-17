package lab2;

public class Matrix {
	public int[][] matrix;
	public double[] x;
	public double[] y;
	public int n;

	public Matrix() {
		n = 5;
		matrix = new int[n][n];
		int max = 6;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int) (Math.random() * max);
			}
		}
	}

	public void output() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	public void sum() {
		int sum = 0;
		for (int i = 0; i != n; i++)
			for (int j = 0; j != n; j++)
				if (i > j)
					sum += matrix[i][j];
		System.out.println("sum = " + sum);
	}
}
