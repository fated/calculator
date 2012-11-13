import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 *
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

	@Test	//test push(), pop() and size().
	public void pushthenpopsize() throws EmptyStackException {
		boolean thrown;	//define flag.
		
		s.push(ety);
		assertEquals("Test 1 : push then pop", ety, s.pop());	//should match here.
		assertEquals("Test 2 : pop then size", 0, s.size());	//stack should be empty, force refactoring of update size.
		
		thrown = false;	//initial flag
		try {	//test functionality of throw exception, force refactoring of throw exception.
			s.pop();	//should throw exception here.
		} catch (EmptyStackException e) {
			thrown = true;	//if catch exception then change flag.
		}
		assertTrue("Test 3 : Empty Stack Exception in pop()", thrown);	//if pop() failed to throw exception, this failure message will show.

	}

	@Test	//test push(), top() and size().
	public void pushthentopsize() throws EmptyStackException {
		boolean thrown;	//define flag.

		s.push(ety);
		assertEquals("Test 4 : push then top", ety, s.top());	//should match here.
		assertEquals("Test 5 : top then size", 1, s.size());	//stack should be not empty, force refactoring of update size.

		thrown = false;	//initial flag
		try {	//test functionality of throw exception, force refactoring of throw exception.
			s.pop();
			s.top();	//should throw exception here.
		} catch (EmptyStackException e) {
			thrown = true;	//if catch exception then change flag.
		}
		assertTrue("Test 6 : Empty Stack Exception in top()", thrown);	//if top() failed to throw exception, this failure message will show.

	}
}
