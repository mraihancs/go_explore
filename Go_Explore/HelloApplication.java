package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Go Explore - Corporate Travel Login");

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label titleLabel = new Label("Welcome to Go Explore - Corporate Travel Portal");
        titleLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(titleLabel, 2);
        grid.add(titleLabel, 0, 0);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 3);

        final Label loginStatus = new Label();
        // loginStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        loginStatus.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(loginStatus, 2);
        grid.add(loginStatus, 0, 4);

        GridPane.setHalignment(loginButton, javafx.geometry.HPos.CENTER);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (authenticate(username, password)) {
                loginStatus.setText("Successfully logged in!");

                primaryStage.close();
            } else {
                loginStatus.setText("Login failed. Please try again.");
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private boolean authenticate(String username, String password) {
        return username.equals("goexplore") && password.equals("12345678");
    }
}