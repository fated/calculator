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

	/**
	 * An object of CalcModel.
	 */
	private CalcModel calc;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		calc = new CalcModel();
	}

	/**
	 * Test method for 
	 * {@link calculator.CalcModel#evaluate(java.lang.String, boolean)}.
	 * @throws InvalidExpressionException
	 */
	@Test
	public final void testEvaluate() {
		boolean infix, thrown = false;
		String str1 = "5 6 7 + * 2 -";
		String str2 = "( 5 * ( 6 + 7 ) ) - 2";
		String str3 = "5 6 7 + * 2 - /";
		
		try {
			infix = false;
			assertEquals(
					"Test 1 : test evaluate() for " 
					+ "postfix expression in CalcModel",
					63.0f, calc.evaluate(str1, infix), 0.000001);
			infix = true;
			assertEquals(
					"Test 2 : test evaluate() for " 
					+ "infix expression in CalcModel",
					63.0f, calc.evaluate(str2, infix), 0.000001);
			calc.evaluate(str3, infix);
		} catch (InvalidExpressionException e) {
			thrown = true;
		}
		assertTrue("Test 3 : test InvalidExpressionException in evaluate()"
				, thrown);

	}

}
