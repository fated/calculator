/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for NumStack
 * @author Bruce
 *
 */
public class NumStackTester {

	private NumStack s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new NumStack();
	}

	/**
	 * Test method for {@link calculator.NumStack#push(float)}.<br>
	 * and {@link calculator.NumStack#pop()}.
	 */
	@Test
	public void testPushThenPop() {
		s.push(5.0f);
		assertEquals("Test 1 : test push() then pop()", 5.0f, s.pop(), 0.00001);

		boolean thrown = false;
		try {
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
	public void testIsEmpty() {
		assertEquals("Test 3 : test isEmpty() for empty stack", true, s.isEmpty());
		s.push(5.0f);
		assertEquals("Test 4 : test isEmpty() for not empty stack", false, s.isEmpty());
	}

}
