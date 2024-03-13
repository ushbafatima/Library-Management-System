package libraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Library {

	static Connection con = Connect.ConnectToDB();
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public Library() {

	}

	/******************* ADD USER ******************/
	public static Boolean addUserToDB(User user) {
		try {
			// Prepare SQL statement to insert user details into the database
			pst = con.prepareStatement("INSERT INTO STUDENT (studentName,studentID,contact,course) VALUES (?,?,?,?)");

			// Set values for the parameters in the SQL statement using user details
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserID());
			pst.setString(3, user.getContactNo());
			pst.setString(4, user.getCourseName());

			// Execute the SQL statement to insert the user into the database
			pst.executeUpdate();

			// Return true to indicate successful addition of user to the database
			return true;

		} catch (SQLException e1) {
			e1.printStackTrace();
			// Return false to indicate unsuccessful addition of user to the database
			return false;
		}
	}

	/******************* ADD USER ******************/

	/******************* ADD BOOK ******************/
	public static Boolean addBookToDB(Book book) {
		try {
			// Prepare SQL statement to insert book details into the database
			pst = con.prepareStatement(
					"INSERT INTO BOOK (bookTitle,bookID,author,genre, availability) VALUES (?,?,?,?,?)");

			// Set values for the parameters in the SQL statement using book details
			pst.setString(1, book.getBookTitle());
			pst.setString(2, book.getBookID());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getGenre());
			pst.setString(5, book.getAvailability());

			// Execute the SQL statement to insert the book into the database
			pst.executeUpdate();

			// Return true to indicate successful addition of book to the database
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/******************* ADD BOOK ******************/

	/***************** FIND BOOK *******************/
	// Find Book by Title
	public static Book findBookbyTitle(String title) {
		// Create a new Book object
		Book book = new Book();

		try {
			// Prepare SQL statement to select book from database using book title
			pst = con.prepareStatement("SELECT * FROM BOOK WHERE bookTitle=?");
			pst.setString(1, title);
			rs = pst.executeQuery();

			// If a book with the specified title exists in the database
			if (rs.next()) {
				// Set the book details retrieved from the database
				book.setBookTitle(rs.getString("bookTitle"));
				book.setBookID(rs.getString("bookID"));
				book.setAuthor(rs.getString("author"));
				book.setGenre(rs.getString("genre"));
				book.setAvailability(rs.getString("availability"));
				book.setDueDate(rs.getString("dueDate"));
				book.setIssueDate(rs.getString("issueDate"));
			} else {
				// If no book with the specified title is found, return null
				return null;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		// Return the Book object with the retrieved details
		return book;
	}

	// Find book by name
	public static Book findBookbyID(String ID) {
		// Create a new Book object
		Book book = new Book();

		try {
			// Prepare SQL statement to select book from database using book ID
			pst = con.prepareStatement("SELECT * FROM BOOK WHERE bookID=?");
			pst.setString(1, ID);
			rs = pst.executeQuery();

			// If a book with the specified ID exists in the database
			if (rs.next()) {
				// Set the book details retrieved from the database
				book.setBookTitle(rs.getString("bookTitle"));
				book.setBookID(rs.getString("bookID"));
				book.setAuthor(rs.getString("author"));
				book.setGenre(rs.getString("genre"));
				book.setUserID(rs.getString("studentID")); // Assuming you have a method to set the user ID who borrowed
															// the book
				book.setAvailability(rs.getString("availability"));
				book.setDueDate(rs.getString("dueDate"));
				book.setIssueDate(rs.getString("issueDate"));
			} else {
				return null;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		// Return the Book object with the retrieved details
		return book;
	}
	/***************** FIND BOOK *******************/

	/************ FIND USER **************/
	public static User findUserbyID(String ID) {
		// Create a new User object
		User user = new User();

		try {
			// Prepare SQL statement to select user from database using user ID
			pst = con.prepareStatement("SELECT * FROM STUDENT WHERE studentID=?");
			pst.setString(1, ID);
			rs = pst.executeQuery();

			// If the user with the specified ID exists in the database
			if (rs.next()) {
				// Set the user details retrieved from the database
				user.setUserName(rs.getString("studentName"));
				user.setUserID(rs.getString("studentID"));
				user.setContactNo(rs.getString("contact"));
				user.setCourseName(rs.getString("course"));
			} else {
				// If no user with the specified ID is found, return null
				return null;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}

		// Return the User object with the retrieved details
		return user;
	}
	/************ FIND USER **************/

	/**************** ISSUE BOOK ******************/
	public static Boolean issueBook(Book book) {
		try {
			// Updates book details in the database based on the provided information that
			// has been populated in the object book
			pst = con.prepareStatement("UPDATE BOOK SET ISSUEDATE=?,DUEDATE=?,STUDENTID=? WHERE BOOKID=?");
			pst.setString(1, book.getIssueDate());
			pst.setString(2, book.getDueDate());
			pst.setString(3, book.getUserID());
			pst.setString(4, book.getBookID());

			int rowsAffected = pst.executeUpdate(); // Use executeUpdate() for UPDATE queries
			// If update was successful
			if (rowsAffected > 0) {
				book.setAvailability("Not Available");

				// Update the availability of the book
				pst = con.prepareStatement("UPDATE BOOK SET AVAILABILITY=? WHERE BOOKID=?");
				pst.setString(1, "Not Available");
				pst.setString(2, book.getBookID());
				pst.executeUpdate(); // Execute the update query for availability

				// Update the book object's availability
				book.setAvailability("Not Available");

				return true; // Indicate that the book was successfully issued

			} else
				// Book could not be issued
				return false;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block\

			e1.printStackTrace();
			return null;
		}
	}
	/**************** ISSUE BOOK ******************/

	/**************** RETURN BOOK ******************/
	public static Boolean returnBook(Book book) {
		// Get the book ID
		String bookID = book.getBookID();

		try {
			// Prepare SQL statement to select book from database using book ID
			pst = con.prepareStatement("SELECT * FROM BOOK WHERE bookID=?");
			pst.setString(1, bookID);
			rs = pst.executeQuery();

			// If the book exists in the database
			if (rs.next()) {
				// Find the book by its ID
				book = findBookbyID(book.getBookID());

				// Prepare SQL statement to update book details in the database
				pst = con.prepareStatement(
						"UPDATE BOOK SET AVAILABILITY=?, ISSUEDATE=?, DUEDATE=?,STUDENTID=? WHERE BOOKID=?");
				pst.setString(1, "Available");
				pst.setString(2, null);
				pst.setString(3, null);
				pst.setString(4, null);
				pst.setString(5, bookID);

				// Execute the update query and get the number of rows affected
				int rowsAffected = pst.executeUpdate(); // Use executeUpdate() for UPDATE queries

				// If the update was successful
				if (rowsAffected > 0) {
					// Update the book object's availability
					book.setAvailability("Available");
					// Return true to indicate successful book return
					return true;
				} else
					// Return false to indicate unsuccessful book return
					return false;

			}

		} catch (SQLException e1) {

			// Return false to indicate unsuccessful book return
			e1.printStackTrace();
			return false;
		}

		return null;

	}
	/**************** RETURN BOOK ******************/

	// Validate ID Value
	public static Boolean isValidID(String ID) {
		try {
			int idValue = Integer.parseInt(ID);
			// Check if ID is a positive number
			if (idValue <= 0) {

				return false; // Return false method if validation fails
			}
		} catch (NumberFormatException ex) {
			// Handle invalid ID format

			return false; // Return false if validation fails
		}
		return true;

	}

}
