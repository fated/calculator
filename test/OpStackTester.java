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
public class OpStackTester {

	private OpStack s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new OpStack();
	}

	@Test
	public void test() {
		assertEquals("Test 1 : test isEmpty() for empty stack", true, s.isEmpty());
		
		s.push(Symbol.PLUS);
		assertEquals("Test 2 : test isEmpty() for not empty stack", false, s.isEmpty());
		assertEquals("Test 3 : test push() then pop()", Symbol.PLUS, s.pop());

		boolean thrown = false;
		
		try {
			s.pop();
		} catch (EmptyStackException e) {
			thrown = true;
		}
		assertTrue("Test 4 : Empty Stack Exception in pop()", thrown);
	}

}