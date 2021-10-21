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

public class HomePageController {

    @FXML
    private Button joinGameBtn, hostGameBtn;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == joinGameBtn) {
            stage = (Stage) joinGameBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("JoinPageView.fxml"));
        } else if (event.getSource() == hostGameBtn) {
            stage = (Stage) hostGameBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("QuestionPage.fxml"));
        } else {
            stage = (Stage) joinGameBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Jeoparty.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
