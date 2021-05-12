import java.util.regex.Matcher;

public class RegisterMenu {
    private static RegisterMenu r = null;
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
            MainMenu m = MainMenu.getInstance();
            m.run(matcher.group(1));

        }
    }

    private void CreatePlayer(String username, String nickname, String password){
        new Player(username, nickname, password);
        view.printMessage(RegisterView.Commands.successful, "");
    }
}
