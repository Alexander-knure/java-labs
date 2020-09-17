package lab2;

public class Exponentiation {
	private float exp;
	public Exponentiation()
	{
		float n = 17;
		float e = 0.072f;
		
		float res = 1;
		float num = 1;
		for(int i=1; Math.abs(num)>=e; i++)
		{
			num *= n/i;
			exp += num;
		}
	}
	
	public void output()
	{
		System.out.println(exp);
	}
}
