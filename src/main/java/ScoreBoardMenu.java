import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//man nemitoonam testesh konam,chun bayad az mainMenu biam toye in menu...
//first we run bubbleSort on nickNames;after that we run bubble sort on scores;
public class ScoreBoardMenu {
    private static ScoreBoardMenu s = null;
    private ScoreBoardView view;
    private String command;
    private ArrayList<String> allPlayerNickName = Player.getAllNickNames();
    private ScoreBoardMenu(ScoreBoardView view) {
        this.view = view;
    }

    public static ScoreBoardMenu getInstance() {
        if (s == null) {
            ScoreBoardView view = ScoreBoardView.getInstance();
            s = new ScoreBoardMenu(view);
        }
        return s;
    }

    public void run(){
        Matcher matcher;
        sortByNickname();
        sortByScore();
        view.printScoreBoard(allPlayerNickName);
        while(true){
            command = view.scan();
            if ((matcher = getCommandMatcher(command,"menu exit")).find()){
                //mainMenu.run()
                //baad az sakhtan e mainmenu bayad dorostesh konam...
            }else if ((matcher = getCommandMatcher(command,"menu show-current")).find()){
                view.printMessage(ScoreBoardView.Commands.CURRENTMENU);
            }else{
                view.printMessage(ScoreBoardView.Commands.INVALID);
            }
        }
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

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }

}
