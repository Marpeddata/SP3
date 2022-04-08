package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO
{

    public void saveTournamentData(ArrayList<Match> matches)
    {
        try {
            FileWriter writer2 = new FileWriter("tournamentData.txt");
            for (Match m : matches) {
                writer2.write(m.toString()+"\n");
            }
            writer2.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    // Det er lidt et spøjst valg at skulle have en arrayliste af teams med når vi skal indlæse match data,
    // men det er gjort for, at vi kan kæde holdene på matches sammen med holdene i teams listen.
     public ArrayList<Match> readTournamentData(ArrayList<Team> teams) {

        File file = new File("tournamentData.txt");
        ArrayList<Match> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String data[] = scanner.nextLine().split(",");

                Team team1 = getTeamByName(teams, data[0]);
                Team team2 = getTeamByName(teams, data[1]);

                Match m = new Match(team1, team2);
                m.setTeam1Score(Integer.parseInt(data[2]));
                m.setTeam2Score(Integer.parseInt(data[3]));
                result.add(m);
            }
        } catch (FileNotFoundException e){
            System.out.println("filen findes ikke");
        }return result;
    }

    // Leder listen af teams igennem og returnerer et Team udfra et givent teamName.
    // Returnerer null hvis der ikke er et team med det pågældende navn i listen.
    private Team getTeamByName(ArrayList<Team> teams, String teamName)
    {
        for (Team t : teams) {
            if (t.getTeamName().equals(teamName))
            {
                return  t;
            }
        }

        return null;
    }

    @Override
    public void saveTeamData(ArrayList<Team> team){

        try {
            FileWriter writer = new FileWriter("Team.txt");
            for (Team t : team){
                writer.write(t.toString()+"\n");
            }
            writer.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public ArrayList<Team> readTeamData() {
        File file = new File("Team.txt");
        ArrayList<Team> readData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] teamValues = scanner.nextLine().split(",");
                String teamName = teamValues[0];
                Team team = new Team(teamName);
                for (int i = 1; i < teamValues.length - 3; i++)
                {
                    team.addPlayer(teamValues[i]);
                }
                team.setGoalScore(Integer.parseInt(teamValues[teamValues.length - 2]));
                team.setPoints(Integer.parseInt(teamValues[teamValues.length - 1]));
                readData.add(team);

            }
        } catch (FileNotFoundException e) {
            readData = null;
        }
        return readData;
    }


}
