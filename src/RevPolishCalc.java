import java.util.Scanner;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class RevPolishCalc implements Calculator{

	private NumStack values;

	public RevPolishCalc() {
		values = new NumStack();
	}
	
	@SuppressWarnings("resource")
	@Override
	public float evaluate(String what) throws InvalidExpressionException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(what);
		float arg;
		
		while (s.hasNext()) {
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
				try {
					arg = Float.parseFloat(str);
				} catch (NumberFormatException e) {
					throw new InvalidExpressionException("Invalid Expression in RevPolishCalc!");
				}
				values.push(arg);
			}
		}
		return values.pop();
	}

}
