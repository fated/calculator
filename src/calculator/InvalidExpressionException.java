package calculator;
/**
 * 
 */

/**
 * Signals that the expression is not valid during input.
 * @author Bruce
 *
 */
public class InvalidExpressionException extends Exception {

	/**
	 * Auto generated.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message error message.
	 */
	public InvalidExpressionException(final String message) {
    	super(message);
    }
}
