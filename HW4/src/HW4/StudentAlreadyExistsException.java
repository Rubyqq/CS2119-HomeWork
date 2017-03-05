package HW4;

/**
 * Creates the class StudentAlreadyExistsException that extends Exception
 * @author Emily Bigwood and Mengyi Qiu
 * 12/02/16
 */

public class StudentAlreadyExistsException extends Exception{
	public StudentAlreadyExistsException(){
		super();
	}
	
	/**
	* Constructs an object of type StudentAlreadyExistsException
	* @param message: The message that is displayed when the exception is thrown
	*/

	public StudentAlreadyExistsException(String message){
		super(message);
	}
}