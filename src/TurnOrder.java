import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TurnOrder {
    int guessingAmount=1;

    //Instance variable of type Queue (kö).
    private Queue<Player> playerQueue; // first in and first out.

    // the constructor, receiving a list of players and convert it to a Queue.
    public TurnOrder(List<Player> players) {
        this.playerQueue = new LinkedList<>(players);
    }

    // This methood returns the player whose turn it is currently, witout removing it from the queue.
    public Player getCurrentPlayer() {
        return playerQueue.peek(); // Peek methood, returns the element
    }

    // this method are moving next players turn order.
    public void moveToNextPlayer() {
        Player currentPlayer = playerQueue.poll(); // poll() removes the current player from the beging of the queue
        playerQueue.offer(currentPlayer); // offer() it adding the player to the end of the queue

    }

    public int getGuessingAmount() {
        return guessingAmount;
    }

    public void setGuessingAmount(int guessingAmount) {
        this.guessingAmount = guessingAmount;
    }

    public Queue<Player> getPlayerQueue() {
        return playerQueue;
    }

    public void setPlayerQueue(Queue<Player> playerQueue) {
        this.playerQueue = playerQueue;
    }
}
