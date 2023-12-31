import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerArea extends VBox {

  private TextField textFieldGuess;
  private Button buttonGuess;
  private Button confirmButton;
  private Label playerLbl;
  private Label wordToGuessLbl;
  private StringBuilder displayWord;
  private Pane hangmanPane;
  private Player player;

  private List<PlayerArea> otherPlayerAreas;
  private List<PlayerArea> allPlayerAreas;

  public PlayerArea(Player player) {
    super();

    this.player = player;
    textFieldGuess = createAndConfigureTextField();
    buttonGuess = createGuessButton();
    confirmButton = confirmButton();
    playerLbl = generatePlayerLabel(player);
    displayWord = generateDisplayWord();
    hangmanPane = new Pane();
    wordToGuessLbl = new Label(displayWord.toString());

    this.getChildren().addAll(playerLbl, textFieldGuess, buttonGuess, confirmButton, wordToGuessLbl, hangmanPane);

    hangmanPane.setPrefSize(200, 200);
  }

  public void observePlayerAreas(List<PlayerArea> playerAreas) {
    this.allPlayerAreas = playerAreas;
    this.otherPlayerAreas = new ArrayList<>();

    for (PlayerArea playerArea : playerAreas) {
      if(!playerArea.equals(this)) {
        otherPlayerAreas.add(playerArea);
      }
    }
  }

  public void attachPlayerInteraction(Figure draw, TurnOrder turnOrder, EndTurnHandler endTurnHandler) {
    buttonGuess.setOnAction(new PlayerInteraction(
            this.player,
            this.textFieldGuess,
            this.displayWord,
            draw,
            this.hangmanPane,
            this.wordToGuessLbl,
            this.playerLbl,
            turnOrder,
            allPlayerAreas,
            endTurnHandler
    ));
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
