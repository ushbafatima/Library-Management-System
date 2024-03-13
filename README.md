### LIBRARY MANAGEMENT SYSTEM ###

### Introduction
The Library Management System is a Java application developed for librarians' use. It provides a graphical user interface (GUI) for managing student and book records in a library. The application is integrated with a MySQL database to store student and book information. Users can perform various tasks such as adding students, adding books, searching books, displaying books, issuing books, and returning books. To access the system, users must log in as administrators.

### Prerequisites
  - Eclipse IDE with Windows Builder plugin
  - MySQL for Windows
  - MySQL Connector/J 8.3.0
  - rs2xml.jar file for filling JTables

### Features
  - **Add Student**:
    Allows administrators to add new students to the database by entering their details such as name, ID, contact number, and course.
  - **Add Book**:
    Enables administrators to add new books to the library by specifying book details including title, author, genre, availability, issue date, and due date.
  - **Search Books:**
    Provides functionality to search for books in the database based on criteria such as book title, author, or genre.
  - **Display Books:**
    Allows administrators to view all the books available in the library along with their details.
  - **Issue Books:**
    Enables librarians to issue books to students by selecting a book from the available list and assigning it to a student.
  - **Return Books:**
    Allows students to return borrowed books by entering the book ID.

### Setup Instructions
  - Clone the project repository from GitHub.
  - Import the project into Eclipse IDE.
  - Ensure that Windows Builder plugin is installed in Eclipse.
  - Set up the MySQL database and configure the database connection in the application.
  - Ensure the JDBC connection is properly configured.
  - Add the rs2xml.jar file to the project build path for filling JTables.
  - Build and run the application in Eclipse.
  - Use the GUI interface to perform various library management tasks.

### Usage
  - Launch the application.
  - Log in as an administrator using the provided credentials.
  - Use the options in the GUI to perform tasks such as adding students, adding books, searching books, displaying books, issuing books, and returning books.
  - Follow the on-screen instructions to enter relevant information and execute tasks.
  - Ensure proper connectivity to the MySQL database for seamless operation.

### Credentials For Login
  - Admin 1
    Username: Admin1
    Password: library123
  - Admin 2
    Username: Admin2
    Password: library456
  - Admin 3
    Username: Admin3
    Password: library789

### Developer
  - Ushba Fatima

