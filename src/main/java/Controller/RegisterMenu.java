package Controller;

import Model.Player;
import View.LoginPage;
import View.RegisterView;

public class RegisterMenu {
    private static RegisterMenu r = null;
    private RegisterView view;


    private RegisterMenu() {

    }

    public static RegisterMenu getInstance() {
        if (r == null)
            r = new RegisterMenu();
        return r;
    }

    public void userCreateProcess(String username, String nickname, String password) {
        view = RegisterView.getInstance();
        if (Player.isUserNameExists(username))
            view.printMessage(RegisterView.Commands.userExistsWithUsername, username);
        else if (Player.isNickNameExists(nickname))
            view.printMessage(RegisterView.Commands.userExistsWithNickname, nickname);
        else
            CreatePlayer(username, nickname, password);
    }

    public void loginProcess(String username,String password) {
        view = RegisterView.getInstance();
        if (!Player.isUserNameExists(username)) {
            view.printMessage(RegisterView.Commands.noMatch, "");
        } else if (!Player.getPlayerByUsername(username).getPassword().equals(password)){
            view.printMessage(RegisterView.Commands.noMatch, "");
        }else{
            view.printMessage(RegisterView.Commands.LOGIN, "");
            Player.setLoggedPlayer(Player.getPlayerByUsername(username));
            /*MainView m = MainView.getInstance();
            m.scan(username);*/
        }
    }

    private void CreatePlayer(String username, String nickname, String password){
        new Player(username, nickname, password);
        view.printMessage(RegisterView.Commands.successful, "");
    }
}
