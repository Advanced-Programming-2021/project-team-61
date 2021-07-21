package View;

import Controller.AppController;
import Model.Card;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//import javax.swing.*;
//import java.awt.*;
//import javax.swing.*;
import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ShopClientController implements Runnable{


    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ShopClientController(Socket shopSocket) {
        this.socket = shopSocket;
    }

    @Override
    public void run() {
        try {
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                getCommands();

            }
            finally {
                socket.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void getCommands() throws IOException {
        while (true){
            String message = dataInputStream.readUTF();
            if(message.equals("back"))
                break;
            processMessage(message);
        }
    }

    private void processMessage(String message) {
        if(message.startsWith("success")){
            String[] split = message.split("\\#");
            handleSuccessfulBuy(split[1],split[2]);
        }
         else {
             if(message.startsWith("increase")){
              String[] split = message.split("\\#");
              Label label = ViewManager.getShopPage().getLabelByCardName(split[1]);
              label.setText(String.valueOf(Integer.parseInt(label.getText())) + 1);
            }
            else {
                 if(message.startsWith("decrease")){
                     String[] split = message.split("\\#");
                     Label label = ViewManager.getShopPage().getLabelByCardName(split[1]);
                     int x = Integer.parseInt(label.getText());
                     label.setText(String.valueOf(x - 1));
                 }

             }
         }
    }

    private void handleSuccessfulBuy(String cardName,String token) {
       if(token.equals(AppController.getToken())){
         String t =  ViewManager.getShopPage().availableCoin.getText();
         int x = Card.getCardByName(cardName).getPrice();
         int y = Integer.parseInt(t);
         ViewManager.getShopPage().availableCoin.setText(String.valueOf(y - x));
       }
       Label label = ViewManager.getShopPage().getLabelByCardName(cardName);
       int x = Integer.parseInt(label.getText());
       label.setText(String.valueOf(x - 1));

    }


    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeUTF(message);

    }

    public int getCoins(String s) throws IOException {
        dataOutputStream.writeUTF(s);
       return (Integer.parseInt(dataInputStream.readUTF()));
    }
    public void sendIncreaseCard(String cardName) throws IOException {
        dataOutputStream.writeUTF("increase card#"+cardName);
    }
}
