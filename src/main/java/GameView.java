import java.util.Scanner;

public class GameView {

    enum Command{

    }

    private Scanner scanner = RegisterView.scanner;
    private static GameView g = null;

    private GameView(){

    }
    public static GameView getInstance(){
        if(g == null)
            g = new GameView();
        return g;
    }
    public String scan(){
        String command = scanner.nextLine();
        return command;
    }
    public void printMessage(Command message){

    }

}
