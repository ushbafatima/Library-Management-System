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
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class searchBookWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookTitleField;
	private JTextField bookIDField;
	private JTextField bookAuthorField;
	private JTextField bookGenreField;
	private JTextField availabilityField;

	/**
	 * Launch the application.
	 */

	/*************** MAIN METHOD ********************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchBookWindow frame = new searchBookWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*************** MAIN METHOD ********************/

	/**
	 * Create the frame.
	 */
	public searchBookWindow() {

		// GUI SETUP
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\datamining.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/***************** LABELS ******************/
		JLabel lblSearchBook = new JLabel("   SEARCH BOOK");
		lblSearchBook.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\search.png"));
		lblSearchBook.setForeground(new Color(0, 64, 128));
		lblSearchBook.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearchBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBook.setBounds(278, 44, 239, 66);
		contentPane.add(lblSearchBook);

		JLabel lblBookTitle = new JLabel("Book Title:");
		lblBookTitle.setForeground(new Color(0, 64, 128));
		lblBookTitle.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookTitle.setBounds(169, 144, 123, 24);
		contentPane.add(lblBookTitle);

		JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setForeground(new Color(0, 64, 128));
		lblBookID.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBookID.setBounds(169, 202, 103, 24);
		contentPane.add(lblBookID);

		JLabel lblAuthor = new JLabel("Book Author:");
		lblAuthor.setForeground(new Color(0, 64, 128));
		lblAuthor.setFont(new Font("Calibri", Font.BOLD, 19));
		lblAuthor.setBounds(169, 260, 123, 24);
		contentPane.add(lblAuthor);

		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(new Color(0, 64, 128));
		lblGenre.setFont(new Font("Calibri", Font.BOLD, 19));
		lblGenre.setBounds(169, 316, 123, 35);
		contentPane.add(lblGenre);

		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setForeground(new Color(0, 64, 128));
		lblAvailability.setFont(new Font("Calibri", Font.BOLD, 19));
		lblAvailability.setBounds(169, 372, 103, 35);
		contentPane.add(lblAvailability);
		/***************** LABELS ******************/

		/************** TEXT FIELDS ****************/
		bookTitleField = new JTextField();
		bookTitleField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookTitleField.setBackground(SystemColor.info);
		bookTitleField.setBounds(302, 140, 255, 31);
		contentPane.add(bookTitleField);

		bookTitleField.setColumns(10);
		bookIDField = new JTextField();
		bookIDField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookIDField.setBackground(SystemColor.controlHighlight);
		bookIDField.setEditable(false);
		bookIDField.setBounds(302, 198, 255, 31);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);

		bookAuthorField = new JTextField();
		bookAuthorField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookAuthorField.setBackground(SystemColor.controlHighlight);
		bookAuthorField.setEditable(false);
		bookAuthorField.setBounds(302, 256, 255, 31);
		contentPane.add(bookAuthorField);
		bookAuthorField.setColumns(10);

		bookGenreField = new JTextField();
		bookGenreField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookGenreField.setBackground(SystemColor.controlHighlight);
		bookGenreField.setEditable(false);
		bookGenreField.setBounds(302, 317, 255, 31);
		contentPane.add(bookGenreField);
		bookGenreField.setColumns(10);

		availabilityField = new JTextField();
		availabilityField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		availabilityField.setBackground(SystemColor.controlHighlight);
		availabilityField.setEditable(false);
		availabilityField.setBounds(302, 373, 255, 31);
		contentPane.add(availabilityField);
		availabilityField.setColumns(10);
		/************** TEXT FIELDS ****************/

		/*************** BUTTONS *****************/
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(176, 196, 222));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName = bookTitleField.getText();

				// Checks if book name has been entered or not
				if (bookName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Add Book Name", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// If the book name field is not empty, proceed to search for the book
					// Search for the book by its title
					Book foundBook = new Book();
					foundBook = Library.findBookbyTitle(bookName);

					// Check if the book is found
					if (foundBook != null) {
						// If the book is found, populate the fields with the book details
						bookIDField.setText(foundBook.getBookID());
						bookAuthorField.setText(foundBook.getAuthor());
						bookGenreField.setText(foundBook.getGenre());
						availabilityField.setText(foundBook.getAvailability());
					} else {
						// If the book is not found, display an error message
						JOptionPane.showMessageDialog(null, "Book not Found.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSearch.setBounds(598, 138, 103, 31);

		// Reset button is used to clear all text fields
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 64, 128));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnReset.setBounds(302, 433, 103, 31);
		contentPane.add(btnReset);

		// CLose button to dispose the window
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(0, 64, 128));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(454, 433, 103, 31);
		contentPane.add(btnClose);
		contentPane.add(btnSearch);
		/*************** BUTTONS *****************/

		/**************** BACKGROUND *************/
		JLabel background = new JLabel("");
		background.setIcon(
				new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		background.setBounds(0, 0, 786, 493);
		contentPane.add(background);
		/**************** BACKGROUND *************/
	}

	// Method to Clear all Fields
	public void clear() {
		bookTitleField.setText("");
		bookIDField.setText("");
		bookAuthorField.setText("");
		bookGenreField.setText("");
		availabilityField.setText("");
	}
}
