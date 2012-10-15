import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
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
		ety = new Entry(5.5f);
	}

	@Test
	public void pushthenpopsize() throws EmptyStackException {
		s.push(ety);
		assertEquals("Test 1 : push then pop", ety, s.pop());
		assertEquals("Test 2 : pop then size", 0, s.size());
		try {
			s.pop();
			fail("Test 3 : Empty Stack Exception in pop()");
		} catch (EmptyStackException e) {}
	}

	@Test
	public void pushthentopsize() throws EmptyStackException {
		s.push(ety);
		assertEquals("Test 4 : push then top", ety, s.top());
		assertEquals("Test 5 : top then size", 1, s.size());
		try {
			s.pop();
			s.top();
			fail("Test 6 : Empty Stack Exception in top()");
		} catch (EmptyStackException e) {}
	}
}
