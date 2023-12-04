package com.example.gotravel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class firstpagecontroller {

    @FXML
    Label nameLabel;

    public void displayName(String name){
        nameLabel.setText("Hello "+ name);
    }
}
