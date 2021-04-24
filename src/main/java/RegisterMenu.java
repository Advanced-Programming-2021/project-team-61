import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenu {
    private static RegisterMenu r = null;
    private String command;
    private RegisterView view;


    private RegisterMenu(RegisterView view) {
        this.view = view;
    }

    public static RegisterMenu getInstance() {
        if (r == null) {
            RegisterView view = RegisterView.getInstance();
            r = new RegisterMenu(view);
        }
        return r;
    }

    public void run() {
        while (true) {
            int changed = 0;
            command = view.scan();
            if (command.startsWith("user create ")) {
                changed = 1;
                String regex = "user create --username ([^\\s]+) --nickname ([^\\s]+) --password ([^\\s]+)";
                Matcher matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    if (Player.isUserNameExists(matcher.group(1)))
                        view.printMessage(RegisterView.Commands.USEREXISTSWITHUSERNAME, matcher.group(1));
                    else if (Player.isNickNameExists(matcher.group(2)))
                        view.printMessage(RegisterView.Commands.USEREXISTSWITHNICKNAME, matcher.group(2));
                    else {
                        CreatePlayer(matcher.group(1), matcher.group(2), matcher.group(3));
                    }
                }


            }
            if(command.startsWith("user login")){
                changed = 1;
                String regex = "user login --username ([^\\s]+) --password ([^\\s]+)";
                Matcher matcher = getCommandMatcher(command,regex);
                if(matcher.find()){
                    if(!Player.isUserNameExists(matcher.group(1)))
                        view.printMessage(RegisterView.Commands.NOMATCH,"");
                    else if(!Player.getPlayerByUsername(matcher.group(1)).getPassword().equals(matcher.group(2)))
                        view.printMessage(RegisterView.Commands.NOMATCH,"");
                    else{
                        view.printMessage(RegisterView.Commands.LOGIN,"");
                        MainMenu m = MainMenu.getInstance();
                        m.run(matcher.group(1));

                    }
                }
            }
            if(command.equals("menu show-current")){
                changed = 1;
                view.printMessage(RegisterView.Commands.SHOWMENU,"");
            }
            if(command.startsWith("menu enter")){
                changed = 1;
                view.printMessage(RegisterView.Commands.FIRSTLOGIN,"");
            }
            if (command.equals("menu exit") && changed == 0) {
                break;
            }
            if (changed == 0)
                view.printMessage(RegisterView.Commands.INVALID, "");
        }


    }

    private void CreatePlayer(String username, String nickname, String password) {
        new Player(username, nickname, password);
        view.printMessage(RegisterView.Commands.SUCCESSFULL, "");
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
