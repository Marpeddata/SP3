package com.company;

import java.util.ArrayList;

public class Team {
    int goalScore;
    int points;
    String teamName;
    ArrayList<String> playerList = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(String playerName){
        playerList.add(playerName);
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


    @Override
    public String toString() {

        String playerNames = "";

        for (String s : playerList) {
            playerNames += s + ",";
        }

        return this.teamName+","+playerNames+this.goalScore+","+this.points;
    }
}
