import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class VictoryConditions {



    public void checkVictoryCondition(PlayerList playerList) {

        TextInputDialog dialog = new TextInputDialog();


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
