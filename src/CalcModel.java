/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class CalcModel {

	private Calculator standard;
	private Calculator revPolish;

	public CalcModel() {
		standard = new StandardCalc();
		revPolish = new RevPolishCalc();
	}
	
	public float evaluate(String expr, boolean infix) throws InvalidExpressionException {
		// TODO Auto-generated method stub
		if (infix)
			return standard.evaluate(expr);
		
		return revPolish.evaluate(expr);
	}

}
