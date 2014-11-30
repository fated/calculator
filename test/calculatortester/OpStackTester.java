/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for OpStack.
 * @author Bruce
 *
 */
public class OpStackTester {

	/**
	 * An object of OpStack.
	 */
	private OpStack s;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		s = new OpStack();
	}

	/**
	 * Test method for {@link calculator.OpStack#push(calculator.Symbol)}<br>
	 * and {@link calculator.OpStack#pop()}.
	 */
	@Test
	public final void testPushThenPop() {
		boolean thrown = false;

		s.push(Symbol.PLUS);
		try {
			assertEquals("Test 1 : test push() then pop()", 
					Symbol.PLUS, s.pop());
			s.pop();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 2 : test EmptyStackException in pop()", thrown);
	}
	
	/**
	 * Test method for {@link calculator.OpStack#push(calculator.Symbol)}<br>
	 * and {@link calculator.OpStack#top()}.
	 */
	@Test
	public final void testPushThenTop() {
		boolean thrown = false;
		
		s.push(Symbol.PLUS);
		try {
			assertEquals("Test 3 : test push() then top()", 
					Symbol.PLUS, s.top());
			s.pop();
			s.top();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 4 : test EmptyStackException in top()", thrown);
	}

	/**
	 * Test method for {@link calculator.OpStack#isEmpty()}.
	 */
	@Test
	public final void testIsEmpty() {
		assertEquals("Test 5 : test isEmpty() for empty stack", 
				true, s.isEmpty());
		s.push(Symbol.PLUS);
		assertEquals("Test 6 : test isEmpty() for not empty stack", 
				false, s.isEmpty());
	}
	
}
