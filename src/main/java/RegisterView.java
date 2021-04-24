import java.util.Scanner;

public class RegisterView {
    enum Commands{
        SUCCESSFULL,
        USEREXISTSWITHNICKNAME,
        USEREXISTSWITHUSERNAME,
        INVALID,
        SHOWMENU,
        FIRSTLOGIN

    }
    private static RegisterView r = null;
    public static Scanner scanner = new Scanner(System.in);
    private RegisterView(){

    }
    public static RegisterView getInstance(){
        if(r== null)
            r = new RegisterView();
        return r;
    }
    public String scan(){
        String command = scanner.nextLine();
        return command;
    }
    public void printMessage(Commands message , String s){
        switch (message){
            case SUCCESSFULL :{
                System.out.println("user created successfully!");
                break;
            }
            case USEREXISTSWITHNICKNAME :{
                System.out.println("user with nickname "+s+" already exists");
                break;
            }
            case  USEREXISTSWITHUSERNAME :{
                System.out.println("user with username "+s+" already exists");
                break;
            }
            case INVALID : {
                System.out.println("invalid command");
            }
            case SHOWMENU:{
                System.out.println("Login Menu");
            }
            case FIRSTLOGIN:{
                System.out.println("please login first");
            }
            default: break;
        }
    }
}
