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
 * A unit tester for OpStack
 * @author Bruce
 *
 */
public class OpStackTester {

	private OpStack s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new OpStack();
	}

	/**
	 * Test method for {@link calculator.OpStack#push(calculator.Symbol)}<br>
	 * and {@link calculator.OpStack#pop()}.
	 */
	@Test
	public void testPushThenPop() {
		s.push(Symbol.PLUS);
		assertEquals("Test 1 : test push() then pop()", Symbol.PLUS, s.pop());

		boolean thrown = false;
		try {
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
	public void testPushThenTop() {
		s.push(Symbol.PLUS);
		assertEquals("Test 3 : test push() then top()", Symbol.PLUS, s.top());

		s.pop();
		boolean thrown = false;
		try {
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
	public void testIsEmpty() {
		assertEquals("Test 5 : test isEmpty() for empty stack", true, s.isEmpty());
		s.push(Symbol.PLUS);
		assertEquals("Test 6 : test isEmpty() for not empty stack", false, s.isEmpty());
	}
	
}
