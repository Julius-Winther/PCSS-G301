package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameOnGoingController {
    @FXML
    private Button backButtonJeoparty, btn2;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == backButtonJeoparty) {
            stage = (Stage) backButtonJeoparty.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Jeoparty.fxml"));
        } else {
            stage = (Stage) backButtonJeoparty.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("GameOnGoing.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
