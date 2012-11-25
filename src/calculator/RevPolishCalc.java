package calculator;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * 
 */

/**
 * A class for reverse polish notation.
 * <p>This class uses method {@link #evaluate(String)} to calculate the value of a postfix<br>
 * expression in reverse polish notation, it throws {@link InvalidExpressionException}<br>
 * when the expression is empty or unbalanced, or there are unknown operators <br>
 * in it.</p>
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation"
 * > Reverse Polish notation from Wikipedia</a>
 */
public class RevPolishCalc implements Calculator{

	private NumStack values;

	/**
	 * A constructor of class RevPolishCalc, initialize the fields.
	 */
	public RevPolishCalc() {
		values = new NumStack();
	}
	
	/**
	 * {@inheritDoc}
	 * <p>This overriding method is to implement the evaluation using reverse<br>
	 * polish notation. This method reads in entries from the expression and<br>
	 * push numbers into stack. If it reads in an operator, it pops two numbers<br>
	 * from the stack and calculate the value and push it back into the stack.<br>
	 * At last it returns a total value.</p>
	 * @see Calculator#evaluate(java.lang.String)
	 */
	@Override
	public float evaluate(String what) throws InvalidExpressionException {
		if ((what == null) || (what.equals(""))) {
			throw new InvalidExpressionException("Empty Expression!");
		}
		
		Scanner s = new Scanner(what);
		float arg = 0.0F;
		
		try {
			while (s.hasNext()) {
				if (s.hasNextFloat()) {
					values.push(s.nextFloat());
				} else {
					String str = s.next();
					if (str.equals("+")) {
						values.push(values.pop() + values.pop());
					} else if (str.equals("-")) {
						arg = values.pop();
						values.push(values.pop() - arg);
					} else if (str.equals("*")) {
						values.push(values.pop() * values.pop());
					} else if (str.equals("/")) {
						arg = values.pop();
						values.push(values.pop() / arg);
					} else {
						s.close();
						throw new InvalidExpressionException(
								"Unknown Operator!");
					}
				}
			}
			s.close();
			arg = values.pop();
			if (!values.isEmpty())
				throw new InvalidExpressionException("Unbalanced Expression!");
		} catch (EmptyStackException e) {
			throw new InvalidExpressionException("Invalid Expression!");
		}
		return arg;
	}

}
