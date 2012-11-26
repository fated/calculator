/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for CalcModel.
 * @author Bruce
 *
 */
public class CalcModelTester {

	private CalcModel calc;
	private String str1;
	private String str2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calc = new CalcModel();
		str1 = "5 6 7 + * 2 -";
		str2 = "( 5 * ( 6 + 7 ) ) - 2";
	}

	/**
	 * Test method for {@link calculator.CalcModel#evaluate(java.lang.String, boolean)}.
	 * @throws InvalidExpressionException
	 */
	@Test
	public void testEvaluate() {
		boolean infix;
		
		try {
			infix = false;
			assertEquals(
					"Test 1 : test evaluate() for postfix expression in CalcModel",
					63.0f, calc.evaluate(str1, infix), 0.000001);
			infix = true;
			assertEquals(
					"Test 2 : test evaluate() for infix expression in CalcModel",
					63.0f, calc.evaluate(str2, infix), 0.000001);
		} catch (InvalidExpressionException e) {
		}
	}

}
