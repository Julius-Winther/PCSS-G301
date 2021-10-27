package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;


public class Category5Controller {

    @FXML
    private Button backButton;

    @FXML
    private void backButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == backButton) {
            stage = (Stage) backButton.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameOnGoing.fxml")));
        } else {
            stage = (Stage) backButton.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}