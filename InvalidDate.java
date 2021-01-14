import java.util.InputMismatchException;
/**
 * default constructor with no parameter that calls the super class which it inherits
 */
public class InvalidDate extends InputMismatchException {
	public InvalidDate() {
		super();
	}
	/**
	 * Constructor with one parameter 
	 * @param message of type String to be displayed to the user when the error is caught
	 */
	public InvalidDate(String message) {
		super(message);
	}
}
