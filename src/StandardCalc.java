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
	private StrStack strStack;

	public StandardCalc() {
		values = new OpStack();
		rpCalc = new RevPolishCalc();
		strStack = new StrStack();
	}
	
	@Override
	public float evaluate(String what) throws InvalidExpressionException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(what);
		String rpStr = "";

		while (s.hasNext()) {
			String str = s.next();
			if (str.equals("+")) {
				if (values.isEmpty() || values.top() == Symbol.LEFT_BRACKET)
					values.push(Symbol.PLUS);
				else {
					rpStr = rpStr + symbolToString(values.pop()) + " ";
					values.push(Symbol.PLUS);
				}
			} else if (str.equals("-")) {
				if (values.isEmpty() || values.top() == Symbol.LEFT_BRACKET)
					values.push(Symbol.MINUS);
				else {
					rpStr = rpStr + symbolToString(values.pop()) + " ";
					values.push(Symbol.MINUS);
				}				
			} else if (str.equals("*")) {
				if (values.top() == Symbol.TIMES || values.top() == Symbol.DIVIDE) {
					rpStr = rpStr + symbolToString(values.pop()) + " ";
					values.push(Symbol.TIMES);
				} else 
					values.push(Symbol.TIMES);
			} else if (str.equals("/")) {
				if (values.top() == Symbol.TIMES || values.top() == Symbol.DIVIDE) {
					rpStr = rpStr + symbolToString(values.pop()) + " ";
					values.push(Symbol.DIVIDE);
				} else 
					values.push(Symbol.DIVIDE);
			} else if (str.equals("(")) {
				values.push(Symbol.LEFT_BRACKET);
			} else if (str.equals(")")) {
				while (values.top() != Symbol.LEFT_BRACKET)
					rpStr = rpStr + symbolToString(values.pop()) + " ";
				values.pop();
			} else {
				rpStr = rpStr + str + " ";
			}
		}
		
		while (!values.isEmpty())
			strStack.push(symbolToString(values.pop()));
		while (!strStack.isEmpty())
			rpStr = rpStr + strStack.pop() + " ";

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

}
