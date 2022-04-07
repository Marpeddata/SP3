import java.util.ArrayList;

public class Team {
    int goalScore;
    int points;
    String teamName;
    String playerName;
    ArrayList<String> teamList;
/*
    public void createTeams(){

    }
*/

    public void addPlayer(String playerName){
        teamList.add(playerName);
    }

    public String getTeamName(){
        return teamName;
    }

    public void setGoalScore(int goalScore){

        this.goalScore = goalScore;
    }

    public int getGoalScore(){
        return goalScore;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return points;
    }

    public void newResults(){

    }

    public void seeSchedule(){

    }




}
