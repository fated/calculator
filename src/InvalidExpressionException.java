/**
 * 
 */

/**
 * Signals that the expression is not valid during input.
 * @author Bruce
 *
 */
public class InvalidExpressionException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidExpressionException(String message) {
    	super(message);
    }
}
