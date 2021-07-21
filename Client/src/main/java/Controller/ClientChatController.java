package Controller;

import View.ViewManager;

import javax.swing.text.View;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import View.Logic;
import View.ViewManager;

public class ClientChatController implements Runnable {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientChatController(Socket chatSocket) {
        this.socket = chatSocket;
    }








    @Override
    public void run() {
        try{
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.flush();
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
        while(true){
         String message = dataInputStream.readUTF();
         if(message.equals("back"))
             break;
         processMessage(message);
        }
    }

    private void processMessage(String message) {
        System.out.println("entered");
        if(message.startsWith("receive")){
            String[] split = message.split("\\.");
            ViewManager.getChatRoomPage().chatBox.appendText(split[1]+"\n");


        }
        else if(message.startsWith("delete")){
            String[] split = message.split("\\.");
            int number = Integer.parseInt(split[1]);
            String messages = ViewManager.getChatRoomPage().chatBox.getText();
            String[] splitted = messages.split("\n");
            String temp = messages;
            String line = splitted[number - 1];
            int startIndex = 0;
            for(int i = 1; i < number; i++){
              startIndex = temp.indexOf('\n')  + 1;
              temp = temp.substring(startIndex);
            }

            int endIndex = startIndex + line.length() + 1;
            System.out.println(endIndex);
            ViewManager.getChatRoomPage().chatBox.deleteText(startIndex,endIndex);
        }
        else if(message.startsWith("pin")){
            String[] split = message.split("\\.");
            int number = Integer.parseInt(split[1]);
            String[] splitted = ViewManager.getChatRoomPage().chatBox.getText().split("\n");
            String line = splitted[number - 1];
            ViewManager.getChatRoomPage().pinBar.setText(line);
        }
        else if(message.startsWith("edit")){
            String[] split = message.split("\\.");
            int number = Integer.parseInt(split[1]);
            String messages = ViewManager.getChatRoomPage().chatBox.getText();
            String[] splitted = messages.split("\n");
            ViewManager.getChatRoomPage().chatBox.clear();
            splitted[number - 1] = split[2];
            for(int i = 0 ; i < splitted.length; i++){
                ViewManager.getChatRoomPage().chatBox.appendText(splitted[i]+"\n");
            }

        }
    }
    public void send(String message) throws IOException {
        System.out.println(message);
      dataOutputStream.writeUTF("send."+message);
      dataOutputStream.flush();
      ViewManager.getChatRoomPage().messageTextBar.setText(null);
    }
    public void delete(String message) throws IOException {
        dataOutputStream.writeUTF("delete."+message);
        dataOutputStream.flush();
        ViewManager.getChatRoomPage().additionField.setText(null);
    }

    public void pin(String text) throws IOException {
        dataOutputStream.writeUTF("pin."+text);
        dataOutputStream.flush();
        ViewManager.getChatRoomPage().additionField.setText(null);
    }

    public void edit(String s) throws IOException {
        dataOutputStream.writeUTF("edit."+s);
        dataOutputStream.flush();
        ViewManager.getChatRoomPage().additionField.setText(null);
        ViewManager.getChatRoomPage().messageTextBar.setText(null);
    }

    public void back() throws IOException {
        dataOutputStream.writeUTF("back");
        dataOutputStream.flush();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");

    }
}
