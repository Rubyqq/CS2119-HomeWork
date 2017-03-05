package HW4;

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

	public void addStudent(Student s) throws StudentAlreadyExistsException{
		//a student to be added to the list of students
		for(Student p : students){
			if(p.checkDuplicatedStudent(s) == false){
				throw new StudentAlreadyExistsException("Student already exists in the student list");//return;
			}
		}
		students.add(s);
		//throw new StudentAlreadyExistsException("Student already exists in the student list");
	}
	
	/**
	* Deletes a student from the ArrayList students
	* @param id: A student's id number
	* @throws StudentNotFoundException: throws an exception if the student you attempt
	* to delete is not on the list of students
	*/
		
	public void deleteStudent(int id) throws StudentNotFoundException{
		//A student to be deleted from the list of students. The student to be deleted should be identified by the student id.
			for(int i = 0; i < students.size(); i++){
				if(students.get(i).hasID(id) == true){
					students.remove(students.indexOf(students.get(i)));
					return;
				}
					
			}
			throw new StudentNotFoundException("Can not find the student in the list");	
	}	
	
	/**
	* Changes a student's grade
	* @param id: a student's id number
	* @param dept: the department number of a course
	* @param courseNum: a course's number
	* @param newGrade: a student's new grade
	* @throws CourseNotFoundException: throws an exception if the course you are 
	* trying to change a grade for is not found
	* @throws StudentNotFoundException: throws an exception a student in the list of 
	* students is not found
	*/

	public void changeGrade(int id, String dept, String courseNum, GradeType newGrade) throws CourseNotFoundException, StudentNotFoundException {
		//The grade in a course to be changed for a student in the list (name your method changeGrade). 
		//The student would be identified by student id. The course would be identified by its department and course number.
		for(Student p : students){
			if(p.hasID(id)){
				p.changeStudentGrade(dept, courseNum, newGrade);
				if(p.checkExistCourse(dept, courseNum) == false){//Check if the course is exists>>>
					throw new CourseNotFoundException("Course can not be found in the list");
				}
			}
			throw new StudentNotFoundException("Can not find the student in the list");
		}
		
	}
	
	/**
	* Rolls the grades for each student in a list of students
	*/
	
	public void rollGrades(){
		//The current courses that have been assigned grades to be "rolled" into the list of the student's completed courses (name your method rollGrades). 
		//This should occur for every student in the list.
		for (Student p : students){
			p.rollStudentGrades();
		}
		return;
	}
	
	

}
