import java.util.EmptyStackException;

/**
 * 
 */

/**
 * A class for string stack.
 * <p>This is a facade class to hide the details on the implementation of a <br>
 * stack of strings.</p>
 * @author Bruce
 *
 */
public class StrStack {

	private Stack strStack;

	/**
	 * A constructor of class StrStack, initialize the fields.
	 */
	public StrStack() {
		strStack = new Stack();
	}
	
	/**
	 * A method to see if the stack is empty or not.
	 * @return true if the size of stack is 0, otherwise false.
	 */
	public boolean isEmpty() {
		if (strStack.size() == 0)
			return true;
		return false;
	}

	/**
	 * A method to push a string into the stack.
	 * @param str the string to be push in.
	 */
	public void push(String str) {
		Entry ety = new Entry(str);
		
		strStack.push(ety);
	}

	/**
	 * A method to get and remove the top string from a stack.
	 * <p>If the type does not match, it will also catch {@link BadTypeException}.</p>
	 * @return the top string in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public String pop() throws EmptyStackException {
		Entry ety;
		
		ety = strStack.pop();
		try {
			return ety.getString();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in NumStack::pop()");
		}
		return "";
	}
}
