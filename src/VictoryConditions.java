import javafx.scene.control.TextInputDialog;

import java.util.List;
import java.util.Optional;

public class VictoryConditions {

    private PlayerList playerList;

    public VictoryConditions(PlayerList playerList) {
        this.playerList = playerList;
    }



    public void checkVictoryCondition() {

        TextInputDialog dialog = new TextInputDialog();
        System.out.println("test");

        for (int i = 0; i < 4; i++) {

            int score;

            if (playerList.get(i).getScorePoints() == 10) {
                score = playerList.get(i).getScore();
                playerList.get(i).setScore(score++);
                Optional<String> result = dialog.showAndWait();
                playerList.get(i).setGuessedWord(result.get());
            }
        }

    }

    public void changeScoreTable() {

    }
}
