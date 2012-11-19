import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class OpStack {

	private Stack opStack;

	public OpStack() {
		opStack = new Stack();
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (opStack.size() == 0)
			return true;
		return false;
	}

	public void push(Symbol i) {
		// TODO Auto-generated method stub
		Entry ety = new Entry(i);
		
		opStack.push(ety);
	}

	public Symbol pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		Entry ety;
		
		ety = opStack.pop();
		try {
			return ety.getSymbol();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::pop()");
		}
		return Symbol.INVALID;
	}

	public Symbol top() throws EmptyStackException {
		// TODO Auto-generated method stub
		Entry ety;
		
		ety = opStack.top();
		try {
			return ety.getSymbol();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in OpStack::top()");
		}
		return Symbol.INVALID;
	}

}
