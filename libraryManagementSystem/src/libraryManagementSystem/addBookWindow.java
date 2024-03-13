package libraryManagementSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class addBookWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookIDField;
	private JTextField authorField;
	private JTextField genreField;
	private JLabel lblBookTItle;
	private JTextField bookNameField;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	
	/*************************** MAIN METHOD *******************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBookWindow frame = new addBookWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*************************** MAIN METHOD *******************************/

	/**
	 * Create the frame.
	 */
	public addBookWindow() {
		// GUI Setup
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\addbook.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/******************* LABELS **********************/
		JLabel lblTitle = new JLabel("    ADD BOOK");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\addbook1.png"));
		lblTitle.setForeground(new Color(0, 64, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(165, 35, 415, 69);
		contentPane.add(lblTitle);
		
		lblBookTItle = new JLabel("Book Title:");
		lblBookTItle.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookTItle.setForeground(new Color(0, 64, 128));
		lblBookTItle.setBounds(165, 138, 158, 43);
		contentPane.add(lblBookTItle);
		
		JLabel lblID = new JLabel("Book ID:");
		lblID.setForeground(new Color(0, 64, 128));
		lblID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblID.setBounds(165, 201, 90, 31);
		contentPane.add(lblID);
		
		JLabel lblAuthor = new JLabel("Book Author:");
		lblAuthor.setForeground(new Color(0, 64, 128));
		lblAuthor.setFont(new Font("Calibri", Font.BOLD, 19));
		lblAuthor.setBounds(165, 254, 129, 38);
		contentPane.add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setForeground(new Color(0, 64, 128));
		lblGenre.setFont(new Font("Calibri", Font.BOLD, 19));
		lblGenre.setBounds(165, 316, 129, 31);
		contentPane.add(lblGenre);
		/******************* LABELS **********************/
		
		/************** TEXT FIELDS *********************/
		bookIDField = new JTextField();
		bookIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookIDField.setBackground(SystemColor.info);
		bookIDField.setBounds(319, 200, 261, 31);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		authorField.setBackground(SystemColor.info);
		authorField.setBounds(319, 257, 261,31);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		genreField = new JTextField();
		genreField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		genreField.setBackground(SystemColor.info);
		genreField.setBounds(319, 315, 261, 31);
		contentPane.add(genreField);
		genreField.setColumns(10);
		
		bookNameField = new JTextField();
		bookNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookNameField.setBackground(SystemColor.info);
		bookNameField.setBounds(319, 144, 261, 31);
		contentPane.add(bookNameField);
		bookNameField.setColumns(10);
		/************** TEXT FIELDS *********************/
		
		/**************** BUTTONS **********************/
		// Add Book Button
		JButton btnAdddBook = new JButton("Add Book");
		
		// Button Actions
		btnAdddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Retrieving the user information from the text fields
				String bookName = bookNameField.getText();
				String bookID = bookIDField.getText();
				String author = authorField.getText();
				String genre= genreField.getText();
				
				// Removing nay spaces in the book ID.
				bookID=bookID.replace(" ", "");
				
				/*************************** ERROR HANDLING **************************/
				if (bookName.isEmpty() || bookID.isEmpty() || author.isEmpty() || genre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Fill in All FIelds", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Perform additional validations
						
					// Validate ID (it should be numeric)
					if(!Library.isValidID(bookID)) {
						JOptionPane.showMessageDialog(null, "Invalid ID Value.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
	
					try {
			            
			            // Check if genre and author's name contains any numbers
			            if (author.matches(".*\\d.*")||genre.matches(".*\\d.*")) {
			                throw new IllegalArgumentException();
			            }
			            
			            
			        } catch ( IllegalArgumentException e1) {
			            // Display error message dialog box for invalid author's name
			            JOptionPane.showMessageDialog(null, "Error: Genre/Author Name is not valid.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					
					// Creating an Object of the Book as per the provided details
					Book bookX = new Book();
					bookX.setBookTitle(bookName);
					bookX.setBookID(bookID);
					bookX.setAuthor(author);
					bookX.setGenre(genre);
					bookX.setAvailability("Available");
					
					// Adding book to the database
					if (Library.addBookToDB(bookX)) {
						JOptionPane.showMessageDialog(rootPane, "Record Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
						clear();
					}
					// Error message if the Book already exists based on the Book ID
					else
						JOptionPane.showMessageDialog(null, "Record Already Exists", "Error", JOptionPane.ERROR_MESSAGE);

					
				}
			}
		});
		btnAdddBook.setForeground(new Color(0, 64, 128));
		btnAdddBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdddBook.setBounds(319, 410, 124, 31);
		contentPane.add(btnAdddBook);
		
		// Dispose Window on close button
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setForeground(new Color(0, 64, 128));
		btnClose.setBounds(456, 410, 124, 31);
		contentPane.add(btnClose);
		/**************** BUTTONS **********************/
		
		/*************** BACKGROUND *******************/
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		lblBackground.setBounds(0, 0, 786, 493);
		contentPane.add(lblBackground);
		/*************** BACKGROUND *******************/
	}
	
	
	public void clear() {
		bookIDField.setText("");
		bookNameField.setText("");
		authorField.setText("");
		genreField.setText("");
		
	}
}
