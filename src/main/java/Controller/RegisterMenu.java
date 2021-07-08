package Controller;

import Model.Player;
import View.Logic;
import View.LoginPage;
import View.RegisterView;

import java.io.IOException;

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

    public void userCreateProcess(String username, String nickname, String password) throws IOException {
        view = RegisterView.getInstance();
        if (Player.isUserNameExists(username)) {
            view.printMessage(RegisterView.Commands.userExistsWithUsername, username);
            Logic.viewManager.changeScene("/sample/signupPage.fxml");
        } else if (Player.isNickNameExists(nickname)){
            view.printMessage(RegisterView.Commands.userExistsWithNickname, nickname);
            Logic.viewManager.changeScene("/sample/signupPage.fxml");
        }
        else
            CreatePlayer(username, nickname, password);
    }

    public void loginProcess(String username,String password) throws IOException {
        view = RegisterView.getInstance();
        if (!Player.isUserNameExists(username)) {
            view.printMessage(RegisterView.Commands.noMatch, "");
            Logic.viewManager.changeScene("/sample/loginPage.fxml");
        } else if (!Player.getPlayerByUsername(username).getPassword().equals(password)){
            view.printMessage(RegisterView.Commands.noMatch, "");
            Logic.viewManager.changeScene("/sample/loginPage.fxml");
        }else{
            view.printMessage(RegisterView.Commands.LOGIN, "");
            Player.setLoggedPlayer(Player.getPlayerByUsername(username));
            Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
        }
    }

    private void CreatePlayer(String username, String nickname, String password) throws IOException {
        new Player(username, nickname, password);
        view.printMessage(RegisterView.Commands.successful, "");
        Player.setLoggedPlayer(Player.getPlayerByUsername(username));
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }
}
