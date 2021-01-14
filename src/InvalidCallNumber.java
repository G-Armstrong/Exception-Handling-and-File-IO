import java.util.InputMismatchException;
/**
 * default constructor with no parameter that calls the super class which it inherits
 */
public class InvalidCallNumber extends InputMismatchException {
	public InvalidCallNumber() {
		super();
	}
	/**
	 * Constructor with one parameter 
	 * @param message of type String to be displayed to the user when the error is caught
	 */
	public InvalidCallNumber(String message) {
		super(message);
	}
}
