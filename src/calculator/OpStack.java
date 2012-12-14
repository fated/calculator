package calculator;

/**
 * 
 */

/**
 * A class for operator stack.
 * <p>This is a facade class to hide the details on the implementation of a <br>
 * stack of operators.</p>
 * @author Bruce
 *
 */
public class OpStack {

	/**
	 * Stack for storing operators.
	 */
	private Stack opStack;

	/**
	 * A constructor of class OpStack, initialize the fields.
	 */
	public OpStack() {
		opStack = new Stack();
	}
	
	/**
	 * A method to see if the stack is empty or not.
	 * @return true if the size of stack is 0, otherwise false.
	 */
	public final boolean isEmpty() {
		if (opStack.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * A method to push an operator into the stack.
	 * @param i the operator to be push in.
	 */
	public final void push(final Symbol i) {
		Entry ety = new Entry(i);
		
		opStack.push(ety);
	}

	/**
	 * A method to get and remove the top operator from a stack.
	 * <p>If the type does not match, it will also catch 
	 * {@link BadTypeException}.</p>
	 * @return the top operator in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final Symbol pop() throws EmptyStackException {
		Entry ety;
		
		if (this.isEmpty()) {
			throw new EmptyStackException("Empty Stack in OpStack!");
		}
		ety = opStack.pop();
		try {
			return ety.getSymbol();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::pop()");
		}
		return Symbol.INVALID;
	}
	
	/**
	 * A method to get but not remove the top operator from a stack.
	 * <p>If the type does not match, it will also catch 
	 * {@link BadTypeException}.</p>
	 * @return the top string in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final Symbol top() throws EmptyStackException {
		Entry ety;
		
		if (this.isEmpty()) {
			throw new EmptyStackException("Empty Stack in OpStack!");
		}
		ety = opStack.top();
		try {
			return ety.getSymbol();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::top()");
		}
		return Symbol.INVALID;
	}
}
