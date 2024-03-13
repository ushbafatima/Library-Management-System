package libraryManagementSystem;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class displayBooksWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Establish connection with database
	Connection con = Connect.ConnectToDB();
	PreparedStatement pst=null;
	ResultSet rs=null;
	private JTable table_book;
	private JScrollPane scrollPane;
	
		
	/**
	 * Launch the application.
	 */
	
	/***************  MAIN METHOD *****************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayBooksWindow frame = new displayBooksWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/***************  MAIN METHOD *****************/

	// Function to update the table by taking information from the database book
	private void UpdateTable() {
	    try {
	        // Prepare the SQL query to select data from the book table
	        pst = con.prepareStatement("SELECT bookTitle, bookID, author, genre, availability FROM book");
	        
	        // Execute the query and retrieve the ResultSet
	        rs = pst.executeQuery();
	        
	        // Update the table_book JTable with the fetched data
	        table_book.setModel(DbUtils.resultSetToTableModel(rs));
	        
	    } catch (SQLException e) {
	        // Handle SQLException
	        JOptionPane.showMessageDialog(rootPane, "", "", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}


	/**
	 * Create the frame.
	 */
	public displayBooksWindow() {
		
		// GUI SETUP		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\display.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 150, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/***************** LABELS ****************/
		JLabel lblTitle = new JLabel("    DISPLAY BOOKS");
		lblTitle.setForeground(new Color(0, 64, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\displaybook1.png"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(243, 39, 284, 71);
		contentPane.add(lblTitle);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookTitle.setBounds(107, 125, 68, 13);
		contentPane.add(lblBookTitle);
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBookID.setBounds(230, 125, 63, 13);
		contentPane.add(lblBookID);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAuthor.setBounds(369, 125, 62, 13);
		contentPane.add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenre.setBounds(493, 125, 68, 13);
		contentPane.add(lblGenre);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailability.setBounds(598, 125, 76, 13);
		contentPane.add(lblAvailability);
		/***************** LABELS ****************/
		
		//SCROLL PANE
		scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 148, 628, 221);
		contentPane.add(scrollPane);
		
		/****************** TABLE *******************/		
		table_book = new JTable();
		scrollPane.setColumnHeaderView(table_book);
		table_book.setModel(new DefaultTableModel(
			new Object[][] {
				{"Java- How to Program", "1", "Paul & Dietel", "Education", "Available"},
				{"Harry Potter", "2", "JK Rowling", "Fantasy", "Available"},
				{"The Hunger Games", "3", "Suzanne Collins", "Fiction", "Available"},
				{"Pride and Prejudice", "5", "Jane Austen", "Romance", "Available"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"bookTitle", "bookID", "author", "genre", "availability"
			}
		));
		table_book.getColumnModel().getColumn(0).setPreferredWidth(125);
		table_book.getColumnModel().getColumn(1).setPreferredWidth(55);
		table_book.getColumnModel().getColumn(2).setPreferredWidth(100);
		/****************** TABLE *******************/
		
		
		/**************** BACKGROUND *****************/
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\windowbackground.jpg"));
		lblBackground.setBounds(0, 0, 786, 512);
		contentPane.add(lblBackground);
		/**************** BACKGROUND *****************/
		
		// Call the update table method to fill the rows of the table
		UpdateTable();
		
	}
}
