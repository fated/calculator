import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * A unit tester for Entry
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
		ety1 = new Entry(12.34f);
		ety2 = new Entry(Symbol.DIVIDE);
	}

	@Test
	public void test() throws BadTypeException {
		boolean thrown;	//define flag
		
		assertEquals("Test 1 : getType()", Type.NUMBER, ety1.getType());	//test getType(), refactor constructors to update type.
		
		assertEquals("Test 2 : getSymbol()", Symbol.DIVIDE, ety2.getSymbol());	//test getSymbol()
		
		thrown = false;	//initial flag
		try {	//test whether getSymbol() could throw bad type exception, refactor getSymbol() to throw exception.
			ety1.getSymbol();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;	//if catch exception then change flag.
		}
		assertTrue("Test 3 : Bad Type Exception in getSymbol()", thrown);	//if getSymbol() failed to throw exception, this failure message will show.
		
		assertEquals("Test 4 : getValue()", 12.34f, ety1.getValue(), 0.001);	//test getValue()
	
		thrown = false;	//reset flag
		try {	//test whether getValue() could throw bad type exception, refactor getValue() to throw exception.
			ety2.getValue();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;	//if catch exception then change flag.
		}
		assertTrue("Test 5 : Bad Type Exception in getValue()", thrown);	//if getValue() failed to throw exception, this failure message will show.

		thrown = false;	//reset flag
		try {	//test whether getString() could throw bad type exception, refactor getString() to throw exception.
			ety1.getString();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;	//if catch exception then change flag.
		}
		assertTrue("Test 6 : Bad Type Exception in getString()", thrown);	//if getString() failed to throw exception, this failure message will show.
	}

}
