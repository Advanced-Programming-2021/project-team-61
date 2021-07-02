/*package Controller;

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
    public  ArrayList<String> getAllPlayerNickName() {
        return allPlayerNickName;
    }
}
*/