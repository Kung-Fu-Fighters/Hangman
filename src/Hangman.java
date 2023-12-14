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
        playerList.addPlayer("Yves", "JAVA");
        playerList.addPlayer("Rudolf", "GAME");
        playerList.addPlayer("Nicolaus", "GRAN");
        playerList.addPlayer("Grinchen", "KAKA");

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
        String player1 = playerList.get(0).getName();
        String player2 = playerList.get(1).getName();
        String player3 = playerList.get(2).getName();
        String player4 = playerList.get(3).getName();
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


        playerArea1.getChildren().addAll(new Label(player1), textFieldGuess1, buttonGuess1, wordToGuessLabel1, hangmanPane1);
        playerArea2.getChildren().addAll(new Label(player2), textFieldGuess2, buttonGuess2, wordToGuessLabel2, hangmanPane2);
        playerArea3.getChildren().addAll(new Label(player3), textFieldGuess3, buttonGuess3, wordToGuessLabel3, hangmanPane3);
        playerArea4.getChildren().addAll(new Label(player4), textFieldGuess4, buttonGuess4, wordToGuessLabel4, hangmanPane4);

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
            String guessedLetter = textFieldGuess1.getText().toUpperCase();

            if(playerList.get(0).getGuessedWord().equals(textFieldGuess1)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(0).getGuessedWord().contains(textFieldGuess1.getText())) {
                //kod för att sätta ut bokstaven på rätt plats i ordet
                if (guessedLetter.length() == 1) {
                    boolean correctGuess = false;

                    for (int i = 0; i < playerList.get(0).getGuessedWord().length(); i++) {
                        if (playerList.get(0).getGuessedWord().charAt(i) == guessedLetter.charAt(0)) {
                            displayWord1.setCharAt(i, guessedLetter.charAt(0));
                            correctGuess = true;
                        }
                    }

                    if (correctGuess) {
                        System.out.println(displayWord1);
                        wordToGuessLabel1.setText(displayWord1.toString());
                    }
                }
            }
                if (!playerList.get(0).getGuessedWord().contains(textFieldGuess1.getText())) {
                    playerList.get(0).setScorePoints(playerList.get(0).getScorePoints() + 1);
                    draw.updateHangmanFigure(playerList.get(0).getScorePoints(), 100, 100, hangmanPane1);
                }


        });

        buttonGuess2.setOnAction(event -> {
            String guessedLetter = textFieldGuess2.getText().toUpperCase();

            if(playerList.get(1).getGuessedWord().equals(textFieldGuess2)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(1).getGuessedWord().contains(textFieldGuess2.getText())) {
                //kod för att sätta ut bokstaven på rätt plats i ordet
                if (guessedLetter.length() == 1) {
                    boolean correctGuess = false;

                    for (int i = 0; i < playerList.get(1).getGuessedWord().length(); i++) {
                        if (playerList.get(1).getGuessedWord().charAt(i) == guessedLetter.charAt(0)) {
                            displayWord2.setCharAt(i, guessedLetter.charAt(0));
                            correctGuess = true;
                        }
                    }

                    if (correctGuess) {
                        System.out.println(displayWord2);
                        wordToGuessLabel1.setText(displayWord2.toString());
                    }
                }
            }
            if(!playerList.get(1).getGuessedWord().contains(textFieldGuess2.getText())){
                playerList.get(1).setScorePoints(playerList.get(1).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(1).getScorePoints(), 100, 100, hangmanPane2);
            }

        });

        buttonGuess3.setOnAction(event -> {
            String guessedLetter = textFieldGuess3.getText().toUpperCase();

            if(playerList.get(2).getGuessedWord().equals(textFieldGuess3)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(2).getGuessedWord().contains(textFieldGuess3.getText())) {
                //kod för att sätta ut bokstaven på rätt plats i ordet
                if (guessedLetter.length() == 1) {
                    boolean correctGuess = false;

                    for (int i = 0; i < playerList.get(2).getGuessedWord().length(); i++) {
                        if (playerList.get(2).getGuessedWord().charAt(i) == guessedLetter.charAt(0)) {
                            displayWord3.setCharAt(i, guessedLetter.charAt(0));
                            correctGuess = true;
                        }
                    }

                    if (correctGuess) {
                        System.out.println(displayWord3);
                        wordToGuessLabel1.setText(displayWord3.toString());
                    }
                }
            }
            if(!playerList.get(2).getGuessedWord().contains(textFieldGuess3.getText())){
                playerList.get(2).setScorePoints(playerList.get(2).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(2).getScorePoints(), 100, 100, hangmanPane3);
            }

        });

        buttonGuess4.setOnAction(event -> {
            String guessedLetter = textFieldGuess4.getText().toUpperCase();

            if(playerList.get(3).getGuessedWord().equals(textFieldGuess4)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(3).getGuessedWord().contains(textFieldGuess4.getText())) {
                //kod för att sätta ut bokstaven på rätt plats i ordet
                if (guessedLetter.length() == 1) {
                    boolean correctGuess = false;

                    for (int i = 0; i < playerList.get(3).getGuessedWord().length(); i++) {
                        if (playerList.get(3).getGuessedWord().charAt(i) == guessedLetter.charAt(0)) {
                            displayWord4.setCharAt(i, guessedLetter.charAt(0));
                            correctGuess = true;
                        }
                    }

                    if (correctGuess) {
                        System.out.println(displayWord4);
                        wordToGuessLabel1.setText(displayWord4.toString());
                    }
                }
            }
            if(!playerList.get(3).getGuessedWord().contains(textFieldGuess4.getText())){
                playerList.get(3).setScorePoints(playerList.get(3).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(3).getScorePoints(), 100, 100, hangmanPane4);
            }

        });
    }
}