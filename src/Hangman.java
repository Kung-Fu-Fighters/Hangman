import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Hangman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Figure draw = new Figure();
        PlayerList playerList = new PlayerList();

        primaryStage.setTitle("Awesome Hangman v0.1");
        Button buttonStartGame = new Button("Start a new game");
        GridPane grid = new GridPane(); //the grid for the graphic
        Pane hangmanPane = new Pane();
        grid.add(hangmanPane, 0, 0);
        TextField textFieldGuess1 = new TextField();
        TextField textFieldGuess2 = new TextField();
        TextField textFieldGuess3 = new TextField();
        TextField textFieldGuess4 = new TextField();
        textFieldGuess1.setPrefWidth(100);
        textFieldGuess2.setPrefWidth(100);
        textFieldGuess3.setPrefWidth(100);
        textFieldGuess4.setPrefWidth(100);
        Button buttonGuess1 = new Button("Gissa");
        Button buttonGuess2 = new Button("Gissa");
        Button buttonGuess3 = new Button("Gissa");
        Button buttonGuess4 = new Button("Gissa");
        BorderPane borderPane = new BorderPane();
        String player1 = "Spelare A"; //temporary place holders
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
        HBox.setHgrow(playerArea1, Priority.ALWAYS);
        HBox.setHgrow(playerArea2, Priority.ALWAYS);
        HBox.setHgrow(playerArea3, Priority.ALWAYS);
        HBox.setHgrow(playerArea4, Priority.ALWAYS);
        VBox.setVgrow(topBox, Priority.ALWAYS);
        VBox.setVgrow(bottomBox, Priority.ALWAYS);
        hangmanPane1.setPrefSize(200, 200);
        hangmanPane2.setPrefSize(200, 200);
        hangmanPane3.setPrefSize(200, 200);
        hangmanPane4.setPrefSize(200, 200);
        VBox root = new VBox();
        root.getChildren().addAll(topBox, bottomBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        buttonGuess1.setOnAction(event -> {
            draw.updateHangmanFigure(1, 100, 100, hangmanPane1);
        });
        buttonGuess2.setOnAction(event -> {
            draw.updateHangmanFigure(1, 100, 100, hangmanPane2);
        });
        buttonGuess3.setOnAction(event -> {
            draw.updateHangmanFigure(1, 100, 100, hangmanPane3);
        });
        buttonGuess4.setOnAction(event -> {
            draw.updateHangmanFigure(1, 100, 100, hangmanPane4);
        });
    }
}