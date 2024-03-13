package libraryManagementSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class returnBookWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookIDField;
	private JTextField bookNameField;
	private JTextField studentIDField;
	private JTextField dueDateField;
	private JTextField issueDateField;

	/**
	 * Launch the application.
	 */
	
	/*************** MAIN METHOD ****************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBookWindow frame = new returnBookWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*************** MAIN METHOD ****************/

	/**
	 * Create the frame.
	 */
	public returnBookWindow() {
		// GUI SETUP
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\return.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/***************** LABELS ***************/
		JLabel lblTitle = new JLabel("    RETURN BOOK");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\returnbook1.png"));
		lblTitle.setForeground(new Color(0, 64, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(186, 33, 395, 73);
		contentPane.add(lblTitle);

		JLabel lblStudentName = new JLabel("Student ID:");
		lblStudentName.setForeground(new Color(0, 64, 128));
		lblStudentName.setFont(new Font("Calibri", Font.BOLD, 19));
		lblStudentName.setBounds(186, 241, 128, 21);
		contentPane.add(lblStudentName);

		JLabel lblIssueDate = new JLabel("Issue Date:");
		lblIssueDate.setForeground(new Color(0, 64, 128));
		lblIssueDate.setFont(new Font("Calibri", Font.BOLD, 19));
		lblIssueDate.setBounds(186, 298, 113, 21);
		contentPane.add(lblIssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setForeground(new Color(0, 64, 128));
		lblDueDate.setFont(new Font("Calibri", Font.BOLD, 19));
		lblDueDate.setBounds(186, 355, 113, 21);
		contentPane.add(lblDueDate);
		
		JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setForeground(new Color(0, 64, 128));
		lblBookID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookID.setBounds(186, 141, 102, 24);
		contentPane.add(lblBookID);
		
		JLabel lblBookTitle = new JLabel("Book Title:");
		lblBookTitle.setForeground(new Color(0, 64, 128));
		lblBookTitle.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookTitle.setBounds(186, 189, 102, 24);
		contentPane.add(lblBookTitle);
		
		/***************** LABELS ***************/
		
		/**************** TEXT FIELDS ***************/
		bookIDField = new JTextField();
		bookIDField.setBackground(SystemColor.info);
		bookIDField.setBounds(319, 137, 230, 31);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);

		bookNameField = new JTextField();
		bookNameField.setBackground(SystemColor.controlHighlight);
		bookNameField.setEditable(false);
		bookNameField.setBounds(319, 185, 230, 31);
		contentPane.add(bookNameField);
		bookNameField.setColumns(10);

		studentIDField = new JTextField();
		studentIDField.setBackground(SystemColor.controlHighlight);
		studentIDField.setEditable(false);
		studentIDField.setBounds(319, 235, 230, 31);
		contentPane.add(studentIDField);
		studentIDField.setColumns(10);

		dueDateField = new JTextField();
		dueDateField.setBackground(SystemColor.controlHighlight);
		dueDateField.setEditable(false);
		dueDateField.setBounds(319, 349, 230, 31);
		contentPane.add(dueDateField);
		dueDateField.setColumns(10);

		issueDateField = new JTextField();
		issueDateField.setBackground(SystemColor.controlHighlight);
		issueDateField.setEditable(false);
		issueDateField.setBounds(319, 292, 230, 31);
		contentPane.add(issueDateField);
		issueDateField.setColumns(10);
		/**************** TEXT FIELDS ***************/

		/***************** BUTTONS *****************/
		JButton btnReturn = new JButton("Return");
		btnReturn.setForeground(new Color(0, 64, 128));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReturn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the book ID entered by the user
		        String bookID = bookIDField.getText();
		        
		        // Check if the book ID is empty
		        if (bookID.isEmpty()) {
		            JOptionPane.showMessageDialog(rootPane, "Please Enter Book ID", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        // Create a new Book object to represent the book to be returned
		        Book bookToReturn = new Book();
		        bookToReturn.setBookID(bookID);

		        // Attempt to return the book using the Library class method
		        if (Library.returnBook(bookToReturn)) {
		            // Display a success message
		            JOptionPane.showMessageDialog(rootPane, "Book Returned", "", JOptionPane.INFORMATION_MESSAGE);
		            clear();
		        } else { 
		            // Display an error message
		            JOptionPane.showMessageDialog(rootPane, "Failed to return book", "", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		    }
		});

		btnReturn.setBounds(319, 416, 93, 31);
		contentPane.add(btnReturn);

		// Dispose Window on Close button
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setForeground(new Color(0, 64, 128));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(464, 416, 85, 31);
		contentPane.add(btnClose);

		// Search Button
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setForeground(new Color(0, 64, 128));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // Get the book ID entered by the user
			    String bookID = bookIDField.getText();
			    
			    // Check if the book ID is empty
			    if (bookID.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Please Add Book ID", "Error", JOptionPane.ERROR_MESSAGE);
			        return;
			    }

			    // Validate the book ID (ensure it is numeric)
			    if (!Library.isValidID(bookID)) {
			             JOptionPane.showMessageDialog(null, "Invalid ID Value.", "Error", JOptionPane.ERROR_MESSAGE);
			        clear();
			        return;
			    }

			    Boolean available = false;

			    // Create a new Book object to store the found book details
			    Book foundBook = new Book();
			    foundBook.setBookID(bookID);
			    
			    // Retrieve book details from the Library using the book ID
			    foundBook = Library.findBookbyID(bookIDField.getText());

			    // Check if the book was found
			    if (foundBook != null) {
			        // If found, populate the fields with the book details
			        bookNameField.setText(foundBook.getBookTitle());
			        studentIDField.setText(foundBook.getUserID());
			        issueDateField.setText(foundBook.getIssueDate());
			        dueDateField.setText(foundBook.getDueDate());

			        // Check if the book is available for issuance
			        available = foundBook.getAvailability().equals("Available");
			    } else {
			        // If the book was not found, display an error message
			        JOptionPane.showMessageDialog(null, "Book not Found.", "Error", JOptionPane.ERROR_MESSAGE);
			        clear();
			        return;
			    }

			    // If the book is available for issuance
			    if (available) {
			        JOptionPane.showMessageDialog(rootPane, "Book was not Issued", "", JOptionPane.ERROR_MESSAGE);
			        clear();
			        return;
			    }
			}

		});
		btnSearch.setBounds(579, 135, 93, 31);
		contentPane.add(btnSearch);
		/***************** BUTTONS *****************/
		
		/***************** BACKGROUND **************/
		JLabel background = new JLabel("");
		background.setIcon(
				new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		background.setBounds(0, 0, 786, 493);
		contentPane.add(background);
		/***************** BACKGROUND **************/
	}

	// Clear all Fields
	public void clear() {
		bookIDField.setText("");
		studentIDField.setText("");
		bookNameField.setText("");
		dueDateField.setText("");
		issueDateField.setText("");
	}
}