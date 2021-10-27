package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class HomePageController {

    @FXML
    private Button joinGameBtn, hostGameBtn;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == joinGameBtn) {
            stage = (Stage) joinGameBtn.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("JoinPageView.fxml")));
        } else if (event.getSource() == hostGameBtn) {
            stage = (Stage) hostGameBtn.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));
        } else {
            stage = (Stage) joinGameBtn.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Jeoparty.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
