package HW4;

/**
 * Creates a class Course
 * @author Emily Bigwood and  Mengyi Qiu
 * 12/2/16
 */

public class Course {
	private String dept;
	private String coursenum;
	private String title;
	private GradeType grade;


/**
* Constructs an object of the type Course
* @param dept: The department that the course falls under
* @param courseNum: The number of the course
* @param title: The title of the course
*/
	
	public Course(String dept, String coursenum, String title){
		this.dept = dept;
		this.coursenum = coursenum;
		this.title = title;
	}
	
	/**
	* Checks to see if the course has a department and course number
	* @param dept: The department that the course falls under
	* @param courseNum: The number of the course
	* @return: returns true if the course has said department and course number, 
	* and false if it does not 
	*/
	
	public boolean hasDeptNum(String dept, String coursenum){
		if (this.dept == dept && this.coursenum == coursenum){return true;}
		else return false;
	}
	
	/**
	* Sets the grade in a course to the given GradeType
	* @param g: a grade of either A, B, C, IP, or NR
	*/

	public void setGrade(GradeType g){
		grade = g;
		return;
	}
	
	/**
	* Checks to see if a course is complete
	* @return: returns true if the course is complete, and false if it is not
	*/

	public boolean isACompletedCourse(){
		switch (this.grade){
		case IP:
			return false;
		case NR: //did not exclude NR>>>>>
			return true;
		default: 
			return true;
		}
	}


	/**
	* Checks to see if a course is passed
	* @return: returns true is a course is passed, and false if it is not
	*/
	
	public boolean isAPassedCourse(){
		switch (this.grade){
		case A:
			return true;
		case B:
			return true;
		case C: 
			return true;
		default: 
			return false;
		}
	}
	public String toString(){
		return dept + coursenum + title;
	}

}
