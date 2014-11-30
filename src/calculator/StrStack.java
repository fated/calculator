package calculator;

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

	/**
	 * String stack.
	 */
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
	public final boolean isEmpty() {
		if (strStack.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * A method to push a string into the stack.
	 * @param str the string to be push in.
	 */
	public final void push(final String str) {
		Entry ety = new Entry(str);
		
		strStack.push(ety);
	}

	/**
	 * A method to get and remove the top string from a stack.
	 * <p>If the type does not match, it will also catch 
	 * {@link BadTypeException}.</p>
	 * @return the top string in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final String pop() throws EmptyStackException {
		Entry ety;
		
		if (this.isEmpty()) {
			throw new EmptyStackException("Empty Stack in StrStack!");
		}
		ety = strStack.pop();
		try {
			return ety.getString();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in NumStack::pop()");
		}
		return "";
	}
	
	/**
	 * A method to get but not remove the top operator from a stack.
	 * <p>If the type does not match, it will also catch 
	 * {@link BadTypeException}.</p>
	 * @return the top string in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final String top() throws EmptyStackException {
		Entry ety;
		
		if (this.isEmpty()) {
			throw new EmptyStackException("Empty Stack in OpStack!");
		}
		ety = strStack.top();
		try {
			return ety.getString();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::top()");
		}
		return "";
	}
}
