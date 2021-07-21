package Controller;

import Model.Player;
//import View.MainView;
//import View.RegisterView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenu {
    private static RegisterMenu r = null;
    //private RegisterView view;
    private Matcher matcher;
    private static HashMap<String,Player> loggedinUsers = new HashMap<>();


    private RegisterMenu() {

    }

    public static RegisterMenu getInstance() {
        if (r == null)
            r = new RegisterMenu();
        return r;
    }

    public String checkCommand(String st){
        if ((matcher = getCommandMatcher(st, "1.sign ([^\\s]+) ([^\\s]+) ([^\\s]+)")).find())
            return userCreateProcess(matcher);
        else if ((matcher = getCommandMatcher(st, "1.login ([^\\s]+) ([^\\s]+)")).find())
            return loginProcess(matcher);
        return "invalid";
    }

    public String userCreateProcess(Matcher matcher) {
        //view = RegisterView.getInstance();
        if (Player.isUserNameExists(matcher.group(1)))
            //view.printMessage(RegisterView.Commands.userExistsWithUsername, matcher.group(1));
            return "user with username " + matcher.group(1) + " already exists";
        else if (Player.isNickNameExists(matcher.group(2)))
            //view.printMessage(RegisterView.Commands.userExistsWithNickname, matcher.group(2));
            return  "user with nickname " + matcher.group(2) + " already exists";
        else {
            CreatePlayer(matcher.group(1), matcher.group(2), matcher.group(3));
            Player.addLoggedPlayer(matcher.group(2));
            return "success";
        }
    }

    public String  loginProcess(Matcher matcher) {
        //view = RegisterView.getInstance();
        if (!Player.isUserNameExists(matcher.group(1)))
            //view.printMessage(RegisterView.Commands.noMatch, "");
            return "Username and password didn't match!";
        else if (!Player.getPlayerByUsername(matcher.group(1)).getPassword().equals(matcher.group(2)))
            //view.printMessage(RegisterView.Commands.noMatch, "");
            return "Username and password didn't match!";
        else{
            String token = UUID.randomUUID().toString();
            loggedinUsers.put(token,Player.getPlayerByUsername(matcher.group(1)));
            Player.addLoggedPlayer(Player.getPlayerByUsername(matcher.group(1)).getNickname());

            return "success"+" "+token;

        }
    }

    private void CreatePlayer(String username, String nickname, String password){
        new Player(username, nickname, password);
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
    public static String getUsernameByToken(String token){
        for(Map.Entry loggedInUser : loggedinUsers.entrySet()){
            if(loggedInUser.getKey().equals(token)){
                Player p = (Player) loggedInUser.getValue();
                return p.getUsername();
            }
        }
        return null;
    }
}