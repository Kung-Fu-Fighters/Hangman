public class GameSettings {


    // instantiate variables 
    private int guessesAmount = 10;
    private int playerAmount = 4;
    private PlayerList playerList = new PlayerList();


    // getter and setters
    public int getGuessesAmount() {
        return  getPlayerAmount();
    }

    public void setGuessesAmount(int guessesAmount) {
        this.guessesAmount = guessesAmount;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }

    public void startGame() {
        // Show all players when the game starts
        playerList.showPlayers();
    }

}
