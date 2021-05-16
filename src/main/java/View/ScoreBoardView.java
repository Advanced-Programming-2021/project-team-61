package View;

import Controller.ScoreBoardMenu;
import Model.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreBoardView {
    enum Commands {
        CURRENTMENU,
        INVALID
    }

    private static ScoreBoardView s = null;
    private ScoreBoardMenu scoreBoardMenu;
    public static Scanner scanner = new Scanner(System.in);
    private String command;

    private ScoreBoardView() {
    }

    public static ScoreBoardView getInstance() {
        if (s == null)
            s = new ScoreBoardView();
        return s;
    }

    public void scan() {
        scoreBoardMenu = ScoreBoardMenu.getInstance();
        while (true) {
            command = scanner.nextLine();
            if (( getCommandMatcher(command,"menu exit")).find()) {
                break;
            }
            else if (( getCommandMatcher(command,"msc")).find()){
                printMessage(Commands.CURRENTMENU);
            }
            else if(command.equals("scoreboard show")){
              scoreBoardMenu.sortByNickname();
              scoreBoardMenu.sortByScore();
              printScoreBoard(scoreBoardMenu.getAllPlayerNickName());
            }
            else{
                printMessage(Commands.INVALID);
            }

        }
    }

    public void printMessage(Commands message) {
        switch (message) {
            case INVALID: {
                System.out.println("invalid command");
                break;
            }
            case CURRENTMENU: {
                System.out.println("ScoreBoard Menu");
                break;
            }
            default:
                break;
        }
    }

    public void printScoreBoard(ArrayList<String> allPlayerNickname){
        int rank = 0;
        int currentScore = -1;
        if (allPlayerNickname.size()==0){
            System.out.println("we don't have any player...");
        }else {
            for (String nickname:allPlayerNickname) {
                if (currentScore != Player.getScoreByNickname(nickname)){
                    rank++;
                    currentScore = Player.getScoreByNickname(nickname);
                }
                System.out.println(rank + " - " + nickname + Player.getScoreByNickname(nickname) );
            }
        }
    }
    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}