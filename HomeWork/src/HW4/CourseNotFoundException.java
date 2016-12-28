package HW4;

/**
 * Creates a class CourseNotFoundException that extends Exception
 * @author Emily Bigwood and Mengyi Qiu
 * 12/02/16
 */

public class CourseNotFoundException extends Exception {
	public CourseNotFoundException(){
		super();
	}
	
	/**
	* Constructs an object of type CourseNotFoundException
	* @param message: The message that is displayed when the exception is thrown
	*/

	public CourseNotFoundException(String message){
		super(message);
	}
	
}
