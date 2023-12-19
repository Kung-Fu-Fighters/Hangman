public class VictoryConditions {


    public void checkVictoryCondition(PlayerList playerList) {
        System.out.println(playerList.get(0).getScore());
        for (int i = 0; i < 4; i++) {
            if (playerList.get(i).getScorePoints() == 10) {
                playerList.get(i).setScore(1);
            }
        }

    }

    public void changeScoreTable() {

    }
}
