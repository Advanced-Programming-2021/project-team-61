import java.util.Scanner;

public class ShopView {
    enum Commands {
        CURRENTMENU,
        WRONGNAME,
        ENOUGHMONEY,
        INVALID
    }

    private static ShopView s = null;
    public static Scanner scanner = new Scanner(System.in);

    private ShopView() {
    }

    public static ShopView getInstance() {
        if (s == null)
            s = new ShopView();
        return s;
    }

    public String scan() {
        String command = scanner.nextLine();
        return command;
    }

    public void printMessage(Commands message) {
        switch (message) {
            case CURRENTMENU:{
                System.out.println("shop menu");
                break;
            }
            case WRONGNAME:{
                System.out.println("there is no card with this name\n");
                break;
            }
            case ENOUGHMONEY:{
                System.out.println("not enough money\n");
                break;
            }
            case INVALID:{
                System.out.println("invalid command\n");
                break;
            }
            default:
                break;
        }
    }

    public void printAllCards(){
        // we should have a foreach and print allCards...
    }
}
