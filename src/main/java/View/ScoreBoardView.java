package View;
import Model.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoardView {

    private static ScoreBoardView s = null;
    public static Scanner scanner = new Scanner(System.in);

    private ScoreBoardView() {
    }

    public static ScoreBoardView getInstance() {
        if (s == null)
            s = new ScoreBoardView();
        return s;
    }

    public String printScoreBoard(ArrayList<String> allPlayerNickname){
        int rank = 0;
        int currentScore = -1;
        StringBuilder s = new StringBuilder();
        if (allPlayerNickname.size()==0){
            //System.out.println("we don't have any player...");
            s.append("we don't have any player...");
        }else {
            for (String nickname:allPlayerNickname) {
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
}