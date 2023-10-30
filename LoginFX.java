package go_explore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Label lbluname = new Label("User Name:");
        GridPane.setConstraints(lbluname, 0, 0);

        TextField tuname = new TextField();
        tuname.setPromptText("Enter your username");
        GridPane.setConstraints(tuname, 0, 1);

        Label lblpassword = new Label("Password:");
        GridPane.setConstraints(lblpassword, 0, 2);

        PasswordField tupassword = new PasswordField();
        tupassword.setPromptText("Enter your password");
        GridPane.setConstraints(tupassword, 0, 3);

        Button login = new Button("Login");
        login.setStyle("-fx-background-color: #9EE7F5; -fx-text-fill: white;");
        login.setOnAction(e -> {
            // Action for login
        });
        GridPane.setConstraints(login, 0, 4);

        Button signup = new Button("Sign up");
        signup.setStyle("-fx-background-color: #9EE7F5; -fx-text-fill: white;");
        signup.setOnAction(e -> {
            // Action for signup
        });
        GridPane.setConstraints(signup, 1, 4);

        Button fpassword = new Button("Forget Password");
        fpassword.setStyle("-fx-background-color: #9EE7F5; -fx-text-fill: white;");
        fpassword.setOnAction(e -> {
            // Action for forget password
        });
        GridPane.setConstraints(fpassword, 0, 5);

        Label trouble = new Label("Trouble logging in...");
        GridPane.setConstraints(trouble, 1, 5);

        Image image = new Image(getClass().getResourceAsStream("/Icon/login.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(lbluname, tuname, lblpassword, tupassword, login, signup, fpassword, trouble);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(imageView, vbox);

        Scene scene = new Scene(new VBox(hbox), 800, 400);
        scene.setFill(Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
