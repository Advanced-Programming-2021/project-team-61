import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopView {
    enum Commands {
        CurrentMenu,
        WrongName,
        EnoughMoney,
        INVALID
    }

    private static ShopView s = null;
    private ShopMenu shopMenu = ShopMenu.getInstance();
    public static Scanner scanner = new Scanner(System.in);
    private String command;
    private Matcher matcher;

    private ShopView() {

    }

    public static ShopView getInstance() {
        if (s == null)
            s = new ShopView();
        return s;
    }

    public void scan(String username) {
        while (true){
        command = scanner.nextLine();
            if ((matcher = getCommandMatcher(command, "menu exit")).find())
                break;
            else if ((matcher = getCommandMatcher(command, "shop buy ([a-zA-Z]+[a-zA-Z ]*)")).find()){
               shopMenu.buyCard(matcher, Player.getPlayerByUsername(username));
            }
            else if ((matcher = getCommandMatcher(command, "shop show --all")).find())
                printAllCards();
            else if (command.equals("menu show --current"))
                printMessage(Commands.CurrentMenu);
            else
                printMessage(Commands.INVALID);
        }
    }

    public void printMessage(Commands message) {
        switch (message) {
            case CurrentMenu: {
                System.out.println("shop menu");
                break;
            }
            case WrongName: {
                System.out.println("there is no card with this name\n");
                break;
            }
            case EnoughMoney: {
                System.out.println("not enough money\n");
                break;
            }
            case INVALID: {
                System.out.println("invalid command\n");
                break;
            }
            default:
                break;
        }
    }

    public void printAllCards() {
        ArrayList<Card> allCards = Card.getAllCards();
        sort(allCards);
        for (Card allCard : allCards) {
            System.out.print(allCard.getCardName() + ":" + allCard.getPrice() + "\n");
            System.out.println();
        }
    }

    private void sort(ArrayList<Card> allCards) {
        for (int i = 0; i < allCards.size() - 1; i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getCardName().compareTo(allCards.get(j).getCardName()) > 0)
                    Collections.swap(allCards, i, j);
            }
        }
    }
    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
