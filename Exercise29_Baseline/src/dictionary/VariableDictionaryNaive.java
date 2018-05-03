package dictionary;

import binarySearchTree.BinarySearchTree;

/**
 * <p>
 * Title: VariableDictionary Class - A component of the dictionary package
 * </p>
 *
 * <p>
 * Description: A controller object class that implements the dictionary of variable objects
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2012
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.01
 */
public class VariableDictionaryNaive extends BinarySearchTree<Variable> {

	/**********
	 * This getter uses a string as input, creates a working variable object from it so the
	 * method can then use the generic get method from the super class to find the matching
	 * object in the dictionary.  If that get request succeeds, this method then returns the
	 * value attribute (double) from that objects, otherwise, an exception is thrown.
	 * 
	 * @param s		The string (an identifier) we wish to look up in the dictionary
	 * @return		The double value for the requested identifier, if it is indeed in the dictionary
	 * @throws DictionaryException	An exception is thrown if the requested identifier is not in
	 * 				the dictionary
	 */
	public double getValue(String s) throws DictionaryException{
		Variable v = get(new Variable(s,0));		// Try to get the dictionary entry with this identifier
		if (v != null) return v.getValue();			// if it comes back not null, use it to access the value
		throw new DictionaryException("Variable <" + s +  "> not defined.");	// Else throw and exception
	}

	/**********
	 * This setter creates a variable object from the specified parameters and then uses that object
	 * to replace the most previous value in the dictionary, if it is already there, or to add it
	 * 
	 * @param s		The string (identifier) that is the name of the variable
	 * @param d		The double (value) to be assigned to this variable
	 */
	public void setValue(String s, double d){
		set(new Variable(s,d));		// Create a new variable and then use it to set the value in the dictionary
	}
}
