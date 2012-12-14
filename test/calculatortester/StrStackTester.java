/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for StrStack.
 * @author Bruce
 *
 */
public class StrStackTester {

	/**
	 * An object of StrStack.
	 */
	private StrStack s;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		s = new StrStack();
	}

	/**
	 * Test method for {@link calculator.StrStack#push(java.lang.String)}<br>
	 * and {@link calculator.StrStack#pop()}.
	 */
	@Test
	public final void testPushThenPop() {
		boolean thrown = false;

		s.push("5 + 4");
		try {
			assertEquals("Test 1 : test push() then pop()", "5 + 4", s.pop());
			s.pop();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test EmptyStackException in pop()", thrown);
	}

	/**
	 * Test method for {@link calculator.StrStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("Test 3 : test isEmpty() for empty stack", 
				true, s.isEmpty());
		s.push("5 + 4");
		assertEquals("Test 4 : test isEmpty() for not empty stack", 
				false, s.isEmpty());
	}
}
