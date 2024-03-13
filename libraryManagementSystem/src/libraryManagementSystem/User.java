package libraryManagementSystem;

// Class representing a User object
public class User {
    // User Attributes
    private String userID;
    private String name;
    private String contactNo;
    private String courseName;
     
    // Constructor
    public User() {
    	
    }

    // Getter methods to retrieve the values of private fields

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getCourseName() {
        return courseName;
    }


    // Setter methods to modify the values of private fields

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
