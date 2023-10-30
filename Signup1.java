package go_explore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Signup1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Signup Form");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Label unameLabel = new Label("User Name:");
        GridPane.setConstraints(unameLabel, 0, 0);

        TextField unameField = new TextField();
        unameField.setPromptText("Enter your username");
        GridPane.setConstraints(unameField, 1, 0);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        GridPane.setConstraints(nameField, 1, 1);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);

        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter your password");
        GridPane.setConstraints(passField, 1, 2);

        Label securityLabel = new Label("Security Check");
        HBox hBox = new HBox();
        hBox.getChildren().add(securityLabel);
        hBox.setPadding(new Insets(10, 0, 0, 0));
        GridPane.setConstraints(hBox, 1, 3);

        gridPane.getChildren().addAll(unameLabel, unameField, nameLabel, nameField, passLabel, passField, hBox);

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
