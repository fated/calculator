/**
 * 
 */

/**
 * @author Bruce
 *
 */

class BadTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7933648642578739575L;

	public BadTypeException(String message) {
    	super(message);
    }
}


public class Entry {

	private float number;
	private Symbol other;
	private String str;
	private Type type;
	
	public Entry(float value) {
		// TODO Auto-generated constructor stub
		this.number = value;
		this.type = Type.NUMBER;
	}

	public Entry(Symbol which) {
		// TODO Auto-generated constructor stub
		this.other = which;
		this.type = Type.SYMBOL;
	}

	public Type getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public Symbol getSymbol() throws BadTypeException {
		// TODO Auto-generated method stub
		if (this.type == Type.SYMBOL)
			return this.other;
		else
			throw new BadTypeException("Bad Type!");
	}

	public float getValue() throws BadTypeException {
		// TODO Auto-generated method stub
		if (this.type == Type.NUMBER)
			return this.number;
		else
			throw new BadTypeException("Bad Type!");
	}

	public String getString() throws BadTypeException {
		// TODO Auto-generated method stub
		if (this.type == Type.STRING)
			return this.str;
		else
			throw new BadTypeException("Bad Type!");
	}

}
