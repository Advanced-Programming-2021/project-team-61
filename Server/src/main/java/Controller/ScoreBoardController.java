package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoardController {
    //first we run bubbleSort on nickNames;after that we run bubble sort on scores;
    private static ScoreBoardController s = null;
    private ArrayList<String> allPlayerNickName ;
    private ScoreBoardController() {
    }

    public static ScoreBoardController getInstance() {
        if (s == null)
            s = new ScoreBoardController();
        return s;
    }

    public void sortByNickname(){
        allPlayerNickName = Player.getAllNickNames();
        allPlayerNickName.remove("AI");
        Collections.sort(allPlayerNickName);
    }

    public void sortByScore(){
        int n = allPlayerNickName.size();
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (Player.getScoreByNickname(allPlayerNickName.get(j)) < Player.getScoreByNickname(allPlayerNickName.get(j+1))){
                    Collections.swap(allPlayerNickName , j , j+1);
                }
            }
        }
    }


    public String getNick(){
        sortByNickname();
        sortByScore();
        StringBuilder s = new StringBuilder();
        for (String st:allPlayerNickName) {
            s.append(st + "#");
        }
        return s.toString();
    }

    public String getScore(){
        sortByNickname();
        sortByScore();
        StringBuilder s = new StringBuilder();
        for (String st:allPlayerNickName) {
            s.append(Player.getScoreByNickname(st) + "#");
        }
        return s.toString();
    }

    public String checkCommand(String command){
        switch (command) {
            case "5.nickname":
                return getNick();
            case "5.score":
                return getScore();
            case "5.online":
                return Player.getLoggedPlayers();
            default:
                return "invalid";
        }
    }

}
