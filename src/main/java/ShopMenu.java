import java.util.regex.Matcher;
import java.util.regex.Pattern;

//we should add a attribute in mainMenu that save username which login,
//after that when we go to each menu,enter with this name...
//for example we need name of player to add a card
public class ShopMenu {

    private static ShopMenu s = null;
    private ShopView view;
    private String command;

    private ShopMenu(ShopView view) {
        this.view = view;
    }

    public static ShopMenu getInstance() {
        if (s == null) {
            ShopView view = ShopView.getInstance();
            s = new ShopMenu(view);
        }
        return s;
    }

    public void run(String username) {
        Matcher matcher;
        while (true) {
            command = view.scan();
            if ((matcher = getCommandMatcher(command, "menu exit")).find()) {
                break;
            } else if ((matcher = getCommandMatcher(command, "shop buy ([a-zA-Z]+[a-zA-Z ]*)")).find()) {
                buyCard(matcher, Player.getPlayerByUsername(username));
            } else if ((matcher = getCommandMatcher(command, "shop show --all")).find()) {
                view.printAllCards();
            } else if (command.equals("menu show --current"))
                view.printMessage(ShopView.Commands.CURRENTMENU);
            else {
                view.printMessage(ShopView.Commands.INVALID);
            }
        }
    }

    public void buyCard(Matcher matcher, Player player) {
        if (!Card.isCardAvailable(matcher.group(1)))
            view.printMessage(ShopView.Commands.WRONGNAME);
        else if (Card.getCardByName(matcher.group(1)).getPrice() > player.getCoin())
            view.printMessage(ShopView.Commands.ENOUGHMONEY);
        else {
            player.buyCard(Card.getCardByName(matcher.group(1)));
        }

    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
