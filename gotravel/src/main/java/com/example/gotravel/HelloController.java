package com.example.gotravel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField usertxt;
    @FXML
    PasswordField passwordtext;

    public void loginbuttonclick(ActionEvent e){
        String checkuser = usertxt.getText().toString();
        String checkpass = passwordtext.getText().toString();

        try {
            FileInputStream fin = new FileInputStream("User.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            int i;
            while(fin.available()>0){
                User u1 = (User) in.readObject();
                System.out.println(u1.name+" "+u1.email+" "+u1.username+" "+u1.password);
                if(u1.username.equals(checkuser) && u1.password.equals(checkpass)){
                    infoBox("Login Successful!", null, "Success");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Firstpage.fxml"));
                    root = loader.load();

                    firstpagecontroller firstController = loader.getController();
                    firstController.displayName(u1.name);

                    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    infoBox("Please enter correct Email and Password", null, "Failed");
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void signupbuttonclick(ActionEvent e){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
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