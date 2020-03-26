package Main;
import java.util.Scanner;

public class MyClass{
	
	public int[][] matrix;
	public double[] x;
	public double[] y;
	public double []arrRadius;
	public double center = 0.0f;
	
	public MyClass()
	{
		//FirstMethod();
		//SecondMethod();
	}
	
	public void FirstMethod()
	{
		System.out.print("Exercise 1");
		System.out.println();
		NewMatrix();
		Output();
	}
	public void SecondMethod()
	{
		System.out.println();
		System.out.print("Exercise 2");
		System.out.println();
		NewCircle();
		GetPoints();
		GetBigCircle();
	}

	public void NewMatrix() {
		int x = 5;
		int y = 5;
		matrix = new int[x][y];
		int min = 0;
		int max = 10;
    	for (int i = 0; i < x; i++) {
    		for (int j = 0; j < y; j++) {
    			//инициализация элементов массива
    			matrix[i][j] = (int)(Math.random() * (max - min) + 1) + min;
   				//вывод элементов массива
   				System.out.print(matrix[i][j] + "\t");
   			}
    		System.out.println();
    	}
	}

	public int Input()
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		
		return num;
	}

	public int Factorial(int n)
	{
		int result = 1;
		for (int i = 1; i <=n; i ++){
			result = result*i;
		}
		return result;
	}

	public void Output()
	{
		System.out.println("Input index of row in matrix: ");
		int n = Input();
		int f = matrix[n][0];
		for(int i = 0; i < matrix.length - 1; i++)
		{
			
			if(matrix[n][i] < f)
			{
				f = matrix[n][i];
			}
		}
		
		System.out.print("Mim = ");
		System.out.print(f);
		System.out.println("");
		System.out.print("Factorial = ");
		System.out.print(Factorial(f));
	}
	//////////////////////////////////////////////////////////
	public void NewCircle() 
	{
		int c = 10;
		System.out.println("Input count of points: ");
		//int c = Input();
		double max = 10.0f;
		double min = 10.0f;
		
		x = new double[c];
		y = new double[c];
		arrRadius = new double[c];

		for(int i = 0; i < c; i++)
		{
			x[i] = Math.random() * (max - min) + 1 + min;
			y[i] = Math.random() * (max - min) + 1 + min;
			arrRadius[i] = GetRadius(x[i],y[i]);
		}
	}
	
	public double GetRadius(double x, double y)
	{
		return Math.sqrt(Math.pow(x,2) - Math.pow(x, 2));
	}
	
	public void GetPoints()
	{
		for(int i = 0; i < x.length - 1; i++)
		{
			System.out.println(x[i]);
			System.out.println();
			System.out.println(y[i]);
		}
	}
	
	public void GetBigCircle()
	{
		double r = 0;
		double a = 0;
		
		for(int i = 0; i < arrRadius.length - 1; i++)
		{
			if(arrRadius[i] > r)
			{
				r = arrRadius[i];
			}
			if(arrRadius[i] < a) {
				a = arrRadius[i];
			}
		}
		System.out.print("Max: " + "\t");
		System.out.println(r + "\t");
		System.out.print("Min: " + "\t");
		System.out.print(a + "\t");
	}
}
	