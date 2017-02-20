package HW5package;

import java.util.ArrayList;


/**
 * Creates a class Student
 * @author Emily Bigwood and Mengyi Qiu
 *12/02/16
 */

public class Student {
	private int id;
	private String lastname;
	private String firstname;
	

	/**
	* Constructs an object of type Student
	* @param id: The student's id number
	* @param name: The student's name
	*/
	
	public Student (int id, String lastname, String firstname){
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		
	}
	
	/**
	 * Make a String of a student object
	 */	

	public String toString(){
		return id + firstname + lastname;
	}
	
	
	public boolean hasID(int id){
		if(this.id == id){return true;}
		else return false;
	}
	
	
	/**
	* Checks if the same student is entered more than once
	* @param t: a student
	* @return: returns true if there are duplicated students, and false if there are not
	*/

	public boolean checkDuplicatedStudent(Student t){
		if(this.id == t.id){return false;}
		else return true;
	}

}