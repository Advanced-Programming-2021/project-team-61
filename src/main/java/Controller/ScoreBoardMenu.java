package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.Collections;


//first we run bubbleSort on nickNames;after that we run bubble sort on scores;
public class ScoreBoardMenu {
    private static ScoreBoardMenu s = null;
    private ArrayList<String> allPlayerNickName = Player.getAllNickNames();
    private ScoreBoardMenu() {
    }

    public static ScoreBoardMenu getInstance() {
        if (s == null)
            s = new ScoreBoardMenu();
        return s;
    }

    public void sortByNickname(){
        Collections.sort(allPlayerNickName);
    }

    public void sortByScore(){
        int n = allPlayerNickName.size();
        for (int i=0;i<n;i++){
            for (int j=1;j<(n-1);j++){
                if (Player.getScoreByNickname(allPlayerNickName.get(j - 1)) < Player.getScoreByNickname(allPlayerNickName.get(j))){
                    Collections.swap(allPlayerNickName , (j-1) , j);
                }
            }
        }
    }

    public String printScoreBoard(){
        int rank = 0;
        int currentScore = -1;
        StringBuilder s = new StringBuilder();
        if (allPlayerNickName.size()==0){
            //System.out.println("we don't have any player...");
            s.append("we don't have any player...");
        }else {
            for (String nickname:allPlayerNickName) {
                if (currentScore != Player.getScoreByNickname(nickname)){
                    rank++;
                    currentScore = Player.getScoreByNickname(nickname);
                }
                s.append(rank).append(" - ").append(nickname).append(Player.getScoreByNickname(nickname)).append("\n");
                //System.out.println(rank + " - " + nickname + Player.getScoreByNickname(nickname) );
            }
        }
        return s.toString();
    }
    public  ArrayList<String> getAllPlayerNickName() {
        return allPlayerNickName;
    }
}
