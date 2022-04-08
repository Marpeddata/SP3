package com.company;

import java.util.ArrayList;

public interface IO {
    ArrayList<Match> readTournamentData(ArrayList<Team> teams);
    void saveTournamentData(ArrayList<Match> matches);
    ArrayList<Team> readTeamData();
    void saveTeamData(ArrayList<Team> teams);
}