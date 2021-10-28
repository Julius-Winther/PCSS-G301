//This is the package for the project, please keep using this.
package frontendminiproject.frontendminiprojectdina;

//Imports.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

//____________________________________________________________________________________-
// Main class.

public class Main extends Application {

    //All buttons or other elements are defined here.
    @FXML
    private Button joinButton, hostButton;


    //This is the main start function.
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader homePage = new FXMLLoader(Main.class.getResource("HomePage.fxml"));

        Scene homeScene = new Scene(homePage.load(), 1080, 600);

        stage.setScene(homeScene);
        stage.show();
    }


    //
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) joinButton.getScene().getWindow();

        if (event.getSource() == joinButton)
        {
            FXMLLoader joinPage = new FXMLLoader(Main.class.getResource("JoinPage.fxml"));
            Scene joinScene = new Scene(joinPage.load(), 1080, 600);
            stage.setScene(joinScene);
            stage.show();
        }

    }


    public static void main(String[] args)
    {
        launch();
    }
}