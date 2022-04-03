public class Match {
    private int team1Score;
    private int team2Score;
    private Teams team1;
    private Teams team2;


    public Match(Teams team1, Teams team2){
        this.team1 = team1;
        this.team2 = team2;

    }

    public int getTeam1Score(){
        return team1Score;
    }

    public int getTeam2Score(){
        return team2Score;
    }

    public void setTeam1Score(int team1Score){
        this.team1Score = team1Score;

    }

    public void setMatchScore(int team2Score){
        this.team2Score = team2Score;
    }

    public void whoWon(){
        if(team1Score > team2Score){
            System.out.println(team1.getTeamName + "Won");
        }
        if(team2Score > team1Score){
            System.out.println(team2.getTeamName + "Won");
        }
    }



}
