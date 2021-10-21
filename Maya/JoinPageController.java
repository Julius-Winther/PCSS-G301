package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class JoinPageController {
    @FXML
    private TextField joinCode;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == joinCode) {
            stage = (Stage) joinCode.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("GameOnGoing.fxml"));
        } else {
            stage = (Stage) joinCode.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Jeoparty.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}