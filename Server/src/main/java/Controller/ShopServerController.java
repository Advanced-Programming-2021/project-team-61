package Controller;

import Model.Card;
import Model.Player;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ShopServerController implements Runnable{


    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ShopServerController(Socket shopSocket) {
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
            processCommand(message);
        }
    }

    private void processCommand(String message) throws IOException {
        if(message.startsWith("buy")){
            String[] split = message.split("\\#");
            handleBuy(split[1],split[2]);
        }
        else if(message.startsWith("increase")){
            String[] split = message.split("\\#");
            Card.getCardByName(split[1]).increaseNumberOfCards();
            for(int i = 0; i < ChatRoomMenu.connectedUsers.size();i++){
                Socket temp = ChatRoomMenu.connectedUsers.get(i);
                DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
                dataOutputStream.writeUTF("increase#"+split[1]);
            }

        }
    }

    private void handleBuy(String cardName, String token) throws IOException {
        String username = RegisterMenu.getUsernameByToken(token);
        Player player = Player.getPlayerByUsername(username);
        player.buyCard(Card.getCardByName(cardName));
        ShopMenu.updateData(cardName);
        for(int i = 0; i < ChatRoomMenu.connectedUsers.size();i++){
            Socket temp = ChatRoomMenu.connectedUsers.get(i);
            DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
            dataOutputStream.writeUTF("success#"+cardName+"#"+token);
        }



    }

}
