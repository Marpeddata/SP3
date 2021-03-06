import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tournament {
    String time;
    String date;
    FileIO myIO;
    TextUI ui;
    IO io;
    ArrayList<Team> fullTeamList;
    ArrayList<Match> matches;
    ArrayList<Team> sortedSeedings;




public Tournament(){

}




    public void createNewMatch() {

        Scanner scannerTurnament = new Scanner(System.in);
        ArrayList<Team> teamNames = new ArrayList<>();

        System.out.println("Pick team - 1-8");
        for (int i = 0; i < 8; i++) {
            System.out.println(i+1+" :" + teamNames.get(i).getTeamName());
        }

        // Copy arraylist to local availableTeams array
        Team[] availableTeams = (Team[]) teamNames.toArray();
        Team team1 = null; // ensure they are null for each time around
        Team team2 = null;

        while (team1 == null || team2 == null) {
            int input;
            try {
                input = Integer.parseInt(scannerTurnament.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Forkert Prøv igen");
                continue;
            }
            if (availableTeams[input - 1] != null) {
                if (team1 == null) {
                    team1 = availableTeams[input - 1];
                } else {
                    team2 = availableTeams[input - 1];
                }
                availableTeams[input - 1] = null;
            }
        }

        Match m = new Match(team1, team2);
        matches.add(m);

    }


        private void createTeams() {

            String teamName;
            String playerName;

            int numberOfTeams = 8;
            int maxNumberOfPlayers = 5;
            Scanner scanner=new Scanner(System.in);
            ArrayList<String> teams = new ArrayList<>();

            System.out.println("Enter 8 teams.");

            for (int i=1; i<=numberOfTeams;++i) {
                System.out.println();
                System.out.print("Team" + i + " - Enter team name: ");
                teamName = scanner.nextLine();
                teams.add(teamName);

                do{
                    System.out.print("Enter 2-5 players. Enter number of players: ");
                    maxNumberOfPlayers = Integer.parseInt(scanner.nextLine());
                } while (maxNumberOfPlayers < 2 || maxNumberOfPlayers >5);

                for (int j = 1; j <= maxNumberOfPlayers; ++j) {
                    System.out.print("Enter player "+j+" name: ");
                    playerName = scanner.nextLine();
                    teams.add(playerName);
                }
            }
            System.out.println(teams);

        }


    public void startTurnmanet(){
        Scanner startMenu = new Scanner(System.in);
        String input;
        System.out.println("Turnering Setup");
        System.out.println("Menu - Tryk 1-2");
        System.out.println("1 : Opsæt ny Turnering");
        System.out.println("2 : Igangværende Turnering");
        input = startMenu.nextLine();

        switch (input) {
            case "1" :
                //createNewTurnament();
                createTeams(); //If it isnt creating in the createNewTurnament function
                myIO.saveTeamData();
                //myIO.saveTournamentData();
                ui.mainMenu();
                break;
            case "2" :
                //myIO.readGamedata();
                //myIO.readPlayerdata();
                ui.mainMenu();
                break;
        }

    }







    public void createRound(){

    }
    //Doesnt work, since its returning an Int in a function with return type ArrayList
    //This is a way to try to sort and array of teams, based on a team Variable.
    //https://www.youtube.com/watch?v=wzWFQTLn8hI
    public ArrayList<Team> seeding(ArrayList<Team> tempSeeding){
        Collections.sort(tempSeeding, new Comparator<Team>(){
            public int compare(Team t1, Team t2){
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
                break;
            }
        }



    }

    //Modified version of pickup to check for which match doesnt have goalScore added
    //then asks for input to current unfinished match.
    public Match pickUp() {
        for (Match m : matches) {
            if (m.getTeam1Score() == -1) {
                return m; //This is the next match
                break;
            }
        }
        ArrayList<Goals> goals = new ArrayList<>();
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





}
