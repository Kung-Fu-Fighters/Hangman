import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Hangman extends Application {

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

        primaryStage.setTitle("Awesome Hangman v0.2");

        GridPane grid = new GridPane();
        Pane hangmanPane = new Pane();
        grid.add(hangmanPane, 0, 0);


        List<PlayerArea> playerAreaList = new ArrayList<>();
        for(Player player : playerList.getPlayers()) {
            playerAreaList.add(new PlayerArea(player));
        }
        /*List<PlayerArea> playerAreaList = playerList
                        .getPlayers()
                        .stream()
                        //.map(player -> new PlayerArea((player)))
                        .map(PlayerArea::new)
                        .toList();*/

        playerAreaList.get(0).setStyle("-fx-background-color: #e7cbcb;");



        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        for (int i = 0; i < playerAreaList.size(); i++) {
            if(i < playerAreaList.size() / 2) {
                topBox.getChildren().addAll(playerAreaList.get(i));
            } else {
                bottomBox.getChildren().addAll(playerAreaList.get(i));
            }
            HBox.setHgrow(playerAreaList.get(i), Priority.ALWAYS);
        }

        VBox.setVgrow(topBox, Priority.ALWAYS);
        VBox.setVgrow(bottomBox, Priority.ALWAYS);


        VBox root = new VBox();
        root.getChildren().addAll(topBox, bottomBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        VictoryConditions vicCond = new VictoryConditions(playerList);

        for (PlayerArea playerArea : playerAreaList) {
            playerArea.observePlayerAreas(playerAreaList);
            playerArea.attachPlayerInteraction(draw, turnOrder, vicCond::checkVictoryCondition);
        }
    }
}
