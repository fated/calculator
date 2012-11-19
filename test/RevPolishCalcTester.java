import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class RevPolishCalcTester {

	private RevPolishCalc rpc;
	private String str1;
	private String str2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rpc = new RevPolishCalc();
		str1 = "5 6 7 + * 2 -";
		str2 = "1 a d f a ";
	}

	@Test
	public void testevaluate() throws InvalidExpressionException {
		assertEquals("Test 1 : evaluate() in RevPolishCalc", 63.0f, rpc.evaluate(str1), 0.000001);
		
		boolean thrown = false;
		
		try {
			rpc.evaluate(str2);
		} catch (InvalidExpressionException e) {
			thrown = true;
		}
		assertTrue("Test 2 : InvalidExpressionException in evaluate()", thrown);
	}

}
