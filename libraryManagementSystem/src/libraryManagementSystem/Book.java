package libraryManagementSystem;

// Class representing a Book object
class Book {
    // Private fields to store book attributes
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String available;
    private String issueDate;
    private String dueDate;
    private String userID;

    // Default constructor
    public Book() {
    }

    // Getter methods to retrieve the values of private fields

    public String getBookID() {
        return bookID;
    }

    public String getBookTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getUserID() {
        return userID;
    }

    public String getAvailability() {
        return available;
    }

    // Setter methods to modify the values of private fields

    public void setAvailability(String available) {
        this.available = available;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
