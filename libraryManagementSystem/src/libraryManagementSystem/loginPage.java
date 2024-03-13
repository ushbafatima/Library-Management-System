package libraryManagementSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class loginPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    /*************************** MAIN METHOD *****************************/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginPage frame = new loginPage();
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
    public loginPage() {
    	
    	// GUI SETUP
    	setResizable(false);
    	setTitle("LMS");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\book.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 500, 300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        /******************* LABELS **********************/
        JLabel txtLogin = new JLabel("L M S");
        txtLogin.setForeground(new Color(19, 79, 151));
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtLogin.setBounds(174, 10, 144, 31);
        contentPane.add(txtLogin);
        
        JLabel txtUsername = new JLabel("Username:");
        txtUsername.setForeground(new Color(19, 79, 151));
        txtUsername.setFont(new Font("Calibri", Font.BOLD, 19));
        txtUsername.setBounds(49, 100, 116, 31);
        contentPane.add(txtUsername);
        
        JLabel txtPassword = new JLabel("Password:");
        txtPassword.setForeground(new Color(19, 79, 151));
        txtPassword.setFont(new Font("Calibri", Font.BOLD, 19));
        txtPassword.setBounds(49, 146, 105, 28);
        contentPane.add(txtPassword);
        
        JLabel title = new JLabel("Library Management System");
        title.setForeground(new Color(19, 79, 151));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
        title.setBounds(113, 41, 256, 32);
        contentPane.add(title);
        /******************* LABELS **********************/
        
        
        /*************** TEXT/PASSWORD FIELDS ******************/
        usernameField = new JTextField();
        usernameField.setBounds(175, 99, 229, 31);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        
        
        passwordField = new JPasswordField();
        passwordField.setBounds(175, 144, 229, 31);
        contentPane.add(passwordField);
        /*************** TEXT/PASSWORD FIELDS ******************/
        
        /********************* BUTTONS *************************/
        // Close Button        
        JButton closeButton = new JButton("Close");
        closeButton.setForeground(new Color(0, 64, 128));
        closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        closeButton.setBounds(295, 194, 110, 25);
        // Program Execution terminates on close button
        closeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(ABORT);
        	}
        });
        contentPane.add(closeButton);
        
        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\login.png"));
        loginButton.setForeground(new Color(0, 64, 128));
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        loginButton.setBounds(175, 194, 110, 25);
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    // Get the entered username and password
        	    String username = usernameField.getText();
        	    char[] passwordChars = passwordField.getPassword();
        	    String password = new String(passwordChars);

        	    // Perform authentication or validation here
        	    // Check if the entered username and password match any of the predefined credentials
        	    if (username.equals("Admin1") && password.equals("library123") ||
        	        username.equals("Admin2") && password.equals("library456") ||
        	        username.equals("Admin3") && password.equals("library789")) {
        	        
        	        // If the credentials match, open the home page
        	        setVisible(false);
        	        new homePage().setVisible(true);
        	    } else {
        	        // If the credentials don't match, display an error message
        	        JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        	    }
        	}
        });
        contentPane.add(loginButton);
        
        /********************* BUTTONS *************************/
        
        
        
        /****************** BACKGROUND IMAGE ********************/
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\book.png"));
        lblNewLabel.setBounds(164, -21, 70, 87);
        contentPane.add(lblNewLabel);
        
        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\R (1).jpg"));
        background.setBounds(-13, -18, 522, 302);
        contentPane.add(background);
        /****************** BACKGROUND IMAGE ********************/
    }
}
