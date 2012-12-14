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
	
	/**
	 * Auto generated.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message error message.
	 */
	public EmptyStackException(final String message) {
    	super(message);
    }
}
