package com.example.go_explore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the registration screen (registration.fxml) when the application starts
        Parent registrationRoot = FXMLLoader.load(getClass().getResource("registration.fxml"));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(registrationRoot));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
