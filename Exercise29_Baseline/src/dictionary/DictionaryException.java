package dictionary;

public class DictionaryException extends Throwable {

	/**
	 * <p>
	 * Title: DictionaryException Class - A component of the dictionary package
	 * </p>
	 *
	 * <p>
	 * Description: An entity class used to specify the kind of dictionary error
	 * </p>
	 *
	 * <p>
	 * Copyright: Copyright © 2012
	 * </p>
	 *
	 * @author Lynn Robert Carter
	 * @version 1.01
	 */
	public DictionaryException(String s) {
		super(s);		// Just like all other exceptions with the exception that
						// this is a distinct exception that can been explicitly
						// caught without be caught by accident by others
	}
}
