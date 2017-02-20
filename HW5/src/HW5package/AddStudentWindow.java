package HW5package;

import javax.swing.DefaultListModel;

public class AddStudentWindow {
	
	private Students students;
	private DefaultListModel listModel;
	NewWindow frame;

	public AddStudentWindow(DefaultListModel<String> listModel2, Students students2) {
		students = students2;
		listModel = listModel2;
		frame = new NewWindow(students, listModel);
		frame.setTitle("Add Student Information");
		frame.setVisible(true);
		
	}
	
}
