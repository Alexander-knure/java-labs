package junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class FactorialTest {
	// for test
	private int pass_value;
	private int expected_result;
	private IncrementParameterized ip;
	// for code
	private Factorial factorial;

	@Parameters
	public static Collection set_of_parameters() {

		return Arrays.asList(new Object[][] {
				// данные для параметризации
				{ 3, 2 }, { 4, 3 } });
	}

	public FactorialTest(int expected_result, int pass_value) {
		// параметризация в конструкторе
		this.expected_result = expected_result;
		this.pass_value = pass_value;
	}

	@Before
	public void setUp() {
		ip = new IncrementParameterized();
		factorial = new Factorial();
	}

	@Test
	public void tstIncrementParameterized() {
		// выполнение проверки
		assertEquals(expected_result, ip.increment(pass_value));
	}

	@Test
	public void returnFactorial1WhenSet0() {
		assertEquals(1.0, factorial.calculateFactorial(0), 0.0);
	}

	@Test
	public void returnFactorial1WhenSet1() {
		assertEquals(1.0, factorial.calculateFactorial(1), 0.0);
	}

	@Test
	public void returnFactorial120WhenSet5() {
		assertEquals(120.0, factorial.calculateFactorial(5), 0.0);
	}
}