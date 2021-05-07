import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoardView {
    enum Commands {
        CURRENTMENU,
        INVALID
    }

    private static ScoreBoardView s = null;
    public static Scanner scanner = new Scanner(System.in);

    private ScoreBoardView() {
    }

    public static ScoreBoardView getInstance() {
        if (s == null)
            s = new ScoreBoardView();
        return s;
    }

    public String scan() {
        String command = scanner.nextLine();
        return command;
    }

    public void printMessage(Commands message) {
        switch (message) {
            case INVALID: {
                System.out.println("invalid command\n");
                break;
            }
            case CURRENTMENU: {
                System.out.println("ScoreBoard Menu\n");
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
            System.out.println("we don't have any player...\n");
        }else {
            for (String nickname:allPlayerNickname) {
                if (currentScore != Player.getScoreByNickname(nickname)){
                    rank++;
                    currentScore = Player.getScoreByNickname(nickname);
                }
                System.out.println(rank + "-" + nickname + Player.getScoreByNickname(nickname) + "\n");
            }
        }
    }
}