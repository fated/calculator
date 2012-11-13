import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class OpStack {

	private Stack numStack;

	public OpStack() {
		numStack = new Stack();
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (numStack.size() == 0)
			return true;
		return false;
	}

	public void push(Symbol i) {
		// TODO Auto-generated method stub
		Entry ety = new Entry(i);
		
		numStack.push(ety);
	}

	public Symbol pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		Entry ety;
		
		ety = numStack.pop();
		try {
			return ety.getSymbol();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::pop()");
		}
		return Symbol.INVALID;
	}

}
