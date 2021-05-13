import java.util.regex.Matcher;

public class RegisterMenu {
    private static RegisterMenu r = null;
    private RegisterView view = RegisterView.getInstance();


    private RegisterMenu() {

    }

    public static RegisterMenu getInstance() {
        if (r == null)
            r = new RegisterMenu();
        return r;
    }

    public void userCreateProcess(Matcher matcher) {
        if (Player.isUserNameExists(matcher.group(1)))
            view.printMessage(RegisterView.Commands.userExistsWithUsername, matcher.group(1));
        else if (Player.isNickNameExists(matcher.group(2)))
            view.printMessage(RegisterView.Commands.userExistsWithNickname, matcher.group(2));
        else
            CreatePlayer(matcher.group(1), matcher.group(2), matcher.group(3));
    }

    public void loginProcess(Matcher matcher) {
        if (!Player.isUserNameExists(matcher.group(1)))
            view.printMessage(RegisterView.Commands.noMatch, "");
        else if (!Player.getPlayerByUsername(matcher.group(1)).getPassword().equals(matcher.group(2)))
            view.printMessage(RegisterView.Commands.noMatch, "");
        else {
            view.printMessage(RegisterView.Commands.LOGIN, "");
            MainView m = MainView.getInstance();
            m.scan(matcher.group(1));


        }
    }

    private void CreatePlayer(String username, String nickname, String password){
        new Player(username, nickname, password);
        view.printMessage(RegisterView.Commands.successful, "");
    }
}
