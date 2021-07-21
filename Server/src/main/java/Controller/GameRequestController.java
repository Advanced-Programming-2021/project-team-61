package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameRequestController {

    private static GameRequestController g = null;
    private GameRequestController() {
    }
    public static GameRequestController getInstance() {
        if (g == null)
            g = new GameRequestController();
        return g;
    }

    private static HashMap<Integer,String> usernameOfPlayers = new HashMap<>();//round,username//it should refresh after logout...
    private Matcher matcher;


    public String checkCommand(String command){
        if ((matcher = getCommandMatcher(command, "6.send (\\d+) ([^\\s]+)")).find()) {
            if (!usernameOfPlayers.containsKey((Integer.parseInt(matcher.group(1))))) {
                usernameOfPlayers.put(Integer.parseInt(matcher.group(1)),matcher.group(2));
                return "success";
            }
            else {
                String player = usernameOfPlayers.get(Integer.parseInt(matcher.group(1)));
                usernameOfPlayers.remove(Integer.parseInt(matcher.group(1)));
                return player;
            }
        }else if ((matcher = getCommandMatcher(command, "6.cancel (\\d+) ([^\\s]+)")).find()) {
            if (usernameOfPlayers.containsKey((Integer.parseInt(matcher.group(1))))){
                usernameOfPlayers.remove(Integer.parseInt(matcher.group(1)));
                return "success";
            }
            else {
                return "you didn't send a request...";
            }
        }
        return null;
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
