import java.util.ArrayList;
import java.util.Collections;
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
            case CURRENTMENU: {
                System.out.println("shop menu");
                break;
            }
            case WRONGNAME: {
                System.out.println("there is no card with this name\n");
                break;
            }
            case ENOUGHMONEY: {
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
            System.out.print(allCard.getCardName() + ":" + allCard.getPrice());
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
}
