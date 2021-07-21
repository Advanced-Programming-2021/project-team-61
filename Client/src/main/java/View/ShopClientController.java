package View;

import java.net.Socket;

public class ShopClientController implements Runnable{


    private Socket socket;

    public ShopClientController(Socket shopSocket) {
        this.socket = shopSocket;
    }

    @Override
    public void run() {

    }







    public void sendMessage(String message){

    }
}
