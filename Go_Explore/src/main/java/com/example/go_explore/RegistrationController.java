package com.example.go_explore;

import com.example.go_explore.User;
import com.example.go_explore.UserFileManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class RegistrationController {
    @FXML
    private TextField newUsernameField;

    @FXML
    private PasswordField newPasswordField;
    public void registerAction() {
        String newUsername = newUsernameField.getText();
        String newPassword = newPasswordField.getText();

        // Perform registration validation
        if (isRegistrationValid(newUsername, newPassword)) {
            User newUser = new User(newUsername, newPassword);
            UserFileManager.saveUser(newUser);
            System.out.println("Registration Successfully");
        } else {
            System.out.println("Registration Failed. Please check your input.");
        }
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

        if (newPassword.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Add more validation criteria here, such as password complexity requirements.

        // If all checks pass, registration is considered valid
        return true;
    }

    // You can add more validation logic here, such as password complexity requirements

        // If all checks pass, registration is considered valid

    }


//    public void registerAction() {
//        String newUsername = newUsernameField.getText();
//        String newPassword = newPasswordField.getText();
//
//        User newUser = new User(newUsername, newPassword);
//
//        UserFileManager.saveUser(newUser);
//
//        // Add logic for registration validation here
//
//        System.out.println("Registration Successfully");
//    }
