import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class EntryTester {
	
	private Entry ety1, ety2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ety1 = new Entry(5.5f);
		ety2 = new Entry(Symbol.TIMES);
	}

	@Test
	public void test() throws BadTypeException {
		assertEquals("Test 1 : getType()", Type.NUMBER, ety1.getType());
		
		assertEquals("Test 2 : getSymbol()", Symbol.TIMES, ety2.getSymbol());
		try {
			ety1.getSymbol();
			fail("Test 3 : Bad Type Exception in getSymbol()");
		} catch (BadTypeException e) {}
		
		assertEquals("Test 4 : getValue()", 5.5f, ety1.getValue(), 0.001);
		try {
			ety2.getValue();
			fail("Test 5 : Bad Type Exception in getValue()");
		} catch (BadTypeException e) {}		
		
		try {
			ety1.getString();
			fail("Test 6 : Bad Type Exception in getString()");
		} catch (BadTypeException e) {}	
	}

}
