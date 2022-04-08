package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tournament {
    IO myIO;
    TextUI ui;

    ArrayList<Team> fullTeamList = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();
    ArrayList<Team> sortedSeedings;

    public Tournament()
    {
        myIO = new FileIO();
        ui = new TextUI();
    }

    public void startTournament() {
        Scanner startMenu = new Scanner(System.in);
        String input;
        System.out.println("Turnering Setup");
        System.out.println("Menu - Tryk 1-2");
        System.out.println("1 : Opsæt ny Turnering");
        System.out.println("2 : Igangværende Turnering");
        input = startMenu.nextLine();

        switch (input) {
            case "1":
                createTeams(); //If it isnt creating in the createNewTurnament function
                createMatches();
                myIO.saveTeamData(fullTeamList);
                myIO.saveTournamentData(matches);
                ui.mainMenu();
                break;
            case "2":
                fullTeamList = myIO.readTeamData();
                matches = myIO.readTournamentData(fullTeamList);
                ui.mainMenu();
                break;
        }
    }

    public ArrayList<Match> createMatches()
    {
        // laver de indledende matches, første iteration er det team 0 og 1. næste er det team 2 og 3, osv.
        for (int j = 0; j < 8; j+=2)
        {
            matches.add(new Match(fullTeamList.get(j), fullTeamList.get(j+1)));
        }

        // her laver vi semifinale matches og finale match som endnu ikke har nogen hold
        // da de indlendende runder endnu ikke er afviklede
        matches.add(new Match(null, null));
        matches.add(new Match(null, null));
        matches.add(new Match(null, null));

        return matches;
    }

    private void createTeams()
    {

        String teamName;
        String playerName;

        int numberOfTeams = 8;
        int maxNumberOfPlayers = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 8 teams.");

        for (int i = 1; i <= numberOfTeams; ++i) {
           // System.out.println();
            System.out.print("Team" + i + " - Enter team name: ");
            teamName = scanner.nextLine();
            var team = new Team(teamName);
            fullTeamList.add(team);

            do {
                System.out.print("Enter 2-5 players. Enter number of players: ");
                maxNumberOfPlayers = Integer.parseInt(scanner.nextLine());

               // maxNumberOfPlayers = scanner.nextInt();
            } while (maxNumberOfPlayers < 2 || maxNumberOfPlayers > 5);

            for (int j = 1; j <= maxNumberOfPlayers; ++j) {
                System.out.print("Enter player " + j + " name: ");
                playerName = scanner.nextLine();
                team.addPlayer(playerName);
            }
        }
    }




    //Doesnt work, since its returning an Int in a function with return type ArrayList
    //This is a way to try to sort and array of teams, based on a team Variable.
    //https://www.youtube.com/watch?v=wzWFQTLn8hI
    public ArrayList<Team> seeding(ArrayList<Team> tempSeeding) {
        Collections.sort(tempSeeding, new Comparator<Team>() {
            public int compare(Team t1, Team t2) {
                return Integer.valueOf(t1.getGoalScore()).compareTo(t2.getGoalScore());
            }
        });

        return null;
    }

    //checks for how far the turnament has come, based on which matches is missing goal score.
    public Match pickUp() {
        for (Match m : matches) {
            if (m.getTeam1Score() == -1) {
                return m; //This is the next match
            }
        }

        return null;
    }


    //Modified version of pickup to check for which match doesnt have goalScore added
    //then asks for input to current unfinished match.
    public Match pickUpp() {
        for (Match m : matches) {
            if (m.getTeam1Score() == -1) {
                return m; //This is the next match

            }
        }
       /* ArrayList<Goals> goals = new ArrayList<>();
        homeTeam=team1;
        awayTeam=team2;
        System.out.print("Enter goals home team: ");
        homeTeam = scanner.nextInt();
        Goals g = new Goals(homeTeam);
        goals.add(g);
        System.out.print("Enter goals away team: ");
        awayTeam = scanner.nextInt();
        Goals g = new Goals(awayTeam);
        goals.add(g);
    }
/*

        */
        return null;
    }
}




