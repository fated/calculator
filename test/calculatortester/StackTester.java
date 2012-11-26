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
 * A unit tester for Stack
 * @author Bruce
 *
 */
public class StackTester {
	private Stack s;
	private Entry ety;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new Stack();
		ety = new Entry(12.34f);
	}

	/**
	 * Test method for {@link calculator.Stack#push(calculator.Entry)}.<br>
	 * and {@link calculator.Stack#pop()}.
	 */
	@Test
	public void testPushThenPop() {
		s.push(ety);
		assertEquals("Test 1 : push() then pop()", ety, s.pop());
		
		boolean thrown = false;
		//test functionality of throw exception.
		try {
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
	public void testPushThenTop() {
		s.push(ety);
		assertEquals("Test 3 : push() then top()", ety, s.top());

		boolean thrown = false;
		//test functionality of throw exception.
		try {
			s.pop();
			s.top();		//should throw exception here.
		} catch (EmptyStackException e) {
			thrown = true;	//if catch exception then change flag.
		}
		//if top() failed to throw exception, this failure message will show.
		assertTrue("Test 4 : test EmptyStackException in top()", thrown);
	}

}
