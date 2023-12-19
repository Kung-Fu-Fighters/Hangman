import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class PlayerInteraction implements EventHandler<ActionEvent> {

  private Player player;
  private TextField textFieldGuess;
  private StringBuilder displayWord;
  private Figure draw;
  private Pane hangmanPane;
  private Label wordToGuessLabel;
  private Label playerLabel;

  public PlayerInteraction(Player player,
                           TextField textFieldGuess,
                           StringBuilder displayWord,
                           Figure draw,
                           Pane hangmanPane,
                           Label wordToGuessLabel,
                           Label playerLabel) {
    this.player = player;
    this.textFieldGuess = textFieldGuess;
    this.displayWord = displayWord;
    this.draw = draw;
    this.hangmanPane = hangmanPane;
    this.wordToGuessLabel = wordToGuessLabel;
    this.playerLabel = playerLabel;
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

    render();
  }

  public void render() {
    wordToGuessLabel.setText(displayWord.toString().toUpperCase());
    playerLabel.setText(player.getName() + player.getScore());
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
