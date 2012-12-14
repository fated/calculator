/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for Stack.
 * @author Bruce
 *
 */
public class StackTester {
	
	/**
	 * An object of Stack.
	 */
	private Stack s;
	/**
	 * A test entry.
	 */
	private Entry ety;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		s = new Stack();
		ety = new Entry(12.34f);
	}

	/**
	 * Test method for {@link calculator.Stack#push(calculator.Entry)}.<br>
	 * and {@link calculator.Stack#pop()}.
	 */
	@Test
	public final void testPushThenPop() {
		boolean thrown = false;

		s.push(ety);
		try {
			assertEquals("Test 1 : push() then pop()", ety, s.pop());
			//test functionality of throw exception.
			s.pop();		//should throw exception here.
		} catch (EmptyStackException e) {
			thrown = true;	//if catch exception then change flag.
		}
		//if pop() failed to throw exception, this failure message will show.
		assertTrue("Test 2 : test EmptyStackException in pop()", thrown);
	}

	/**
	 * Test method for {@link calculator.Stack#push(calculator.Entry)}.<br>
	 * and {@link calculator.Stack#top()}.
	 */
	@Test
	public final void testPushThenTop() {
		boolean thrown = false;

		s.push(ety);
		try {
			assertEquals("Test 3 : push() then top()", ety, s.top());
			//test functionality of throw exception.
			s.pop();
			s.top();		//should throw exception here.
		} catch (EmptyStackException e) {
			thrown = true;	//if catch exception then change flag.
		}
		//if top() failed to throw exception, this failure message will show.
		assertTrue("Test 4 : test EmptyStackException in top()", thrown);
	}

}
