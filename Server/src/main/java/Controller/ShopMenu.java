package Controller;

import Model.Card;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ShopMenu {

    private ServerSocket shopServerSocket;
    private Socket shopSocket;
    public static ArrayList<Socket> connectedUsers = new ArrayList<>();
    private static ShopMenu shopMenu = null;


    private ShopMenu(){

    }
    public static ShopMenu getInstance(){
        if(shopMenu == null)
            shopMenu = new ShopMenu();
        return shopMenu;
    }

    public void runShopMenu() throws IOException {
        while (true){
            shopSocket = shopServerSocket.accept();
            connectedUsers.add(shopSocket);
            ShopServerController shopServerController = new ShopServerController(shopSocket);
            Thread thread = new Thread(shopServerController);
            thread.start();







        }





    }
    public static void updateData(String cardName){
        Card.getCardByName(cardName).decreaseNumberOfCards();
    }
    public void setShopServerSocket(ServerSocket socket){
        this.shopServerSocket = socket;
    }

}
