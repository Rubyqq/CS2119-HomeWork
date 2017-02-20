package HW5package;

import javax.swing.JPanel;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// ** YOU MUST IMPORT ANY PACKAGES THAT CONTAIN THE CLASSES YOU WRITE**


public class HW5List extends JPanel implements ListSelectionListener {
	private JList<String> list;   
	private DefaultListModel<String> listModel;
	private Students students;      // the GUI needs access to the underlying model  
	                                // **YOU MUST PROVIDE Students CLASS**
	private JButton removeButton;   // this button needs to be accessed by the inner classes

	public HW5List() {
		super(new BorderLayout());

		// make the underlying model available
		// initially, there are no students
		this.students = new Students();

		// JLists are based on ListModels
		listModel = new DefaultListModel<String>();
		
		//Create the JList and put it in a scroll pane.
		
		list = new JList<String>(listModel);
		// only one item at a time may be selected from the JList
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(5);
		// when an item is selected, an event will be triggered.  The event handler for
		// list selections is the valueChanged() method
		list.addListSelectionListener(this);
		// put the list in a scroll pane
		JScrollPane listScrollPane = new JScrollPane(list);
		add(listScrollPane, BorderLayout.CENTER);

		JButton addButton = new JButton("Add");
		AddListener addListener = new AddListener();
		addButton.addActionListener(addListener);
		// initially, the add button should be enabled
		addButton.setEnabled(true);;

		removeButton = new JButton("Remove");
		removeButton.addActionListener(new RemoveListener());
		//initially, the remove button should be disabled
		removeButton.setEnabled(false);


		//Create a panel to hold the add/remove buttons...
		JPanel buttonPane = new JPanel();
		//...and add the buttons to the panel
		buttonPane.add(removeButton);               
		buttonPane.add(addButton);

		// add the button panel to the bottom of the JPanel
		add(buttonPane, BorderLayout.SOUTH);
	}


	// an inner class; needs to be able to access removeButton
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//This method will be called only if
			//there's a valid selection
			//so go ahead and remove whatever's selected.
			int index = list.getSelectedIndex();
			listModel.remove(index);
			

			//make the underlying model match the view
			students.remove(index);// index?????????????

			int size = listModel.getSize();

			if (size == 0) { //Nobody's left, disable firing.
				removeButton.setEnabled(false);

			} else { //Select an index.
				if (index == listModel.getSize()) {
					//removed item in last position
					index--;
				}

				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index);
			}
		}
	}

	//This listener is for the add button.
	class AddListener implements ActionListener {

		// Required by ActionListener.
		public void actionPerformed(ActionEvent e) {	

			// create a new frame for adding student information
			// ** YOU MUST DEFINE THE AddStudentWindow CLASS **
			AddStudentWindow addedStudent = new AddStudentWindow(listModel, students);		
		} 
	}

	//This method is required by ListSelectionListener.
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (list.getSelectedIndex() == -1) {
				//No selection, disable fire button.
				removeButton.setEnabled(false);

			} else {
				//Selection, enable the fire button.
				removeButton.setEnabled(true);
			}
		}
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Student Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		JPanel newContentPane = new HW5List();
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

