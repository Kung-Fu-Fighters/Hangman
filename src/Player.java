import java.util.Scanner;

public class Player {
    private String name;
    private String guessedWord;
    // inte är en prio just nu vi kollar sen hur vi kommer att implementera logiken
    private int scorePoints;

    // När klassen anropas kommer användaren tillfrågas om info
    public Player(){
       playerInfo();
    }
    private void playerInfo(){
        Scanner scanner = new Scanner(System.in);
        //kontroll så att spelaren inte fortsätter utan att hen har skrivit sitt namn
        do {
            System.out.println("Skriv det namnet du vill använda när du spelar här:  ");
            this.name=scanner.nextLine();
        }while (name.isEmpty());

        do {
            System.out.println("Skriv in ett ord som andra spelare ska gissa på här:  ");
            this.guessedWord=scanner.nextLine();
        }while (guessedWord.isEmpty());

    }
    public String getName() {
        return name;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(int scorePoints) {
        this.scorePoints = scorePoints;
    }





}
