package com.example.gotravel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Go_Explore Login!!");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
