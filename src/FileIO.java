import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements IO{



    public void saveTournamentData(ArrayList<Tournament> tournament) {
        String tournamentData = "";
        for(Tournament tour : tournament){
            tournamentData += tour+"\n";
        }
        try {
            FileWriter writer2 = new FileWriter("");
            writer2.write(tournamentData);
            writer2.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    public ArrayList<Match> readTournamentData() {

        File file = new File("C:\\Users\\Administrator\\Desktop\\tournamentData.txt");
        ArrayList<Match> result = new ArrayList<Match>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                Match m = new Match();
                String data[] = scanner.nextLine().split(",");
                m.setTeamName(data[0]);
                m.setTeamName(data[1]);
                m.setTeamOneScore(Integer.ParseIntd(ata[2]));
                m.setTeamTwoScore(Integer.ParseInt(data[3]));
                result.add(m);
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }return result;
    }

    public void saveTeamData(ArrayList<Team> team){
        String teamData = "";
        for (Team t : team){
            teamData += t;
        }
        try {
            FileWriter writer = new FileWriter("nat");
            writer.write(teamData);
            writer.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }


    public ArrayList<Team> readTeamData() {
        File file = new File("src/teamData.txt");
        ArrayList<Team> readData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] teamValues = scanner.nextLine().split(",");
                String teamName = teamValues[0];
                Team team = new Team(teamName);
                readData.add(team);

            }
        } catch (FileNotFoundException e) {
            readData = null;
        }
        return readData;
    }
}
