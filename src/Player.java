public class Player {
    private String name;
    private String guessedWord;
    private int scorePoints;

    private int positionX;

    private int positionY;

    public Player(String name, String guessedWord){
        this.name=name;
        this.guessedWord=guessedWord;
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
}