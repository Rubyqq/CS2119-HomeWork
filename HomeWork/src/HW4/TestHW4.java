package HW4;

public class TestHW4 {
	public static void main(String [] args){
		Student s1 = new Student(1, "Anne");
		Student v1 = new Student(2, "Bnne");
		Student j1 = new Student(1, "Anne");
		Student k1 = new Student(3, "Janne");
		Student f1 = new Student(7, "Banne");
		Course c0 = new Course("CS", "2119", "java");
		Course d0 = new Course("CS", "2110", "C++");
		Course e0 = new Course("CS", "2111", "C#");
		
		s1.toString();
		v1.toString();
		j1.toString();
		k1.toString();
		
		c0.toString();
		d0.toString();
		e0.toString();
		
		s1.enroll(c0);
		s1.enroll(d0);
		s1.enroll(e0);
		
		v1.enroll(c0);
		v1.enroll(d0);
		v1.enroll(e0);
		
		j1.enroll(c0);
		j1.enroll(d0);
		j1.enroll(e0);
		
		k1.enroll(c0);
		k1.enroll(d0);
		k1.enroll(e0);
		
		c0.setGrade(GradeType.IP);
		d0.setGrade(GradeType.IP);
		e0.setGrade(GradeType.IP);
		
		
		s1.changeStudentGrade("CS", "2119", GradeType.A);
		s1.changeStudentGrade("CS", "2110", GradeType.NR);
		s1.changeStudentGrade("CS", "2111", GradeType.A);
		v1.changeStudentGrade("CS", "2119", GradeType.B);
		v1.changeStudentGrade("CS", "2110", GradeType.A);
		v1.changeStudentGrade("CS", "2111", GradeType.IP);
		j1.changeStudentGrade("CS", "2119", GradeType.A);
		j1.changeStudentGrade("CS", "2110", GradeType.B);
		j1.changeStudentGrade("CS", "2111", GradeType.C);
		k1.changeStudentGrade("CS", "2119", GradeType.A);
		k1.changeStudentGrade("CS", "2110", GradeType.NR);
		k1.changeStudentGrade("CS", "2111", GradeType.A);
	
		
		
		Students a = new Students();
		
		try{
			a.addStudent(s1); 
			a.addStudent(j1);
		}catch(StudentAlreadyExistsException e){
			System.out.print(e.getMessage());
		}
		try{
			a.addStudent(k1);
			a.addStudent(v1);
			a.addStudent(f1);
		}catch(StudentAlreadyExistsException e){
			System.out.print(e.getMessage());
		}
		try {
			a.deleteStudent(7);
			a.deleteStudent(5);
		} catch (StudentNotFoundException e) {
			e.printExeptionMsg();
		}
		
		a.rollGrades();
		
		try{
			a.changeGrade(9, "CS", "2119", GradeType.A);
			//a.changeGrade(3, "DS", "3119", GradeType.A);
		}catch (CourseNotFoundException g) {
			g.getMessage();
		}catch(StudentNotFoundException h){
			h.printExeptionMsg();
		}
		try{
			//a.changeGrade(9, "CS", "2119", GradeType.A);
			a.changeGrade(1, "DS", "3119", GradeType.A);
		}catch (CourseNotFoundException g) {
			g.getMessage();
		}catch(StudentNotFoundException h){
			h.printExeptionMsg();
		}
		
	}
}
