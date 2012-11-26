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
 * A unit tester for StrStack.
 * @author Bruce
 *
 */
public class StrStackTester {

	private StrStack s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new StrStack();
	}

	/**
	 * Test method for {@link calculator.StrStack#push(java.lang.String)}<br>
	 * and {@link calculator.StrStack#pop()}.
	 */
	@Test
	public void testPushThenPop() {
		s.push("5 + 4");
		assertEquals("Test 1 : test push() then pop()", "5 + 4", s.pop());

		boolean thrown = false;
		try {
			s.pop();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test EmptyStackException in pop()", thrown);	}

	/**
	 * Test method for {@link calculator.StrStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertEquals("Test 3 : test isEmpty() for empty stack", true, s.isEmpty());
		s.push("5 + 4");
		assertEquals("Test 4 : test isEmpty() for not empty stack", false, s.isEmpty());
	}
}
