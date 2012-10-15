import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class Stack {

	private int size;
	private List<Entry> entries;
	
	public Stack() {
		entries = new ArrayList<Entry>();
	}
	public void push(Entry ety) {
		// TODO Auto-generated method stub
		this.entries.add(ety);
		this.size = this.entries.size();
	}

	public Entry pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (this.size > 0) {
			Entry e = this.entries.get(this.size-1);
			this.entries.remove(this.size-1);
			this.size = this.entries.size();
			return e;
		}
		else {
			throw new EmptyStackException();
		}
	}
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	public Entry top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if (this.size > 0) {
			Entry e = this.entries.get(this.size-1);
			this.size = this.entries.size();
			return e;
		}
		else {
			throw new EmptyStackException();
		}
	}
	
}
