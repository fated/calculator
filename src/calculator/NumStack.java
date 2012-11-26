package calculator;

/**
 * A class for number stack.
 * <p>This is a facade class to hide the details on the implementation of a <br>
 * stack of numbers.</p>
 * @author Bruce
 *
 */
public class NumStack {

	private Stack numStack;

	/**
	 * A constructor of class NumStack, initialize the fields.
	 */
	public NumStack() {
		numStack = new Stack();
	}
	
	/**
	 * A method to see if the stack is empty or not.
	 * @return true if the size of stack is 0, otherwise false.
	 */
	public final boolean isEmpty() {
		if (numStack.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * A method to push a number into the stack.
	 * @param i the number to be push in.
	 */
	public final void push(final float i) {
		Entry ety = new Entry(i);
		
		numStack.push(ety);
	}

	/**
	 * A method to get and remove the top number from a stack.
	 * <p>If the type does not match, it will also catch 
	 * {@link BadTypeException}.</p>
	 * @return the top number in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final float pop() throws EmptyStackException {
		Entry ety;
		
		if (this.isEmpty()) {
			throw new EmptyStackException("Empty Stack in NumStack!");
		}
		ety = numStack.pop();

		try {
			return ety.getValue();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in NumStack::pop()");
		}
		
		return 0;
	}

}
