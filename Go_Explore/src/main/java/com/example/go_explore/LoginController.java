package com.example.go_explore;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void loginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isLoginValid(username, password)) {
            // Successful login; navigate to the next screen
            System.out.println("Login Successfully");
        } else {
            // Show an error message
            System.out.println("Error Occurs");
        }
    }

    private boolean isLoginValid(String username, String password) {
        return false;
    }

    private boolean isRegistrationValid(String newUsername, String newPassword) {
        // Check if the newUsername and newPassword meet your criteria
        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return false;
        }

        List<User> existingUsers = UserFileManager.readUsers();
        for (User user : existingUsers) {
            if (user.getUsername().equals(newUsername)) {
                System.out.println("Username already in use. Please choose another.");
                return false;
            }
        }

        // Add password complexity requirements
        if (newPassword.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // You can add more complexity requirements here, such as requiring a mix of letters, numbers, and special characters.

        // If all checks pass, registration is considered valid
        return true;
    }


//    private boolean isLoginValid(String username, String password) {
//        // Implement your authentication logic here
//        // Check if the username and password match a record in the database
//        return false; // Change this to return true for a valid login
//    }
}
