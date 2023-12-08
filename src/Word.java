public class Word {

    // variable to store the word
    private String wordString;


    // Constructor to initialize the wordString
    public Word(String word) {
        this.wordString = word;
    }

    // Getter method that returns the word
    public String getWord() {
        return this.wordString;
    }

    // Setter method that set a new word
    public void setWord(String word) {
        this.wordString = word;
    }

    // Boolean method checks if it's correct word.
    public boolean checkIfCorrectWord(String guessedWord) {
        return this.wordString.equalsIgnoreCase(guessedWord);
    }

    // Method to allow players to guess for a letter
    public boolean checkIfLetterExist(String guessedletter) {
        //
        String letter = guessedletter;
        return this.wordString.contains(letter);
    }
}

