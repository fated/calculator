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

	@Test
	public void test() throws InvalidExpressionException {
		boolean infix;
		
		infix = false;
		assertEquals("Test 1 : evaluate() for postfix expression in CalcModel", 63.0f, calc.evaluate(str1, infix), 0.000001);
		
		infix = true;
		assertEquals("Test 2 : evaluate() for infix expression in CalcModel", 63.0f, calc.evaluate(str2, infix), 0.000001);
	}

}
