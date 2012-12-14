package calculator;
/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * A model for stack.
 * <p>A stack contains several entries. All the entries are stored in a 
 * arraylist,<br> user can use push(), top() and pop() method to operate 
 * the list.</p>
 * @author Bruce
 *
 */
public class Stack {

	/**
	 * The size of the stack.
	 */
	private int size;
	/**
	 * The stack.
	 */
	private List<Entry> entries;
	
	/**
	 * A constructor of class Stack, initialize all the fields.
	 */
	public Stack() {
		this.entries = new ArrayList<Entry>();
		this.size = 0;
	}
	
	/**
	 * A method to push an entry into the stack.
	 * @param ety the entry to be pushed in.
	 */
	public final void push(final Entry ety) {
		this.entries.add(ety);
		this.size = this.entries.size();		//refactor: update size
	}

	/**
	 * A method to get and remove the top entry from a stack.
	 * @return the top entry in the stack.
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final Entry pop() throws EmptyStackException {
		if (this.size > 0) {
			Entry e = this.entries.get(this.size - 1);
			this.entries.remove(this.size - 1);
			this.size = this.entries.size();	//refactor: update size
			return e;
		} else {
			//refactor: throw exception
			throw new EmptyStackException("Empty Stack in Stack");	
		}
	}
	
	/**
	 * A method to get the size of the stack.
	 * @return the size of current stack.
	 */
	public final int size() {
		return this.size;
	}
	
	/**
	 * A method to get but not remove the top entry from a stack.
	 * @return the top entry in the stack
	 * @throws EmptyStackException when the stack is empty.
	 */
	public final Entry top() throws EmptyStackException {
		if (this.size > 0) {
			return this.entries.get(this.size - 1);
		} else {
			//refactor: throw exception
			throw new EmptyStackException("Empty Stack in Stack");
		}
	}
	
}
