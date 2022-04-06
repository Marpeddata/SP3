import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    ArrayList<String> getTeamInfo = new ArrayList<>();
    Match match;
    FileIO data;



    public void mainMenu(){
        Scanner menuInput = new Scanner(System.in);
        String input;
        System.out.println("Menu - Tryk 1-5");
        System.out.println("1 : indput resultater");
        System.out.println("2 : Se Stilling");
        System.out.println("3 : Se Program");
        System.out.println("4 : Se Hold");
        System.out.println("5 : Save & Quit");
        input = menuInput.nextLine();


        switch(input){
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            case "5":
                data.saveTurnemantData();
                break;

        }

    }

    public void setMatchResult(Match match){
        Scanner myObj = new Scanner(System.in);
        int goalscore;
        System.out.println("Indtast team1 målscore");
        goalscore = Integer.parseInt(myObj.nextLine());
        match.setTeam1Score(goalscore);
        System.out.println("Indtast team2 målscore");
        goalscore = Integer.parseInt(myObj.nextLine());
        //match.setTeam2Score(goalscore);
    }



}
