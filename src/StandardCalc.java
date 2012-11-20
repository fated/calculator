import java.util.Scanner;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class StandardCalc implements Calculator{

	private OpStack values;
	private RevPolishCalc rpCalc;

	public StandardCalc() {
		values = new OpStack();
		rpCalc = new RevPolishCalc();
	}
	
	@SuppressWarnings("resource")
	@Override
	public float evaluate(String what) throws InvalidExpressionException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(what);
		String rpStr = "";

		while (s.hasNext()) {
			String str = s.next();
			if (isOperator(str)) {
				while (!values.isEmpty() && getPrecedence(str) <= getPrecedence(symbolToString(values.top())))
					rpStr = rpStr + symbolToString(values.pop()) + " ";
				values.push(stringToSymbol(str));
			} else if (str.equals("(")) {
				values.push(Symbol.LEFT_BRACKET);
			} else if (str.equals(")")) {
				while (!values.isEmpty() && values.top() != Symbol.LEFT_BRACKET)
					rpStr = rpStr + symbolToString(values.pop()) + " ";
				values.pop();
			} else {
				rpStr = rpStr + str + " ";
			}
		}
		
		while (!values.isEmpty())
			rpStr = rpStr + symbolToString(values.pop()) + " ";
			
		return rpCalc.evaluate(rpStr);
	}

	private String symbolToString(Symbol ety) {
		// TODO Auto-generated method stub
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
	
	private Symbol stringToSymbol(String str) {
		// TODO Auto-generated method stub
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
	
	private int getPrecedence(String str) {
		if (str.equals("+") || str.equals("-"))
			return 1;
		else if (str.equals("*") || str.equals("/"))
			return 2;
		return 0;
	}

	private boolean isOperator(String str) {
		boolean flag = false;
		
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			flag = true;
		return flag;
	}
}
