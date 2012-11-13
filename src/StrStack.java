import java.util.EmptyStackException;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class StrStack {

	private Stack StrStack;

	public StrStack() {
		StrStack = new Stack();
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (StrStack.size() == 0)
			return true;
		return false;
	}

	public void push(String str) {
		// TODO Auto-generated method stub
		Entry ety = new Entry(str);
		
		StrStack.push(ety);
	}

	public String pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		Entry ety;
		
		ety = StrStack.pop();
		try {
			return ety.getString();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in NumStack::pop()");
		}
		return "";
	}
}
