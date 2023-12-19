import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Hangman extends Application {



    /*public static void setupButtonGuessAction(List<Player> playerList, List<Button> buttons,
                                              List<TextField> textFields, List<StringBuilder> displayWords,
                                              List<Pane> hangmanPanes, List<Label> wordToGuessLabels,
                                              List<Label> playerLabels, Figure draw) {
        for (int i = 0; i < playerList.size(); i++) {
            int playerIndex = i;
            buttons.get(i).setOnAction(new PlayerInteraction(
                    playerList.get(playerIndex),
                    textFields.get(playerIndex),
                    displayWords.get(playerIndex),
                    draw,
                    hangmanPanes.get(playerIndex),
                    wordToGuessLabels.get(playerIndex),
                    playerLabels.get(playerIndex)
            ));
        }
    }*/

    // text input dialog
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Figure draw = new Figure();
        PlayerList playerList = new PlayerList();

        TurnOrder turnOrder = new TurnOrder(playerList.getPlayers());


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


        VBox playerArea1 = new PlayerArea(playerList.get(0));
        VBox playerArea2 = new PlayerArea(playerList.get(1));
        VBox playerArea3 = new PlayerArea(playerList.get(2));
        VBox playerArea4 = new PlayerArea(playerList.get(3));
        playerArea1.setStyle("-fx-background-color: #e7cbcb;");
        // Create a label to display the word to be guessed


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


        VBox root = new VBox();
        root.getChildren().addAll(topBox, bottomBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        VictoryConditions vicCond = new VictoryConditions(playerList);
        //vicCond.checkVictoryCondition(playerList);


        /*buttonGuess1.setOnAction(new PlayerInteraction(

                playerList.get(0),
                textFieldGuess1,
                displayWord1,
                draw,
                hangmanPane1,
                wordToGuessLabel1,
                player1lbl,
                turnOrder,
                playerArea1,
                playerArea2,
                playerArea3,
                playerArea4,
                vicCond::checkVictoryCondition
        ));

        buttonGuess2.setOnAction(new PlayerInteraction(
                playerList.get(1),
                textFieldGuess2,
                displayWord2,
                draw,
                hangmanPane2,
                wordToGuessLabel2,
                player2lbl,
                turnOrder,
                playerArea2,
                playerArea1,
                playerArea3,
                playerArea4,
                () -> vicCond.changeScoreTable()

        ));

        buttonGuess3.setOnAction(new PlayerInteraction(
                playerList.get(2),
                textFieldGuess3,
                displayWord3,
                draw,
                hangmanPane3,
                wordToGuessLabel3,
                player3lbl,
                turnOrder,
                playerArea3,
                playerArea1,
                playerArea2,
                playerArea4,
                vicCond::checkVictoryCondition
        ));

        buttonGuess4.setOnAction(new PlayerInteraction(
                playerList.get(3),
                textFieldGuess4,
                displayWord4,
                draw,
                hangmanPane4,
                wordToGuessLabel4,
                player4lbl,
                turnOrder,
                playerArea4,
                playerArea1,
                playerArea2,
                playerArea3,
                vicCond::checkVictoryCondition


        ));*/

        //confirmButton();
    }

    public void createPlayerInteraction() {

    }
}
