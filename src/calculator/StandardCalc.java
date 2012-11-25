package calculator;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * 
 */

/**
 * A class for infix expression.
 * <p>This class uses method {@link #evaluate(String)} to calculate the value of an<br>
 * expression in infix notation, throws {@link InvalidExpressionException} <br>
 * when the expression is empty or there are unknown operators or unbalanced <br>
 * parentheses in it. The main idea is to use Shunting-yard algorithm to <br>
 * convert infix expression into postfix expression (Reverse Polish Notation)<br>
 * then call {@link RevPolishCalc#evaluate(String)} to calculate it.</p>
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Shunting-yard_algorithm"
 * > Shunting-yard algorithm from Wikipedia</a>
 */
public class StandardCalc implements Calculator{

	private OpStack opStack;
	private RevPolishCalc rpCalc;

	/**
	 * A constructor of class StandardCalc, initialize the fields.
	 */
	public StandardCalc() {
		opStack = new OpStack();
		rpCalc = new RevPolishCalc();
	}
	
	/**
	 * {@inheritDoc}
	 * <p>This overriding method is to implement the evaluation of expression<br>
	 * in infix notation. This method is using the Shunting-yard algorithm to<br>
	 * convert an infix expression into postfix expression, which is also called<br>
	 * reverse polish notation. Then calculate the postfix expression.</p>
	 * @see Calculator#evaluate(java.lang.String)
	 */
	@Override
	public float evaluate(String what) throws InvalidExpressionException {
		Scanner s = new Scanner(what);
		String rpStr = "";

		while (s.hasNext()) {
			String str = s.next();
			if (isOperator(str)) {
				while (!opStack.isEmpty() && getPrecedence(str) <= 
						getPrecedence(symbolToString(opStack.top())))
					rpStr = rpStr + symbolToString(opStack.pop()) + " ";
				opStack.push(stringToSymbol(str));
			} else if (str.equals("(")) {
				opStack.push(Symbol.LEFT_BRACKET);
			} else if (str.equals(")")) {
				try {
					while (opStack.top() != Symbol.LEFT_BRACKET)
						rpStr = rpStr + symbolToString(opStack.pop()) + " ";
					opStack.pop();
				} catch (EmptyStackException e) {
					s.close();
					throw new InvalidExpressionException(
							"Unbalanced Parentheses!");
				}
			} else {
				rpStr = rpStr + str + " ";
			}
		}
		s.close();
		
		while (!opStack.isEmpty())
			if (opStack.top() == Symbol.LEFT_BRACKET) {
				throw new InvalidExpressionException(
						"Unbalanced Parentheses!");
			} else {
				rpStr = rpStr + symbolToString(opStack.pop()) + " ";
			}
			
		return rpCalc.evaluate(rpStr);
	}

	/**
	 * A method that converts Symbol to string.
	 * @param ety the Symbol to be converted.
	 * @return the string <b>ety</b> stands for. 
	 */
	private String symbolToString(Symbol ety) {
		if (ety == Symbol.PLUS)
			return "+";
		else if (ety == Symbol.MINUS)
			return "-";
		else if (ety == Symbol.TIMES)
			return "*";
		else if (ety == Symbol.DIVIDE)
			return "/";
		return "";
	}
	
	/**
	 * A method that converts string to Symbol.
	 * @param str the string to be converted.
	 * @return the Symbol <b>str</b> stands for.
	 */
	private Symbol stringToSymbol(String str) {
		if (str.equals("+"))
			return Symbol.PLUS;
		else if (str.equals("-"))
			return Symbol.MINUS;
		else if (str.equals("*"))
			return Symbol.TIMES;
		else if (str.equals("/"))
			return Symbol.DIVIDE;
		return Symbol.INVALID;
	}
	
	/**
	 * A method that get the precedence of an operator.
	 * @param str the string form of an operator.
	 * @return the precedence of this operator.
	 */
	private int getPrecedence(String str) {
		if (str.equals("+") || str.equals("-"))
			return 1;
		else if (str.equals("*") || str.equals("/"))
			return 2;
		return 0;
	}

	/**
	 * A method that checks whether a string is an operator or not. 
	 * @param str the string form of an operator.
	 * @return true if it is an operator, false otherwise.
	 */
	private boolean isOperator(String str) {
		boolean flag = false;
		
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			flag = true;
		return flag;
	}
}
