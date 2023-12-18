import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerList{
    //A list to keep player items
    private List<Player> players;
    public PlayerList(){

        this.players = new ArrayList<>();
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }
    // To add one player at a time
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

    public List<Player> getPlayers() {
        return this.players;
    }

    public void initializeAll() {
        players.forEach(Player::initialize);
    }

}
