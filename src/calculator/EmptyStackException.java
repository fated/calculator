/**
 * 
 */
package calculator;

/**
 * Signals that the stack is empty during getting the top entry.
 * @author Bruce
 *
 */
public class EmptyStackException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String message) {
    	super(message);
    }
}
