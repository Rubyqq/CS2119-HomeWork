package HW4;

import java.util.ArrayList;


/**
 * Creates a class Student
 * @author Emily Bigwood and Mengyi Qiu
 *12/02/16
 */

public class Student {
	private int id;
	private String name;
	private ArrayList<Course>enrolled;
	private ArrayList<Course>credited;
	

	/**
	* Constructs an object of type Student
	* @param id: The student's id number
	* @param name: The student's name
	*/
	
	public Student (int id, String name){
		this.id = id;
		this.name = name;
		enrolled = new ArrayList<Course>();
		credited = new ArrayList<Course>();
	}
	
	/**
	 * Make a String of a student object
	 */	

	public String toString(){
		return id + name;
	}
	
	/**
	* Enrolls a student in a particular course
	* @param c: A course
	*/
	public void enroll(Course c){
		//A student to enroll in a course
		enrolled.add(c);
		return;
	}
	
	

	public void credited(Course d){
		credited.add(d);
		return;
	}
	
	/**
	* Checks to see if a student has a certain id
	* @param id: The id number of the student
	* @return: return true if the student has a given id, but false if the student does not
	*/
	
	public boolean hasID(int id){
		if(this.id == id){return true;}
		else return false;
	}
	
	/**
	* Changes a student's grade in a particular course to the given grade
	* @param dept: The course's department
	* @param courseNum: The course number
	* @param newGrade: The student's new grade
	*/

	public void changeStudentGrade(String dept, String courseNum, GradeType newGrade){
		for(Course c : enrolled){//change from credit to enroll>>>>>
			if(c.hasDeptNum(dept, courseNum)){
				c.setGrade(newGrade);
			}
		}
	}
	
	/**
	 * Check if the course exists in the enrolled list
	 * @param department the input department number
	 * @param courseNum input course number
	 * @return true if the department number and course number exists and false if the department and course number does not exist
	 */
	public boolean checkExistCourse(String department, String courseNum){//add new method to check if the course is exist or not>>>>
		for(Course d : enrolled){
			if(d.hasDeptNum(department, courseNum)){
				return true;
			}
		}
		return false;
	}
	
	/**
	* Removes a course from a student's list of enrolled courses and adds it to the
	* student's list of credited courses when the student completes and passes a course.
	* However, if the student receives a grade of NR, the course is removed from the 
	* student's list of enrolled courses but not added to the list of credited courses.
	*/
	
	public void rollStudentGrades(){
		for(int i = 0; i < enrolled.size(); i++){
			if(enrolled.get(i).isACompletedCourse() && enrolled.get(i).isAPassedCourse()){
				credited.add(enrolled.get(i));
				enrolled.remove(enrolled.get(i));
			}
			else if(enrolled.get(i).isACompletedCourse() && !enrolled.get(i).isAPassedCourse()){
				enrolled.remove(enrolled.get(i));
			}
		}
		return;
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
