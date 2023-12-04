package com.example.gotravel;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Signupcontroller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    TextField nametext;
    @FXML
    TextField emailtext;
    @FXML
    TextField usernametext;
    @FXML
    PasswordField passtext;

    public void signupbuttonclick(ActionEvent e){

        User u = new User(nametext.getText().toString(),emailtext.getText().toString(),
                usernametext.getText().toString(),passtext.getText().toString());
        try {
            FileOutputStream fout = new FileOutputStream("User.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(u);
            out.flush();
            out.close();
            fout.close();
        } catch (IOException ex) {
            System.out.println("File Exception");
            throw new RuntimeException(ex);

        }

        infoBox("Sign Up Successful!", null, "Success");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Firstpage.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        firstpagecontroller firstController = loader.getController();
        firstController.displayName(nametext.getText().toString());

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

