import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerList{
    //A list to keep player items
    private List<Player> players;
    public PlayerList(){
        this.players = new ArrayList<>();
    }
    //To avoid direct modification it calls a copy of the player list
    public List<Player> getPlayers(){
        return players;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }
    // To adding one player at a time
    public void addPlayer(String name, String guessedWord){
        players.add(new Player(name, guessedWord));
    }
    public Player get(int index) {
        return players.get(index);
    }

    // SHOW PLAYER INFORMATION ONE BY ONE, IT WOULD BE GOOD IF WE CREATE A SEPARATE CLASS FOR THIS PURPOSE
    public void showPlayers(){
        for (Player player: players){
            System.out.println("Player name [" + player.getName() + "]\nGuessed Word " + "[" + player.getGuessedWord() + "]");
        }
    }

}
