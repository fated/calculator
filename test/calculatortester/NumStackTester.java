/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for NumStack.
 * @author Bruce
 *
 */
public class NumStackTester {

	/**
	 * An object of NumStack.
	 */
	private NumStack s;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		s = new NumStack();
	}

	/**
	 * Test method for {@link calculator.NumStack#push(float)}.<br>
	 * and {@link calculator.NumStack#pop()}.
	 */
	@Test
	public final void testPushThenPop() {
		boolean thrown = false;

		s.push(5.0f);
		try {
			assertEquals("Test 1 : test push() then pop()", 
					5.0f, s.pop(), 0.00001);
			s.pop();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test EmptyStackException in pop()", thrown);
	}
	
	/**
	 * Test method for {@link calculator.NumStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("Test 3 : test isEmpty() for empty stack", 
				true, s.isEmpty());
		s.push(5.0f);
		assertEquals("Test 4 : test isEmpty() for not empty stack", 
				false, s.isEmpty());
	}

}
