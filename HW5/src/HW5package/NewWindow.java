package HW5package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class NewWindow extends JFrame {
	private JTextField textField_2;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfStudentID;
	private JLabel lbLastName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewWindow frame = new NewWindow();
//					frame.setTitle("Add Student Information");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NewWindow(Students students, DefaultListModel listModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		NewWindow frameToBeClose = this;
		getContentPane().setLayout(null);
		
		JLabel lblFristName = new JLabel("Frist Name");
		lblFristName.setBounds(188, 13, 93, 16);
		getContentPane().add(lblFristName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(84, 39, 269, 22);
		getContentPane().add(tfFirstName);
		tfFirstName.setColumns(10);
		
		lbLastName = new JLabel("Last Name");
		lbLastName.setBounds(188, 74, 93, 16);
		getContentPane().add(lbLastName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(84, 103, 269, 22);
		getContentPane().add(tfLastName);
		tfLastName.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(122, 148, 86, 16);
		getContentPane().add(lblStudentId);
		
		tfStudentID = new JTextField();
		tfStudentID.setBounds(216, 145, 77, 22);
		getContentPane().add(tfStudentID);
		tfStudentID.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfStudentID.getText());
				String lastName = tfLastName.getText();
				String firstName = tfFirstName.getText();
				Student s = new Student(id, lastName, firstName);
				students.addStudent(s);
				frameToBeClose.dispose();
				listModel.addElement(s);

			}
		});
		btnOk.setBounds(84, 177, 97, 25);
		getContentPane().add(btnOk);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameToBeClose.dispose();
			}
		});
		btnNewButton.setBounds(253, 177, 97, 25);
		getContentPane().add(btnNewButton);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		
	}
}
