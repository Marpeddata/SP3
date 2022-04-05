public class Match {
    private int team1Score;
    private int team2Score;
    private int points;
    private String dateTime;
    private Teams team1;
    private Teams team2;


    public Match(Teams team1, Teams team2) {
        this.team1 = team1;
        this.team2 = team2;

    }

    public int getTeam1Score(){
        return team1Score;
    }

    public int getTeam2Score(){
        return team2Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;

    }

    public void setMatchScore(int team2Score){
        this.team2Score = team2Score;

    }


/*
    public void whoWon() {
        if (team1Score > team2Score) {
            team1.add.nextRound(); //arrayList
            team1.setPoints(team1.getPoints() + 2);
        }
        if (team2Score > team1Score) {
            team2.add.nextRound(); //arrayList
            team2.setPoints(team2.getPoints() + 2);
        }
    }
*/
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void goalDifference() {
        if (team1Score > team2Score) {
            int goalScoreWinner = team1Score - team2Score;
            int goalScoretLooser = team2Score - team1Score;
            team1.setGoalScore(goalScoreWinner);
            team2.setGoalScore(goalScoretLooser);
        }

        if (team2Score > team1Score) {
            int goalScoreWinner = team2Score - team1Score;
            int goalScoretLooser = team1Score - team2Score;
            team2.setGoalScore(goalScoreWinner);
            team1.setGoalScore(goalScoretLooser);
        }
    }
}
