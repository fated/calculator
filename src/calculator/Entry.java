package calculator;
/**
 * 
 */

/**
 * A model for entry.
 * <p>An entry could be any numbers, operators or strings, each has a 
 * constructor <br> and a getter method. There is also a method which can get 
 * the type of this <br> entry. </p>
 * @author Bruce
 *
 */
public class Entry {

	private float number = 0.0F;
	private Symbol other = null;
	private String str = null;
	private Type type;
	
	/**
	 * A constructor for entry of numbers, also set type in it.
	 * @param value is the the number.
	 */
	public Entry(final float value) {
		this.number = value;
		this.type = Type.NUMBER;
	}

	/**
	 * A constructor for entry of symbols, also set type in it.
	 * @param which is the symbol.
	 */
	public Entry(final Symbol which) {
		this.other = which;
		this.type = Type.SYMBOL;
	}

	/**
	 * A constructor for entry of strings, also set type in it.
	 * @param s is the string.
	 */
	public Entry(final String s) {
		this.str = s;
		this.type = Type.STRING;
	}

	/**
	 * A getter method returns the type of this entry.
	 * @return the type of this entry.
	 */
	public final Type getType() {
		return type;
	}

	/**
	 * A getter method returns the symbol of this entry.
	 * <p>If the type of this entry is not {@link Type#SYMBOL} in {@link Type}
	 * , it will<br> throws a {@link BadTypeException}.
	 * @return which symbol is this entry.
	 * @throws BadTypeException when the type does not match.
	 */
	public final Symbol getSymbol() throws BadTypeException {
		if (this.type == Type.SYMBOL) {
			return this.other;
		} else {
			//refactor to throw exception when type does not match.
			throw new BadTypeException("Bad Type! Need a SYMBOL");
		}
	}

	/**
	 * A getter method returns the number of this entry.
	 * <p>If the type of this entry is not {@link Type#NUMBER} in {@link Type}
	 * , it will<br> throws a {@link BadTypeException}.
	 * @return the value of the number.
	 * @throws BadTypeException when the type does not match.
	 */
	public final float getValue() throws BadTypeException {
		if (this.type == Type.NUMBER) {
			return this.number;
		} else {
			//refactor to throw exception when type does not match.
			throw new BadTypeException("Bad Type! Need a NUMBER!");
		}
	}

	/**
	 * A getter method returns the string of this entry.
	 * <p>If the type of this entry is not {@link Type#String} in {@link Type}
	 * , it will<br> throws a {@link BadTypeException}.
	 * @return the string of this entry.
	 * @throws BadTypeException when the type does not match.
	 */
	public final String getString() throws BadTypeException {
		if (this.type == Type.STRING) {
			return this.str;
		} else {
			//refactor to throw exception when types do not match.
			throw new BadTypeException("Bad Type! Need a STRING!");
		}
	}

}
