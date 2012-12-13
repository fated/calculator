package calculator;
/**
 * 
 */

/**
 * A model of Calculator in MVC framework.
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93contr
 * oller"> Model¨Cview¨Ccontroller from Wikipedia</a>
 */
public class CalcModel {

	/**
	 * a standard calculator.
	 */
	private Calculator standard;
	
	/**
	 * a reverse polish calculator.
	 */
	private Calculator revPolish;

	/**
	 * A constructor of class CalcModel, initialize the fields.
	 */
	public CalcModel() {
		standard = new StandardCalc();
		revPolish = new RevPolishCalc();
	}
	
	/**
	 * A method that evaluate the expression.
	 * <p>If the expression is in infix notation, call 
	 * {@link StandardCalc#evaluate(String)}.<br>
	 * If the expression is in postfix notation, call 
	 * {@link RevPolishCalc#evaluate(String)}</p>
	 * @param expr the expression to be calculated.
	 * @param infix whether the expression is infix or not.
	 * @return the value of the expression after calculation.
	 * @throws InvalidExpressionException when the expression is invalid.
	 */
	public final float evaluate(final String expr, final boolean infix) 
			throws InvalidExpressionException {
		if ((expr == null) || (expr.equals(""))) {
			throw new InvalidExpressionException("Empty Expression!");
		}

		if (infix) {
			return standard.evaluate(expr);
		}
		return revPolish.evaluate(expr);
	}

}
