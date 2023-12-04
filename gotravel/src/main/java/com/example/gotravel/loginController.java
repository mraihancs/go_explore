package com.example.gotravel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {


    @FXML
    private Button signupbtn;


    private Stage stage;
    private Scene scene;
    private Parent root;

    private String admin = "admin";
    private String adminpass="admin";

    @FXML
    TextField nameText;
    @FXML
    PasswordField passText;

    public void loginbuttonclick(ActionEvent e) throws IOException {
        String username = nameText.getText();
        String password = passText.getText();

        if(nameText.getText().isEmpty()) {
            showAlert(
                    "Please enter your email id");
            return;
        }
        if(passText.getText().isEmpty()) {
            showAlert(
                    "Please enter a password");
            return;
        }

        if(admin.equals(username.toString()) && adminpass.equals(password.toString())){
            infoBox("Login Successful!", null, "Success");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
            root = loader.load();

            Scene2Controller scene2Controller = loader.getController();
            scene2Controller.displayName(username);

            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            infoBox("Please enter correct Email and Password", null, "Failed");
        }


    }
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Form Error!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}



