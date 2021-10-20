package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btn1,btn2;

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==btn1){
            stage = (Stage) btn1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("secondPage.fxml"));
        }
        else{
            stage = (Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Jeoparty.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}




