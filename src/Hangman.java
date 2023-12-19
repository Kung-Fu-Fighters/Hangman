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


        PlayerArea playerArea1 = new PlayerArea(playerList.get(0));
        PlayerArea playerArea2 = new PlayerArea(playerList.get(1));
        PlayerArea playerArea3 = new PlayerArea(playerList.get(2));
        PlayerArea playerArea4 = new PlayerArea(playerList.get(3));
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

        playerArea1.observePlayerAreas(playerArea2, playerArea3, playerArea4);
        playerArea2.observePlayerAreas(playerArea1, playerArea3, playerArea4);
        playerArea3.observePlayerAreas(playerArea1, playerArea2, playerArea4);
        playerArea4.observePlayerAreas(playerArea1, playerArea2, playerArea3);

        playerArea1.attachPlayerInteraction(draw, turnOrder, vicCond::checkVictoryCondition);
    }

}
