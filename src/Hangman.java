import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hangman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        PlayerList playerList = new PlayerList();

        int amountOfPlayers = 4; //here we will in a future version call for a function in GameSettings to choose the amount of players
        /*for(int i = 0; i < amountOfPlayers; i++) {
            //add in a future version so that the player choose name and word as arguments
            playerList.addPlayer(<String name>, <string word>);
        }*/

        primaryStage.setTitle("Awesome Hangman v0.1"); //name at the top of the screen "stage"
        Button buttonStartGame = new Button("Start a new game");
        GridPane grid = new GridPane(); //the grid for the graphic

        // the base for a for loop in a future version
        /*for (int i = 0; i < amountOfPlayers; i++) {
            TextField textFieldGuess = new TextField();
            Button buttonGuess = new Button("Gissa");
            buttonGuess.setOnAction(event -> {
                // Använd 'i' för att identifiera spelaren
                String guess = textFieldGuess.getText(); // Hämta gissningen från TextField
                //String word = playerList.getPlayerWord(i); // Hämta spelarens ord
                //boolean isCorrect = compareGuessToWord(guess, word); // Jämför gissningen med ordet
                // ... hantera resultatet av jämförelsen ...
            });
            // ... resten av din kod ...
        }*/


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
        VBox playerBox1 = new VBox(); //the graphic for player area
        playerBox1.getChildren().add(textFieldGuess1);
        playerBox1.getChildren().add(buttonGuess1);
        grid.add(playerBox1, 0, 0);
        VBox playerBox2 = new VBox();
        playerBox2.getChildren().add(textFieldGuess2);
        playerBox2.getChildren().add(buttonGuess2);
        grid.add(playerBox2, 1, 0);
        VBox playerBox3 = new VBox();
        playerBox3.getChildren().add(textFieldGuess3);
        playerBox3.getChildren().add(buttonGuess3);
        grid.add(playerBox3, 0, 1);
        VBox playerBox4 = new VBox();
        playerBox4.getChildren().add(textFieldGuess4);
        playerBox4.getChildren().add(buttonGuess4);
        grid.add(playerBox4, 1, 1);

        VBox root = new VBox(10);
        root.getChildren().add(buttonStartGame);

        Scene scene = new Scene(root, 800, 600); //the size of the stage (screen)
        primaryStage.setScene(scene);
        primaryStage.show();

        buttonStartGame.setOnAction(event -> {
            grid.setHgap(350); //how far between the player areas are from each other on a row
            grid.setVgap(250); //how far between the player areas are from each other in a column
            scene.setRoot(grid);
        });
    }
}