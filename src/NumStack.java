import java.util.EmptyStackException;


public class NumStack {

	private Stack numStack;

	public NumStack() {
		numStack = new Stack();
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (numStack.size() == 0)
			return true;
		return false;
	}

	public void push(float i) {
		// TODO Auto-generated method stub
		Entry ety = new Entry(i);
		
		numStack.push(ety);
	}

	public float pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		Entry ety;
		
		ety = numStack.pop();
		try {
			return ety.getValue();
		} catch (BadTypeException e) {
			System.err.println("BadTypeException in NumStack::pop()");
		}
		return 0;
	}

}
