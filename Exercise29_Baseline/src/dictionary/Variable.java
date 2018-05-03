package dictionary;

/**
 * <p>
 * Title: Variable Class - A component of the dictionary package
 * </p>
 *
 * <p>
 * Description: An entity class used to specify the dictionary entry data
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2012
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.01
 */
public class Variable implements Comparable<Variable> {

	private String name;	// A dictionary entry consists of a variable name (string) and the
	private double value;	// current value of the variable (a double)

	/**********
	 * The fully parameterized constructor that defines the variable object for the dictionary
	 *
	 * @param n		// The identifier that specifies the variable's name
	 * @param v		// The double value that specifies the initial value for the variable
	 */
	public Variable(String n, double v){
		name = n; value = v;
	}

	/**********
	 * Returns the identifier for this variable
	 *
	 * @return		The string that is this variable's name (identifier)
	 */
	public String getName(){
		return name;
	}

	/**********
	 * Returns the current value of this variable
	 *
	 * @return		The double that specifies this variable's current value
	 */
	public double getValue(){
		return value;
	}

	/**********
	 * Changes the current value for a variable's value to a new value specified by the parameter
	 *
	 * @param v		The double that is to be the new value for this variable
	 */
	public void setValue(double v){
		value = v;
	}

	/**********
	 * Compare two variable objects by just comparing their identifiers... ignore the value attributes
	 */
	public int compareTo(Variable other){
		return this.name.compareTo(other.name);
	}

	/**********
	 * Return a string for this object produced by taking the variable's name (identifier) followed by
	 * an equal sign followed by the a string representation of the double that is the current value of
	 * the variable.  (Notice: this is *not* the original text representation of the value.)
	 */
	public String toString(){
		return name + " = " + value;
	}
}
