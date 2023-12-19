import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class VictoryConditions {

    private PlayerList playerList;

    public VictoryConditions(PlayerList playerList) {
        this.playerList = playerList;
    }



    public void checkVictoryCondition() {

        TextInputDialog dialog = new TextInputDialog();
        // Sätt en titel på dialogrutan
        dialog.setTitle(" Nytt ord ");

        // Sätt rubriken på dialogrutan
        dialog.setHeaderText(" Grattis till poäng!!!");

        // Sätt innehållet i dialogrutan
        dialog.setContentText(" Skriv in ett nytt ord! ");


        for (int i = 0; i < playerList.getPlayers().size(); i++) {

            int score;

            if (playerList.get(i).getScorePoints() == 10) {
                score = playerList.get(i).getScore();
                playerList.get(i).setScorePoints(0);
                playerList.get(i).setScore(score++);
                Optional<String> result = dialog.showAndWait();
                playerList.get(i).setGuessedWord(result.get());


            }
        }

    }

    public void changeScoreTable() {

    }
}
