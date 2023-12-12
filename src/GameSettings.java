public class GameSettings {


    // instantiate variables 
    private int guessesAmount;
    private int playerAmount = 4;
    private PlayerList playerList = new Player List();


    // getter and setters
    public int getGuessesAmount() {
        playerList.addPlayer(new Player());
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
