package calculator;
/**
 * 
 */

/**
 * An interface for RPN calculator and infix calculator to implement.
 * @author Bruce
 *
 */
public abstract interface Calculator {
	
	/**
	 * A method that calculate the value of an expression.
	 * @param what the string contains an expression.
	 * @return the value after calculate the expression.
	 * @throws InvalidExpressionException when the expression is empty or <br>
	 * unbalanced, or there are unknown operators in it.
	 */
	float evaluate(String what) throws InvalidExpressionException; 
}
