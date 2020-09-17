package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ExponentTest {
	IncrementParameterized ip;
	Exponent exponent;

	@Before
	public void setUp() {
		ip = new IncrementParameterized();
		exponent = new Exponent();
	}

	@Test
	public void returnExponent1WhenSet0() {
		double a = Math.floor(exponent.getExponent(17.0, 0.072));
		double b = Math.floor(Math.E);
		System.out.println(a);
		System.out.println(b);
		assertEquals(a, b, 0.0001);
		//assertEquals(1.0, factorial.calculateFactorial(0), 0.0);
	}
}
