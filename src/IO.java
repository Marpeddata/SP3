import java.util.ArrayList;

public interface IO {
    ArrayList<Match> readTournamentData();
    void saveTournamentData(ArrayList<Tournament> tournament);
    ArrayList<Team> readTeamData();
    void saveTeamData();
}
