import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;

public class Player {
    private String name;
    private String guessedWord;
    private int scorePoints;

    private IntegerProperty score = new SimpleIntegerProperty(0);
    private int positionX;

    private int positionY;

    Label scoreLabel = new Label();
    // Bind label's text property to the score



    public Player(String name, String guessedWord){
        this.name = name;
        this.guessedWord = guessedWord;
    }
    public void initialize() {
        scoreLabel.textProperty().bind(Bindings.convert(score));
    }
    public String getName(){
        return name;
    }
    public String getGuessedWord(){
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord){
        this.guessedWord = guessedWord;
    }

    public int getScorePoints(){
        return scorePoints;
    }

    public void setScorePoints(int scorePoints){
        this.scorePoints = scorePoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public final int getScore() {
        return score.get();
    }

    public final void setScore(int score) {
        this.score.set(score);
    }
}