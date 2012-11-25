/**
 * 
 */

/**
 * Signals that type does not match during get the value of the entry.
 * @author Bruce
 *
 */
public class BadTypeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BadTypeException(String message) {
    	super(message);
    }
}
