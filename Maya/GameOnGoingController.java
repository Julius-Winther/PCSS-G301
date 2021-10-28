package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class GameOnGoingController {

    public void changeQuestionText(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameOnGoing.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        Category1Controller controller = loader.getController();
        controller.initData(AnchorPane.getSelectedItem());

        //This line gets the Stage information
        Stage window = (Stage) cat1_100.getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


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
            textScore1.setText("" + intValue1);

        } else if (event.getSource() == btnRemovePoint1) {
            intValue1 -= 100;
            textScore1.setText("" + intValue1);
        }

        //Team 2
        else if (event.getSource() == btnAddPoint2) {
            intValue2 += 100;
            textScore2.setText("" + intValue2);
        } else if (event.getSource() == btnRemovePoint2) {
            intValue2 -= 100;
            textScore2.setText("" + intValue2);
        }

        //Team 3
        else if (event.getSource() == btnAddPoint3) {
            intValue3 += 100;
            textScore3.setText("" + intValue3);
        } else if (event.getSource() == btnRemovePoint3) {
            intValue3 -= 100;
            textScore3.setText("" + intValue3);
        }
    }


    @FXML
    private void questionButtonAction(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        //Category1
        if (event.getSource() == cat1_100) {
            stage = (Stage) cat1_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category1.fxml")));

        } else if (event.getSource() == cat1_200) {
            stage = (Stage) cat1_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category1.fxml")));

        } else if (event.getSource() == cat1_300) {
            stage = (Stage) cat1_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category1.fxml")));

        } else if (event.getSource() == cat1_400) {
            stage = (Stage) cat1_400.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category1.fxml")));

        } else if (event.getSource() == cat1_500) {
            stage = (Stage) cat1_500.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category1.fxml")));

            //Category2
        } else if (event.getSource() == cat2_100) {
            stage = (Stage) cat2_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));

        } else if (event.getSource() == cat2_200) {
            stage = (Stage) cat2_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));

        } else if (event.getSource() == cat2_300) {
            stage = (Stage) cat2_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));

        } else if (event.getSource() == cat2_400) {
            stage = (Stage) cat2_400.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));

        } else if (event.getSource() == cat2_500) {
            stage = (Stage) cat2_500.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category2.fxml")));

            //Category3
        } else if (event.getSource() == cat3_100) {
            stage = (Stage) cat3_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category3.fxml")));

        } else if (event.getSource() == cat3_200) {
            stage = (Stage) cat3_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category3.fxml")));

        } else if (event.getSource() == cat3_300) {
            stage = (Stage) cat3_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category3.fxml")));

        } else if (event.getSource() == cat3_400) {
            stage = (Stage) cat3_400.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category3.fxml")));

        } else if (event.getSource() == cat3_500) {
            stage = (Stage) cat3_500.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category3.fxml")));

            //Category4
        } else if (event.getSource() == cat4_100) {
            stage = (Stage) cat4_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category4.fxml")));

        } else if (event.getSource() == cat4_200) {
            stage = (Stage) cat4_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category4.fxml")));

        } else if (event.getSource() == cat4_300) {
            stage = (Stage) cat4_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category4.fxml")));

        } else if (event.getSource() == cat4_400) {
            stage = (Stage) cat4_400.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category4.fxml")));

        } else if (event.getSource() == cat4_500) {
            stage = (Stage) cat4_500.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category4.fxml")));

            //Category5
        } else if (event.getSource() == cat5_100) {
            stage = (Stage) cat5_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category5.fxml")));

        } else if (event.getSource() == cat5_200) {
            stage = (Stage) cat5_200.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category5.fxml")));

        } else if (event.getSource() == cat5_300) {
            stage = (Stage) cat5_300.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category5.fxml")));

        } else if (event.getSource() == cat5_400) {
            stage = (Stage) cat5_400.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category5.fxml")));

        } else if (event.getSource() == cat5_500) {
            stage = (Stage) cat5_500.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Category5.fxml")));


        } else {
            stage = (Stage) cat1_100.getScene().getWindow();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameOnGoing.fxml")));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


