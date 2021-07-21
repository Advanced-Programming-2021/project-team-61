package Controller;

import Model.Player;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomMenu {

  // private  ArrayList<String> messages = new ArrayList<>();
   private  ServerSocket chatServerSocket;
   private  Socket chatSocket;
  // private  ArrayList<String> tokens = new ArrayList<>();
   private static ChatRoomMenu c = null;
   public static ArrayList<Socket> connectedUsers = new ArrayList<>();
   public static ArrayList<String> usernames = new ArrayList<>();


    private ChatRoomMenu(){

   }
   public static ChatRoomMenu getInstance(){
        if(c == null)
            c = new ChatRoomMenu();
        return c;
 }

   public void runChatRoom() throws IOException {

        while (true){
            chatSocket = chatServerSocket.accept();
            System.out.println("accepted client");
           // startChatThread(chatSocket);
            connectedUsers.add(chatSocket);
            ServerChatController controller = new ServerChatController(chatSocket);
            Thread thread = new Thread(controller);
            thread.start();



        }


   }

    public void setChatServerSocket(ServerSocket chatServerSocket) {
        this.chatServerSocket = chatServerSocket;
    }

    private void startChatThread(Socket chatSocket) {
        new Thread(()->{
            try {
                System.out.println("entered");
                DataInputStream dataInputStream = new DataInputStream(chatSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(chatSocket.getOutputStream());
               // receiveRequest(dataInputStream,dataOutputStream);
                dataInputStream.close();
                chatSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

   /* private void receiveRequest(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        String request = "hello";
        while (!request.equals("back")){
            request = dataInputStream.readUTF();
            if(request.startsWith("send")){
                processSend(request,dataOutputStream);

            }
        }
    }

    private void processSend(String request,DataOutputStream dataOutputStream) throws IOException {
        String[] split = request.split("\\.");
        String username = RegisterMenu.getUsernameByToken(split[2]);
        tokens.add(split[2]);
        for(String token : tokens){
            dataOutputStream.writeUTF(username+": "+split[1]);
        }

    }

    public void saveMessage(String message){
       messages.add(message);
   }
   public String getMessages(){
       StringBuilder stringBuilder = new StringBuilder();
       for(String message : messages){
           stringBuilder.append(message+"-");
       }
       return stringBuilder.toString();
   }*/


}
