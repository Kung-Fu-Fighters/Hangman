import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

public class Hangman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Figure draw = new Figure();
        PlayerList playerList = new PlayerList();

        primaryStage.setTitle("Awesome Hangman v0.1"); //name at the top of the screen "stage"
        Button buttonStartGame = new Button("Start a new game");
        GridPane grid = new GridPane(); //the grid for the graphic
        Pane hangmanPane = new Pane();
        grid.add(hangmanPane, 0, 0);
        TextField textFieldGuess1 = new TextField(); //the field where the players their guesses
        TextField textFieldGuess2 = new TextField();
        TextField textFieldGuess3 = new TextField();
        TextField textFieldGuess4 = new TextField();
        textFieldGuess1.setPrefWidth(100); //the width of the textfield
        textFieldGuess2.setPrefWidth(100);
        textFieldGuess3.setPrefWidth(100);
        textFieldGuess4.setPrefWidth(100);
        Button buttonGuess1 = new Button("Gissa"); //the button to submit your guess,
        Button buttonGuess2 = new Button("Gissa"); // not functioning at the moment,
        Button buttonGuess3 = new Button("Gissa"); // need to add some method calls,
        Button buttonGuess4 = new Button("Gissa"); // like checkIfLetterExist()
        BorderPane borderPane = new BorderPane();
        String player1 = "Spelare A"; //tmeporary place holders
        String player2 = "Spelare B"; // these "names" should come from
        String player3 = "Spelare C"; // the player objects in playerList
        String player4 = "Spelare D";
        Pane hangmanPane1 = new Pane();
        Pane hangmanPane2 = new Pane();
        Pane hangmanPane3 = new Pane();
        Pane hangmanPane4 = new Pane();

        VBox playerArea1 = new VBox();
        VBox playerArea2 = new VBox();
        VBox playerArea3 = new VBox();
        VBox playerArea4 = new VBox();

        playerArea1.getChildren().addAll(new Label(player1), textFieldGuess1, buttonGuess1, hangmanPane1);
        playerArea2.getChildren().addAll(new Label(player2), textFieldGuess2, buttonGuess2, hangmanPane2);
        playerArea3.getChildren().addAll(new Label(player3), textFieldGuess3, buttonGuess3, hangmanPane3);
        playerArea4.getChildren().addAll(new Label(player4), textFieldGuess4, buttonGuess4, hangmanPane4);

        HBox topBox = new HBox();
        topBox.getChildren().addAll(playerArea1, playerArea2);

        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(playerArea3, playerArea4);

        VBox root = new VBox();
        root.getChildren().addAll(topBox, bottomBox);

    }
}