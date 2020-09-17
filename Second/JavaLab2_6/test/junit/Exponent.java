package junit;

public class Exponent {
	private double exp;
	public double getExponent(double n, double e)
	{
		//float n = 17;
		//float e = 0.072f;
		
		double res = 1;
		double num = 1;
		for(int i=1; Math.abs(num)>=e; i++)
		{
			num *= n/i;
			exp += num;
		}
		return exp;
	}
	
	public void output()
	{
		System.out.println(exp);
	}
}
