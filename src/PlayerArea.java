import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayerArea extends VBox {

  public PlayerArea(Player player) {
    super();
    TextField textFieldGuess = createAndConfigureTextField();
    Button buttonGuess = createGuessButton();
    Button confirmButton = confirmButton();
    Label playerlbl = generatePlayerLabel(player);
    StringBuilder displayWord = generateDisplayWord();
    Pane hangmanPane = new Pane();
    Label wordToGuessLabel = new Label(displayWord.toString());

    this.getChildren().addAll(playerlbl, textFieldGuess, buttonGuess, confirmButton, wordToGuessLabel, hangmanPane);

    hangmanPane.setPrefSize(200, 200);
  }

  public StringBuilder generateDisplayWord() {
    return new StringBuilder("____");
  }

  public Label generatePlayerLabel(Player player) {
    String playerName = player.getName();
    int score = player.getScore();
    String playerInfo = playerName + " " + score;
    return new Label(playerInfo);
  }

  public Button confirmButton() {
    return new Button("Bekräfta ord");
  }

  public TextField createAndConfigureTextField() {
    TextField textField = new TextField();
    textField.setPrefWidth(100);
    return textField;
  }

  public Button createGuessButton() {
    return new Button("Gissa");
  }
}
