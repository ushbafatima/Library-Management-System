package libraryManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class homePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*************************** MAIN METHOD *****************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*************************** MAIN METHOD *****************************/

	/**
	 * Create the frame.
	 */
	public homePage() {
		// GUI SETUP
		setTitle("LMS");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		int width = 1100;
		int height = 700;

		int x = (screenWidth - width) / 2;
		int y = (screenHeight - height) / 2;

		setBounds(1, 1, screenWidth, screenHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/********************* BUTTONS *************************/
		
		// Each button opens corresponding window when pressed
		JButton addUserButton = new JButton("Add User");
		addUserButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\adduser.png"));
		addUserButton.setForeground(new Color(0, 64, 128));
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addUserWindow().setVisible(true);
			}
		});
		addUserButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addUserButton.setBounds(95, 48, 146, 40);
		contentPane.add(addUserButton);

		JButton searchBookButton = new JButton("Search Book");
		searchBookButton.setForeground(new Color(0, 64, 128));
		searchBookButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\datamining.png"));
		searchBookButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new searchBookWindow().setVisible(true);
			}
		});
		searchBookButton.setBounds(575, 48, 154, 40);
		contentPane.add(searchBookButton);

		JButton addBookButton = new JButton("Add Book");
		addBookButton.setForeground(new Color(0, 64, 128));
		addBookButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\addbook.png"));
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addBookWindow().setVisible(true);
			}
		});
		addBookButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addBookButton.setBounds(338, 48, 146, 40);
		contentPane.add(addBookButton);

		JButton displayBooksButton = new JButton("Display Books");
		displayBooksButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\display.png"));
		displayBooksButton.setForeground(new Color(0, 64, 128));
		displayBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new displayBooksWindow().setVisible(true);
			}
		});
		displayBooksButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		displayBooksButton.setBounds(808, 48, 165, 40);
		contentPane.add(displayBooksButton);

		JButton issueBookButton = new JButton("Issue Book");
		issueBookButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\issuebook.png"));
		issueBookButton.setForeground(new Color(0, 64, 128));
		issueBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new issueBookWindow().setVisible(true);
			}
		});
		issueBookButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		issueBookButton.setBounds(1057, 48, 146, 40);
		contentPane.add(issueBookButton);

		JButton returnBookButton = new JButton("Return Book");
		returnBookButton.setForeground(new Color(0, 64, 128));
		returnBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new returnBookWindow().setVisible(true);
			}
		});
		returnBookButton
				.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\return.png"));
		returnBookButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnBookButton.setBounds(1293, 48, 154, 40);
		contentPane.add(returnBookButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setForeground(new Color(0, 64, 128));
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutButton.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\logout.png"));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new loginPage().setVisible(true);
			}
		});
		logoutButton.setBounds(1322, 696, 146, 40);
		contentPane.add(logoutButton);
		/********************* BUTTONS *************************/

		/******************* BACKGROUND ***********************/
		JLabel lblTItle = new JLabel("L M S");
		lblTItle.setForeground(new Color(0, 64, 128));
		lblTItle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTItle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTItle.setBounds(492, 210, 574, 90);
		contentPane.add(lblTItle);

		JLabel bookimg = new JLabel("");
		bookimg.setHorizontalAlignment(SwingConstants.CENTER);
		bookimg.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\LMSbook.png"));
		bookimg.setBounds(703, 114, 146, 110);
		contentPane.add(bookimg);

		JLabel lblTitle1 = new JLabel("Library Management System");
		lblTitle1.setForeground(new Color(0, 64, 128));
		lblTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblTitle1.setBounds(510, 296, 546, 46);
		contentPane.add(lblTitle1);

		JLabel lblQuote = new JLabel("There's no friend as loyal as a book!");
		lblQuote.setForeground(SystemColor.inactiveCaption);
		lblQuote.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblQuote.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuote.setBounds(510, 696, 555, 40);
		contentPane.add(lblQuote);

		JLabel background = new JLabel("");
		background.setIcon(
				new ImageIcon("C:\\Users\\Dell\\Desktop\\Library Management System\\Images\\bluebackground.jpg"));
		background.setBounds(0, 10, 1565, 893);
		contentPane.add(background);
	}
}
