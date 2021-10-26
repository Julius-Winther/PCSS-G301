package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class GameOnGoingController {

    public Text catagory1;
    public Text catagory2;
    public Text catagory3;
    public Text catagory4;
    public Text catagory5;

    public Text text_team1;
    public Text text_team2;
    public Text text_team3;

    public Button cat5_100;
    public Button cat5_200;
    public Button cat5_300;
    public Button cat5_400;
    public Button cat5_500;

    public Button cat4_100;
    public Button cat4_200;
    public Button cat4_300;
    public Button cat4_400;
    public Button cat4_500;

    public Button cat3_100;
    public Button cat3_200;
    public Button cat3_300;
    public Button cat3_400;
    public Button cat3_500;

    public Button cat2_100;
    public Button cat2_200;
    public Button cat2_300;
    public Button cat2_400;
    public Button cat2_500;

    public Button cat1_100;
    public Button cat1_200;
    public Button cat1_300;
    public Button cat1_400;
    public Button cat1_500;


    @FXML
    private Button backButtonJeoparty;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == backButtonJeoparty) {
            stage = (Stage) backButtonJeoparty.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Jeoparty.fxml")));
        } else {
            stage = (Stage) backButtonJeoparty.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameOnGoing.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private Button btnAddPoint1, btnAddPoint2, btnAddPoint3;
    @FXML
    private Button btnRemovePoint1, btnRemovePoint2, btnRemovePoint3;

    @FXML
    private Text textScore1, textScore2, textScore3;
    public int intValue1 = 0;
    public int intValue2 = 0;
    public int intValue3 = 0;

    public void pointButtonAction(ActionEvent event) {
        //Team 1
        if (event.getSource() == btnAddPoint1) {
            intValue1 += 100;
            textScore1.setText("" +intValue1);

        } else if (event.getSource() == btnRemovePoint1) {
            intValue1 -= 100;
            textScore1.setText("" +intValue1);
        }

        //Team 2
        else if (event.getSource() == btnAddPoint2) {
            intValue2 += 100;
            textScore2.setText("" +intValue2);
        } else if (event.getSource() == btnRemovePoint2) {
            intValue2 -= 100;
            textScore2.setText("" +intValue2);
        }

        //Team 3
        else if (event.getSource() == btnAddPoint3) {
            intValue3 += 100;
            textScore3.setText("" +intValue3);
        } else if (event.getSource() == btnRemovePoint3) {
            intValue3 -= 100;
            textScore3.setText("" +intValue3);
        }
    }




    @FXML
    private void questionButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == cat1_100) {
            stage = (Stage) cat1_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QuestionPage.fxml")));

        } else if (event.getSource() == cat1_200) {
            stage = (Stage) cat1_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QuestionPage.fxml")));

        } else if (event.getSource() == cat1_300) {
            stage = (Stage) cat1_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QuestionPage.fxml")));
        } else {
            stage = (Stage) cat1_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameOnGoing.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


