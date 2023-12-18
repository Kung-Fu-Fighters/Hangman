import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Hangman extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private StringBuilder displayWord1 = new StringBuilder("____");
    private StringBuilder displayWord2 = new StringBuilder("____");
    private StringBuilder displayWord3 = new StringBuilder("____");
    private StringBuilder displayWord4 = new StringBuilder("____");

    public void start(Stage primaryStage) {


        Figure draw = new Figure();
        PlayerList playerList = new PlayerList();
        playerList.addPlayer("Yves - Poäng: ", "java");
        playerList.addPlayer("Rudolf - Poäng: ", "game");
        playerList.addPlayer("Nicolaus - Poäng: ", "gran");
        playerList.addPlayer("Grinchen - Poäng: ", "kaka");

        playerList.initializeAll();

        primaryStage.setTitle("Awesome Hangman v0.1");
        Button buttonStartGame = new Button("Start a new game"); //Is not in use at the moment
        GridPane grid = new GridPane();
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

        int scoreTable1 = playerList.get(0).getScore();
        int scoreTable2 = playerList.get(1).getScore();
        int scoreTable3 = playerList.get(2).getScore();
        int scoreTable4 = playerList.get(3).getScore();

        String player1 = playerList.get(0).getName() + scoreTable1;
        String player2 = playerList.get(1).getName() + scoreTable2;
        String player3 = playerList.get(2).getName() + scoreTable3;
        String player4 = playerList.get(3).getName() + scoreTable4;

        Pane hangmanPane1 = new Pane();
        Pane hangmanPane2 = new Pane();
        Pane hangmanPane3 = new Pane();
        Pane hangmanPane4 = new Pane();

        VBox playerArea1 = new VBox();
        VBox playerArea2 = new VBox();
        VBox playerArea3 = new VBox();
        VBox playerArea4 = new VBox();

        // Create a label to display the word to be guessed
        Label wordToGuessLabel1 = new Label(displayWord1.toString());
        Label wordToGuessLabel2 = new Label(displayWord2.toString());
        Label wordToGuessLabel3 = new Label(displayWord3.toString());
        Label wordToGuessLabel4 = new Label(displayWord4.toString());


        Label player1lbl = new Label(player1);
        Label player2lbl = new Label(player2);
        Label player3lbl = new Label(player3);
        Label player4lbl = new Label(player4);


        playerArea1.getChildren().addAll(player1lbl, textFieldGuess1, buttonGuess1, wordToGuessLabel1, hangmanPane1);
        playerArea2.getChildren().addAll(player2lbl, textFieldGuess2, buttonGuess2, wordToGuessLabel2, hangmanPane2);
        playerArea3.getChildren().addAll(player3lbl, textFieldGuess3, buttonGuess3, wordToGuessLabel3, hangmanPane3);
        playerArea4.getChildren().addAll(player4lbl, textFieldGuess4, buttonGuess4, wordToGuessLabel4, hangmanPane4);

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

        VictoryConditions vicCond = new VictoryConditions();
        vicCond.checkVictoryCondition(playerList);

        buttonGuess1.setOnAction(new PlayerInteraction(
                playerList.get(0),
                textFieldGuess1,
                displayWord1,
                draw,
                hangmanPane1,
                wordToGuessLabel1,
                player1lbl
        ));

        buttonGuess2.setOnAction(new PlayerInteraction(
                playerList.get(1),
                textFieldGuess2,
                displayWord2,
                draw,
                hangmanPane2,
                wordToGuessLabel2,
                player2lbl
        ));

        buttonGuess3.setOnAction(new PlayerInteraction(
                playerList.get(2),
                textFieldGuess3,
                displayWord3,
                draw,
                hangmanPane3,
                wordToGuessLabel3,
                player3lbl
        ));

        buttonGuess4.setOnAction(new PlayerInteraction(
                playerList.get(3),
                textFieldGuess4,
                displayWord4,
                draw,
                hangmanPane4,
                wordToGuessLabel4,
                player4lbl
        ));
    }
}