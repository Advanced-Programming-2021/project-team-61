import java.util.regex.Matcher;
import java.util.regex.Pattern;
//we should add a attribute in mainMenu that save username which login,
//after that when we go to each menu,enter with this name...
//for example we need name of player to add a card
public class ShopMenu {

    private static ShopMenu s = null;
    private ShopView view;
    private String command;
    private String name;

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

    public void run(String username){
        name = username;
        Matcher matcher;
        while (true){
            command = view.scan();
            if ((matcher = getCommandMatcher(command,"menu exit")).find()){
                //mainMenu.run()//write username in run()...
                //baad az sakhtan e mainmenu bayad dorostesh konam...
            }else if ((matcher = getCommandMatcher(command,"shop buy ([a-zA-Z]+[a-zA-Z ]*)")).find()){
                buyCard(matcher);
            }else if ((matcher = getCommandMatcher(command,"shop show --all")).find()){
                view.printAllCards();
            }else {
                view.printMessage(ShopView.Commands.INVALID);
            }
        }
    }

    public void buyCard(Matcher matcher){
        //1.check if we have a card with this name
        view.printMessage(ShopView.Commands.WRONGNAME);
        //2.compare the price of card and player coin
        //if don't have enough money
        view.printMessage(ShopView.Commands.ENOUGHMONEY);
        //if has enough money
        //add card    +++   decrease money

    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
