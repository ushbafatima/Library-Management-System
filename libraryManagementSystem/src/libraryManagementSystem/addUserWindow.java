package libraryManagementSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class addUserWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentNameField;
	private JTextField studentIDField;
	private JTextField contactField;

	/**
	 * Launch the application.
	 */

	/********************** MAIN METHOD ****************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUserWindow frame = new addUserWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/********************** MAIN METHOD ****************************/

	/**
	 * Create the frame.
	 */
	public addUserWindow() {

		// Window GUI
		setResizable(false);
		setTitle("Add User");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\adduser.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/******************* LABELS **********************/
		JLabel lblID = new JLabel("Student ID:");
		lblID.setForeground(new Color(0, 64, 128));
		lblID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblID.setBounds(165, 191, 169, 43);
		contentPane.add(lblID);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setForeground(new Color(0, 64, 128));
		lblStudentName.setFont(new Font("Calibri", Font.BOLD, 19));
		lblStudentName.setBounds(165, 131, 158, 43);
		contentPane.add(lblStudentName);

		JLabel lblcontact = new JLabel("Contact No.:");
		lblcontact.setForeground(new Color(0, 64, 128));
		lblcontact.setFont(new Font("Calibri", Font.BOLD, 19));
		lblcontact.setBounds(165, 255, 130, 43);
		contentPane.add(lblcontact);

		JLabel lblcourse = new JLabel("Course:");
		lblcourse.setForeground(new Color(0, 64, 128));
		lblcourse.setFont(new Font("Calibri", Font.BOLD, 19));
		lblcourse.setBounds(165, 321, 90, 43);
		contentPane.add(lblcourse);

		JLabel lblAddUser = new JLabel("    ADD USER");
		lblAddUser.setForeground(new Color(0, 64, 128));
		lblAddUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\adduser1.png"));
		lblAddUser.setBounds(160, 10, 420, 90);
		contentPane.add(lblAddUser);
		/******************* LABELS **********************/

		/***************** TEXT FIELDS *******************/
		studentNameField = new JTextField();
		studentNameField.setBackground(SystemColor.info);
		studentNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentNameField.setBounds(319, 135, 261, 31);
		contentPane.add(studentNameField);
		studentNameField.setColumns(10);

		studentIDField = new JTextField();
		studentIDField.setBackground(SystemColor.info);
		studentIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentIDField.setBounds(319, 195, 261, 31);
		contentPane.add(studentIDField);
		studentIDField.setColumns(10);

		contactField = new JTextField();
		contactField.setBackground(SystemColor.info);
		contactField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contactField.setBounds(319, 260, 261, 31);
		contentPane.add(contactField);
		contactField.setColumns(10);
		/***************** TEXT FIELDS *******************/

		/***************** COMBO BOX ********************/
		JComboBox courseBox = new JComboBox();
		courseBox.setBackground(SystemColor.control);
		courseBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		courseBox.setModel(new DefaultComboBoxModel(new String[] { "BESE", "BSDS", "BSCS", "BEE" }));
		courseBox.setMaximumRowCount(4);
		courseBox.setBounds(319, 325, 261, 30);
		contentPane.add(courseBox);
		/***************** COMBO BOX ********************/
		
		/***************** BUTTONS *********************/
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setForeground(new Color(0, 64, 128));
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 15));

		// Giving action to add user button
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Retrieving the user information from the text fields
				String studentName = studentNameField.getText();
				String studentID = studentIDField.getText();
				String contactNo = contactField.getText();
				String course = courseBox.getSelectedItem().toString();

				// Removing nay spaces in the contact number or ID.
				contactNo = contactNo.replace(" ", "");
				studentID = studentID.replace(" ", "");

				/*********************** ERROR HANDLING **************************/

				// Checking if all fields have been filled
				if (studentName.isEmpty() || studentID.isEmpty() || contactNo.isEmpty() || course.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Fill in All FIelds", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Perform additional validations

					// Validate ID (it should be numeric)
					if (!Library.isValidID(studentID)) {
						JOptionPane.showMessageDialog(null, "Invalid ID Value.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Validate contact number (it should be numeric)
					try {

						// Converts the contact number string to a long value
						long contactValue = Long.parseLong(contactNo);

						// Check if contact number is a positive number and has a valid length
						if (contactValue <= 0 || contactNo.length() != 11) {
							JOptionPane.showMessageDialog(null, "Invalid contact number.", "Error",
									JOptionPane.ERROR_MESSAGE);
							return; // Exit method if validation fails
						}
					} catch (NumberFormatException ex) {

						// Handle invalid contact number, if it has characters other than digits
						JOptionPane.showMessageDialog(null, "Contact number must be a numeric value.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return; // Exit method if validation fails
					}

					// Validation of Student name
					try {

						// Check if students name contains any numbers
						if (studentName.matches(".*\\d.*")) {
							throw new IllegalArgumentException();
						}

					} catch (IllegalArgumentException e1) {
						// Display error message dialog box
						JOptionPane.showMessageDialog(null,
								"Error: Username is not valid. Please provide a valid username.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
				/*********************** ERROR HANDLING **************************/

				// Creating an Object of the User as per the provided details
				User userX = new User();
				userX.setUserName(studentName);
				userX.setUserID(studentID);
				userX.setContactNo(contactNo);
				userX.setCourseName(course);

				// Adding user to the database
				if (Library.addUserToDB(userX)) {
					JOptionPane.showMessageDialog(rootPane, "Record Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
					clear();
				} else
					// Error message if the student already exists based in the Student ID
					JOptionPane.showMessageDialog(null, "Record Already Exists", "Error", JOptionPane.ERROR_MESSAGE);

			}

		});
		btnAddUser.setBounds(319, 410, 124, 31);
		contentPane.add(btnAddUser);

		// Close button to dispose the window
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(new Color(0, 64, 128));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(456, 410, 124, 31);
		contentPane.add(btnClose);
		/***************** BUTTONS *********************/
		
		/*************** BACKGROUND *******************/
		JLabel background = new JLabel("");
		background.setIcon(
				new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		background.setBounds(0, 0, 801, 505);
		contentPane.add(background);
		/*************** BACKGROUND *******************/
	}

	// Method to clear all fields
	public void clear() {
		studentIDField.setText("");
		studentNameField.setText("");
		contactField.setText("");

	}
}
