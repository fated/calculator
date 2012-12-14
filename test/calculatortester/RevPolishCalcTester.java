/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for RevPolishCalc.
 * @author Bruce
 *
 */
public class RevPolishCalcTester {
	
	/**
	 * An object of RevPolishCalc.
	 */
	private RevPolishCalc rpc;
	
	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		rpc = new RevPolishCalc();
	}

	/**
	 * Test method for 
	 * {@link calculator.RevPolishCalc#evaluate(java.lang.String)}.
	 * @throws InvalidExpressionException when expression is invalid.
	 */
	@Test
	public final void testEvaluate() throws InvalidExpressionException {
		String str1 = "5 6 7 + * 2 -";
		String str2 = "1 a d f a ";
		
		assertEquals("Test 1 : test evaluate() in RevPolishCalc", 
				63.0f, rpc.evaluate(str1), 0.000001);
		
		boolean thrown = false;
		try {
			rpc.evaluate(str2);
		} catch (InvalidExpressionException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test InvalidExpressionException in evaluate()", 
				thrown);
	}

}
