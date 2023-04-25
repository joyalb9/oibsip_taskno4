import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            stmt = conn.createStatement();
            
            // Login as admin or user
            System.out.println("Welcome to the Library Management System!");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Admin login
    private static void adminLogin() {
        try {
            System.out.print("Enter admin username: ");
            String username = sc.next();
            System.out.print("Enter admin password: ");
            String password = sc.next();
            
            // Authenticate the admin
            rs = stmt.executeQuery("SELECT * FROM admins WHERE username = '" + username + "' AND password = '" + password + "'");
            if (rs.next()) {
                System.out.println("Admin login successful!");
                adminMenu();
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // User login
    private static void userLogin() {
        try {
            System.out.print("Enter user ID: ");
            int userId = sc.nextInt();
            System.out.print("Enter password: ");
            String password = sc.next();
            
            // Authenticate the user
            rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + userId + " AND password = '" + password + "'");
            if (rs.next()) {
                System.out.println("User login successful!");
                userMenu(userId);
            } else {
                System.out.println("Invalid user ID or password. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Admin menu
    private static void adminMenu() {
        while (true) {
            System.out.println("ADMIN MENU");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Add user");
            System.out.println("4. Remove user");
            System.out.println("5. View all books");
            System.out.println("6. View all users");
            System.out.println("7. Logout");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    viewAllBooks();
                    break;
                case 6:
                    viewAllUsers();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
