package calculator;
/**
 * 
 */

/**
 * Signals that type does not match during get the value of the entry.
 * @author Bruce
 *
 */
public class BadTypeException extends Exception {
	
	/**
	 * Auto generated.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message error message
	 */
	public BadTypeException(final String message) {
    	super(message);
    }
}
