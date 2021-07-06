package Controller;

import Model.Card;
import Model.Player;

//we should add a attribute in mainMenu that save username which login,
//after that when we go to each menu,enter with this name...
//for example we need name of player to add a card
public class ShopMenu {

    private static ShopMenu s = null;

    private ShopMenu() {

    }

    public static ShopMenu getInstance() {
        if (s == null)
            s = new ShopMenu();
        return s;
    }

   /* public void buyCard(Matcher matcher, Player player) {
        view = ShopView.getInstance();
        if (!Card.isCardAvailable(matcher.group(1)))
            view.printMessage(ShopView.Commands.WrongName);
        else if (Card.getCardByName(matcher.group(1)).getPrice() > player.getCoin())
            view.printMessage(ShopView.Commands.EnoughMoney);
        else {
            player.buyCard(Card.getCardByName(matcher.group(1)));
        }
    }*/
    public boolean isMoneyEnough(String cardName,Player player){
        return player.getCoin() >= Card.getCardByName(cardName).getPrice();

    }
    public void buyCard(String cardName,Player player){
        player.addCard(Card.getCardByName(cardName));
    }

}
