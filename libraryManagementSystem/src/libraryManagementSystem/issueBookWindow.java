package libraryManagementSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class issueBookWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookNameField;
	private JTextField bookIDField;
	private JTextField studentIDField;
	private JTextField issueDateField;
	private JTextField dueDateField;
	private JTextField studentNameField;

	/**
	 * Launch the application.
	 */

	/************** MAIN METHOD ***************/
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issueBookWindow frame = new issueBookWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/************** MAIN METHOD ***************/
	/**
	 * Create the frame.
	 */

	public issueBookWindow() {
		// GUI SETUP
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\issuebook.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**************** LABELS ****************/
		JLabel lblTitle = new JLabel("     ISSUE BOOK");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 64, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\issuebook1.png"));
		lblTitle.setBounds(178, 40, 431, 83);
		contentPane.add(lblTitle);

		JLabel lblBookTitle = new JLabel("Book Title:");
		lblBookTitle.setForeground(new Color(0, 64, 128));
		lblBookTitle.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookTitle.setBounds(162, 193, 102, 24);
		contentPane.add(lblBookTitle);

		JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setForeground(new Color(0, 64, 128));
		lblBookID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookID.setBounds(162, 142, 102, 24);
		contentPane.add(lblBookID);

		JLabel lblStudentID = new JLabel("Student ID:");
		lblStudentID.setForeground(new Color(0, 64, 128));
		lblStudentID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblStudentID.setBounds(162, 240, 102, 32);
		contentPane.add(lblStudentID);

		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setForeground(new Color(0, 64, 128));
		lblIssueDate.setFont(new Font("Calibri", Font.BOLD, 19));
		lblIssueDate.setBounds(162, 344, 102, 24);
		contentPane.add(lblIssueDate);

		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setForeground(new Color(0, 64, 128));
		lblDueDate.setFont(new Font("Calibri", Font.BOLD, 19));
		lblDueDate.setBounds(162, 385, 102, 24);
		contentPane.add(lblDueDate);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setForeground(new Color(0, 64, 128));
		lblStudentName.setFont(new Font("Calibri", Font.BOLD, 19));
		lblStudentName.setBounds(162, 294, 133, 32);
		contentPane.add(lblStudentName);
		/**************** LABELS ****************/

		/*************** TEXT FIELDS ****************/
		bookNameField = new JTextField();
		bookNameField.setEditable(false);
		bookNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookNameField.setBackground(SystemColor.controlHighlight);
		bookNameField.setBounds(305, 186, 204, 31);
		contentPane.add(bookNameField);
		bookNameField.setColumns(10);

		bookIDField = new JTextField();
		bookIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookIDField.setBackground(SystemColor.info);
		bookIDField.setBounds(305, 135, 204, 31);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);

		studentIDField = new JTextField();
		studentIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentIDField.setBackground(SystemColor.info);
		studentIDField.setBounds(305, 237, 204, 31);
		contentPane.add(studentIDField);
		studentIDField.setColumns(10);

		studentNameField = new JTextField();
		studentNameField.setEditable(false);
		studentNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentNameField.setColumns(10);
		studentNameField.setBackground(SystemColor.controlHighlight);
		studentNameField.setBounds(305, 291, 204, 31);
		contentPane.add(studentNameField);

		issueDateField = new JTextField();
		issueDateField.setBackground(SystemColor.controlHighlight);
		issueDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		issueDateField.setEditable(false);
		issueDateField.setBounds(305, 337, 204, 31);
		contentPane.add(issueDateField);
		issueDateField.setColumns(10);

		// Gets current date in the format dd/MM/yyyy
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		issueDateField.setText(date.format(d));

		dueDateField = new JTextField();
		dueDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dueDateField.setBackground(SystemColor.info);
		dueDateField.setBounds(305, 378, 204, 31);
		contentPane.add(dueDateField);
		dueDateField.setColumns(10);
		/*************** TEXT FIELDS ****************/

		/***************** BUTTONS ******************/
		// Close button to dispose window
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setForeground(new Color(0, 64, 128));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		btnClose.setBounds(424, 436, 85, 28);
		contentPane.add(btnClose);

		// Search Button 1 is used to get Book name when Book ID is entered
		JButton btnSearch1 = new JButton("Search");
		btnSearch1.setBackground(SystemColor.activeCaption);
		btnSearch1.setForeground(new Color(0, 64, 128));
		btnSearch1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookID = bookIDField.getText();
				// Checks if ID has been provided
				if (bookID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Add Book ID", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// Input validation
				if (!Library.isValidID(bookID)) {
					JOptionPane.showMessageDialog(null, "Invalid ID Value.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Create a new Book object to store the found book
				Book foundBook = new Book();

				// Search for the book by its ID using the Library.findBookbyID() method
				foundBook = Library.findBookbyID(bookID);

				// Check if the book is found
				if (foundBook != null) {
					// If the book is found, set the text of the bookNameField to the book's title
					bookNameField.setText(foundBook.getBookTitle());
				} else {
					// If the book is not found, display an error message
					JOptionPane.showMessageDialog(null, "Book not Found.", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnSearch1.setBounds(546, 135, 85, 32);
		contentPane.add(btnSearch1);

		// Search Button 2 is used to get Student name when student id is entered
		JButton btnSearch2 = new JButton("Search");
		btnSearch2.setBackground(SystemColor.activeCaption);
		btnSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID = studentIDField.getText();
				// Checks if student ID has been entered or not
				if (studentID.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Add Student ID", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// Validates Student ID
					if (!Library.isValidID(studentID)) {
						JOptionPane.showMessageDialog(null, "Invalid ID Value.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Creates a User object and searches for it in the Database
					User foundUser = new User();
					foundUser = Library.findUserbyID(studentID);

					// Check if the user is found
					if (foundUser != null) {
						// If the user is found, set the text of the studentNameField to the user's name
						studentNameField.setText(foundUser.getUserName());
					} else {
						// If the user is not found, display an error message
						JOptionPane.showMessageDialog(null, "User not Found.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSearch2.setForeground(new Color(0, 64, 128));
		btnSearch2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch2.setBounds(546, 236, 85, 32);
		contentPane.add(btnSearch2);

		// Issue Book Button
		JButton btnIssue = new JButton("Issue");
		btnIssue.setForeground(new Color(0, 64, 128));
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = bookNameField.getText();
				String bookID = bookIDField.getText();
				String studentName = studentNameField.getText();
				String studentID = studentIDField.getText();
				String issueDate = issueDateField.getText();
				String dueDate = dueDateField.getText();

				// Checking if all fields have been filled
				if (bookName.isEmpty() || issueDate.isEmpty() || studentName.isEmpty() || dueDate.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Fill in All Fields", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					// Checking if correct due date has been entered
					try {
						// Checks if due date has any alphabets
						if (dueDate.matches(".*[a-zA-Z].*")) {
							JOptionPane.showMessageDialog(null, "Invalid Due Date", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}

					} catch (IllegalArgumentException e2) {
						JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				// Checking if the book is available or not
				boolean available = false;
				Book foundBook = new Book();
				foundBook = Library.findBookbyID(bookIDField.getText());

				if (foundBook != null) {
					String availability = foundBook.getAvailability();
					available = (availability.equals("Available")) ? true : false;

				} else {
					JOptionPane.showMessageDialog(null, "Book Availability not Found.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// Issue book if book is avaialable
				if (available) {
					// If the book is available, create a new Book object to issue
					Book bookToIssue = new Book();

					// Set the details of the book to be issued
					bookToIssue.setBookTitle(bookName);
					bookToIssue.setBookID(bookID);
					bookToIssue.setUserID(studentID);
					bookToIssue.setIssueDate(issueDate);
					bookToIssue.setDueDate(dueDate);

					// Attempt to issue the book using the Library class method
					if (Library.issueBook(bookToIssue)) {
						// Display a success message
						JOptionPane.showMessageDialog(rootPane, "Book Issued", "", JOptionPane.INFORMATION_MESSAGE);
						clear();
					} else {
						// Display an error message
						JOptionPane.showMessageDialog(rootPane, "Failed to issue book", "", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					// Display a message indicating that the book is not available
					JOptionPane.showMessageDialog(rootPane, "Book Not Available", "Not Available",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnIssue.setBounds(305, 436, 85, 28);
		contentPane.add(btnIssue);
		/***************** BUTTONS ******************/

		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(
				new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		lblBackGround.setBounds(0, 0, 786, 493);
		contentPane.add(lblBackGround);
	}

	// Method to clear all fields
	public void clear() {

		bookIDField.setText("");
		bookNameField.setText("");
		studentIDField.setText("");
		dueDateField.setText("");
		studentNameField.setText("");

	}
}
