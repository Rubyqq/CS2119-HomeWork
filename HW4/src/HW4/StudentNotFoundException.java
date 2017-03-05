package HW4;

/**
 * Creates a class StudentNotFoundException that extends Exception
 * @author Emily Bigwood and Mengyi Qiu
 * 12/02/2016
 */

public class StudentNotFoundException extends Exception{
	String message;
	
	/**
	* Constructs an object of the type StudentNotFoundException
	*/

	public StudentNotFoundException(){
		super();
	}
	
	/**
	* Creates an object of the type StudentNotFoundException
	* @param message: The message that is displayed when the excpetion is thrown
	*/

	public StudentNotFoundException(String message){
		//super(message);
		this.message = message;
	}
	
	/**
	* Prints out the exception message
	*/
	
	public void printExeptionMsg(){
		System.out.println("EXCEPTION:"+message);
	}
}