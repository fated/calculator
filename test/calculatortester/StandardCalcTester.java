/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for StandardCalc.
 * @author Bruce
 *
 */
public class StandardCalcTester {
	
	/**
	 * An object of StandardCalc.
	 */
	private StandardCalc sc;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		sc = new StandardCalc();
	}

	/**
	 * Test method for 
	 * {@link calculator.StandardCalc#evaluate(java.lang.String)}.
	 * @throws InvalidExpressionException when expression is invalid.
	 */
	@Test
	public final void testEvaluate() throws InvalidExpressionException {
		String str1 = "( 5 * ( 6 + 7 ) ) - 2";
		String str2 = "1 (( + ";

		assertEquals("Test 1 : test evaluate() in StandardCalc", 
				63.0f, sc.evaluate(str1), 0.000001);
		
		boolean thrown = false;
		try {
			sc.evaluate(str2);
		} catch (InvalidExpressionException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test InvalidExpressionException in evaluate()", 
				thrown);
	}

}
