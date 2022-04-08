package com.company;

public class Match {
    private int team1Score;
    private int team2Score;
    private int points;
    private String dateTime;
    private Team team1;
    private Team team2;


    public Match(Team team1, Team team2) {
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

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public void setMatchScore(int team2Score){
        this.team2Score = team2Score;
    }

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

    @Override
    public String toString() {
        if (this.team1 == null || this.team2 == null)
            return "null,null,0,0";

        return this.team1.getTeamName()+","+this.team2.getTeamName()+","+this.team1Score+","+this.team2Score;
    }
}
