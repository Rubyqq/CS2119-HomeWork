package HW5package;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a class Students
 * @author Emily Bigwood and Mengyi Qiu
 *12/02/16
 */

public class Students {
	private ArrayList<Student>students;
	
	/**
	* Constructs an object of the type Students
	*/

	public Students(){
		students = new ArrayList<Student>();
	}
	
	/**
	* Adds a student to the ArrayList students
	* @param s: a student
	* @throws StudentAlreadyExistsException: Throws an exception if the student 
	* you attempt to add is already in the list of students
	*/

	public void addStudent(Student s){
		//a student to be added to the list of students
		for(Student p : students){
			if(p.checkDuplicatedStudent(s) == false){
				return;
			}
		}
		students.add(s);
		
	}
	
	/**
	* Deletes a student from the ArrayList students
	* @param id: A student's id number
	* @throws StudentNotFoundException: throws an exception if the student you attempt
	* to delete is not on the list of students
	*/
		
	public void remove(int id){
		//A student to be deleted from the list of students. The student to be deleted should be identified by the student id.
			for(int i = 0; i < students.size(); i++){
				if(students.get(i).hasID(id) == true){
					students.remove(students.indexOf(students.get(i)));
					return;
				}
					
			}			
	}

	public ArrayList<Student> getStudents() {
		return students;
	}	
	
	

}
