import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayerInteraction implements EventHandler<ActionEvent> {

  private Player player;
  private TextField textFieldGuess;
  private StringBuilder displayWord;
  private Figure draw;
  private Pane hangmanPane;
  private Label wordToGuessLabel;
  private Label playerLabel;
  private TurnOrder turnOrder;
  private VBox playerArea;

  public PlayerInteraction(Player player,
                           TextField textFieldGuess,
                           StringBuilder displayWord,
                           Figure draw,
                           Pane hangmanPane,
                           Label wordToGuessLabel,
                           Label playerLabel,
                           TurnOrder turnOrder,
                           VBox playerArea) {
    this.player = player;
    this.textFieldGuess = textFieldGuess;
    this.displayWord = displayWord;
    this.draw = draw;
    this.hangmanPane = hangmanPane;
    this.wordToGuessLabel = wordToGuessLabel;
    this.playerLabel = playerLabel;
    this.turnOrder= turnOrder;
    this.playerArea=playerArea;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
    String guessedLetter = textFieldGuess.getText();

    if (player.getGuessedWord().equals(textFieldGuess)) {
      //kod för att visa att spelaren är ute
    }
    if (isTextInWord(guessedLetter)) {
      //kod för att sätta ut bokstaven på rätt plats i ordet
      switch (guessedLetter.length()) {
        case 1 -> handleGuessLetter(guessedLetter.charAt(0));
        //default -> handleGuessWord(guessedLetter);
      }
    } else {
      handleIncorrectGuess();
    }
    changeTurn();
    render();
  }


  public void changeTurn(){
    int guessingAmountNumber= turnOrder.getGuessingAmount();

    turnOrder.setGuessingAmount(guessingAmountNumber+1);
    if(guessingAmountNumber==3){
      playerArea.setStyle("-fx-background-color: #ffffff;");
      turnOrder.setGuessingAmount(guessingAmountNumber=1);
      turnOrder.moveToNextPlayer();
    }

  }
  public void render() {
    wordToGuessLabel.setText(displayWord.toString().toUpperCase());
    playerLabel.setText(player.getName() + player.getScore());
    if (turnOrder.getGuessingAmount()==1){
      playerArea.setStyle("-fx-background-color: #e7cbcb;");
    }

  }

  public void handleIncorrectGuess() {
    player.setScorePoints(player.getScorePoints() + 1);
    draw.updateHangmanFigure(player.getScorePoints(), 100, 100, hangmanPane);
    // if score point = 10, create a new secret Word and update score tabel
    //vicCond.checkVictoryCondition(playerList);
    if (player.getScorePoints() == 10) {
      player.setScore(player.getScore() + 1);
    }
  }

  public void handleGuessLetter(char letter) {
    for (int i = 0; i < player.getGuessedWord().length(); i++) {
      if (player.getGuessedWord().charAt(i) == letter) {
        displayWord.setCharAt(i, letter);
      }
    }
  }

  public boolean isTextInWord(String text) {
    return player.getGuessedWord().contains(text);
  }
}
