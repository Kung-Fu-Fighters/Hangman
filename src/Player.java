public class Player {
    private String name;
    private String guessedWord;
    // inte är en prio just nu vi kollar sen hur vi kommer att implementera logiken
    private int scorePoints;

    // När klassen anropas kommer användaren tillfrågas om info
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

}
