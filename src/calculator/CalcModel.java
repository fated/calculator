package calculator;
/**
 * 
 */

/**
 * A model of Calculator in MVC framework.
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller"
 * > Model¨Cview¨Ccontroller from Wikipedia</a>
 */
public class CalcModel {

	private Calculator standard;
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
	 * <p>If the expression is in infix notation, call {@link StandardCalc#evaluate(String)}.<br>
	 * If the expression is in postfix notation, call {@link RevPolishCalc#evaluate(String)}</p>
	 * @param expr the expression to be calculated.
	 * @param infix whether the expression is infix or not.
	 * @return the value of the expression after calculation.
	 * @throws InvalidExpressionException when the expression is invalid.
	 */
	public float evaluate(String expr, boolean infix) 
			throws InvalidExpressionException 
	{
		if (infix) {
			return standard.evaluate(expr);
		}
		return revPolish.evaluate(expr);
	}

}
