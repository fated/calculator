/**
 * 
 */
package calculatortester;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Before;
import org.junit.Test;

/**
 * A unit tester for Entry.
 * @author Bruce
 *
 */
public class EntryTester {

	/**
	 * Test entries.
	 */
	private Entry ety1, ety2, ety3;

	/**
	 * @throws java.lang.Exception if there is an exception.
	 */
	@Before
	public final void setUp() throws Exception {
		ety1 = new Entry(12.34f);
		ety2 = new Entry(Symbol.DIVIDE);
		ety3 = new Entry("3 + 4");
	}

	/**
	 * Test method for {@link calculator.Entry#getType()}.
	 */
	@Test
	public final void testGetType() {
		assertEquals("Test 1 : test getType()", Type.NUMBER, ety1.getType());
	}

	/**
	 * Test method for {@link calculator.Entry#getSymbol()}.
	 * @throws BadTypeException when type does not match.
	 */
	@Test
	public final void testGetSymbol() throws BadTypeException {
		assertEquals("Test 2 : test getSymbol()", 
				Symbol.DIVIDE, ety2.getSymbol());
		
		boolean thrown = false;		//initial flag
		//test whether getSymbol() could throw bad type exception.
		try {
			ety1.getSymbol();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;		//if catch exception then change flag.
		}
		//if getSymbol() failed to throw exception, this message will show.
		assertTrue("Test 3 : test BadTypeException in getSymbol()", thrown);
	}

	/**
	 * Test method for {@link calculator.Entry#getValue()}.
	 * @throws BadTypeException when type does not match.
	 */
	@Test
	public final void testGetValue() throws BadTypeException {
		assertEquals("Test 4 : test getValue()", 
				12.34f, ety1.getValue(), 0.000001);
		
		boolean thrown = false;
		//test whether getValue() could throw bad type exception.
		try {
			ety2.getValue();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;		//if catch exception then change flag.
		}
		//if getValue() failed to throw exception, this message will show.
		assertTrue("Test 5 : test BadTypeException in getValue()", thrown);
	}

	/**
	 * Test method for {@link calculator.Entry#getString()}.
	 * @throws BadTypeException when type does not match.
	 */
	@Test
	public final void testGetString() throws BadTypeException {
		assertEquals("Test 6 : test getString()", "3 + 4", ety3.getString());
		
		boolean thrown = false;
		//test whether getString() could throw bad type exception.
		try {
			ety1.getString();	//should throw exception here.
		} catch (BadTypeException e) {
			thrown = true;		//if catch exception then change flag.
		}
		//if getString() failed to throw exception, this message will show.
		assertTrue("Test 7 : test BadTypeException in getString()", thrown);
	}

}
