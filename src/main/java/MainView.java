import java.util.Scanner;

public class MainView {
    enum Commands {
        LOGOUT,
        INVALID,
        MENUNAME
    }

    private static MainView m = null;

    private MainView(){

    }
    public static MainView getInstance(){
        if(m==null)
            m = new MainView();
        return m;
    }
    public String scan(){
        String command = RegisterView.scanner.nextLine();
        return command;


    }
    public void printMessage(Commands message){
        switch (message){
            case LOGOUT:{
                System.out.println("user logged out successfully!\n");
                break;
            }
            case INVALID:{
                System.out.println("invalid command\n");
                break;
            }
            case MENUNAME:{
                System.out.println("Main Menu\n");
                break;
            }
            default: break;



        }





    }
}
