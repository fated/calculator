package calculator;

import java.util.Scanner;

/**
 * 
 */

/**
 * A class for infix expression.
 * <p>This class uses method {@link #evaluate(String)} to calculate the value 
 * of an<br> expression in infix notation, throws 
 * {@link InvalidExpressionException} <br> when the expression is empty or 
 * there are unknown operators or unbalanced <br> parentheses in it. The main 
 * idea is to use Shunting-yard algorithm to <br> convert infix expression into
 * postfix expression (Reverse Polish Notation)<br> then call 
 * {@link RevPolishCalc#evaluate(String)} to calculate it.</p>
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Shunting-yard_algorithm">
 * Shunting-yard algorithm from Wikipedia</a>
 */
public class StandardCalc implements Calculator {

	/**
	 * String stack.
	 */
	private StrStack strStack;
	/**
	 * A reverse polish calculator.
	 */
	private RevPolishCalc rpCalc;

	/**
	 * A constructor of class StandardCalc, initialize the fields.
	 */
	public StandardCalc() {
		rpCalc = new RevPolishCalc();
	}
	
	/**
	 * {@inheritDoc}
	 * <p>This overriding method is to implement the evaluation of expression
	 * <br>in infix notation. This method is using the Shunting-yard algorithm
	 * to<br>convert an infix expression into postfix expression, which is also
	 * called<br>reverse polish notation. Then calculate the postfix 
	 * expression.</p>
	 * @see Calculator#evaluate(java.lang.String)
	 */
	@Override
	public final float evaluate(final String what) 
			throws InvalidExpressionException {
		strStack = new StrStack();

		Scanner s = new Scanner(what);
		String rpStr = "";
		boolean expectNumber = true;

		try {
			while (s.hasNext()) {
				String str = s.next();
				if (isOperator(str)) {
					if (expectNumber) {
						s.close();
						throw new InvalidExpressionException(
								"Invalid Expression!");
					} else {
						expectNumber = true;
					}
					while (!strStack.isEmpty() 
							&& getOrder(str) <= getOrder(strStack.top())) {
						rpStr = rpStr + strStack.pop() + " ";
					}
					strStack.push(str);
				} else if (str.equals("(")) {
					strStack.push(str);
				} else if (str.equals(")")) {
					try {
						while (!strStack.top().equals("(")) {
							rpStr = rpStr + strStack.pop() + " ";
						}
					} catch (EmptyStackException e) {
						s.close();
						throw new InvalidExpressionException(
								"Unbalanced Parentheses!");
					}
					strStack.pop();
				} else {
					if (!expectNumber) {
						s.close();
						throw new InvalidExpressionException(
								"Invalid Expression!");
					} else {
						expectNumber = false;
					}
					rpStr = rpStr + str + " ";
				}
			}
			s.close();
			while (!strStack.isEmpty()) {
				if (strStack.top().equals("(")) {
					throw new InvalidExpressionException(
							"Unbalanced Parentheses!");
				} else {
					rpStr = rpStr + strStack.pop() + " ";
				}
			}
		} catch (EmptyStackException e) {
			throw new InvalidExpressionException("Invalid Expression!");
		}
					
		return rpCalc.evaluate(rpStr);
	}
	
	/**
	 * A method that get the precedence of an operator.
	 * @param str the string form of an operator.
	 * @return the precedence of this operator.
	 */
	private int getOrder(final String str) {
		if (str.equals("+") || str.equals("-")) {
			return 1;
		} else if (str.equals("*") || str.equals("/")) {
			return 2;
		}
		return 0;
	}

	/**
	 * A method that checks whether a string is an operator or not. 
	 * @param str the string form of an operator.
	 * @return true if it is an operator, false otherwise.
	 */
	private boolean isOperator(final String str) {
		boolean flag = false;
		
		if (str.equals("+") || str.equals("-") 
				|| str.equals("*") || str.equals("/")) {
			flag = true;
		}
		return flag;
	}
}
