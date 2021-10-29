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

    Jeoparty jeoparty = new Jeoparty(); //custom class, representing the application instance

    Scanner scanner = new Scanner(System.in);  //handles input

    boolean hasJoinedHost = false;  //whether this client has joined the server or not

     while(true)

    {
        //> if this client has joined,
        if (hasJoinedHost) {
            System.out.println("Give me name"); //prompt to provide name
            String userInput = scanner.next();

            if (!userInput.equals("")) { //only if the user sents something that is NOT blank space, the following
                // lines will be executed
                jeoparty.sendMessage(userInput);    //the name is sent to the server
                System.out.println(jeoparty.getMessage());
            }
        }
        //> if this client has not joined
        else {
            //> prompt and input
            System.out.println("Write start to join the server");
            String userInput = scanner.next();

            //> if the user writes "start"
            if (userInput.equals("start")) {
                System.out.println("Write IP-Address: ");   //prompt to provide IP-address
                String hostInput = scanner.next();
                System.out.println("Write Port: "); //prompt to provide port
                String portInput = scanner.next();
                jeoparty.joinServer(hostInput, Integer.parseInt(portInput));    //joins server, using the jeoparty
                // class' function .joinServer()
                hasJoinedHost = true;   //now the client has joined, and the relevant boolean is set to true
            }
        }
    }


    //All buttons or other elements are defined here.
    @FXML
    private Button joinButton, PBPlus1, PBPlus2, PBPlus3, PBMinus1, PBMinus2, PBMinus3;


    //This is the main start function.
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader homePage = new FXMLLoader(Main.class.getResource("HomePage.fxml"));

        Scene homeScene = new Scene(homePage.load(), 1080, 600);

        stage.setTitle("Jeoparty");
        stage.setScene(homeScene);
        stage.show();
    }


    //
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        Stage stage = (Stage) joinButton.getScene().getWindow();

        if (event.getSource() == joinButton) {
            FXMLLoader joinPage = new FXMLLoader(Main.class.getResource("JoinPage.fxml"));
            Scene joinScene = new Scene(joinPage.load(), 1080, 600);
            stage.setScene(joinScene);
            stage.show();
        }

        if (IsHost) {
            if (event.getSource() == PBPlus1 || event.getSource() == PBPlus2 || event.getSource() == PBPlus3) {

            }
        }
    }

    private void setPointsForPlayer() {

    }

    public static void main(String[] args) {
        launch();
    }
}