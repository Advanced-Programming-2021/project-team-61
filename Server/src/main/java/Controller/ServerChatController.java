package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerChatController  implements  Runnable{

    private final Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ServerChatController(Socket chatSocket) {
        this.socket = chatSocket;
    }








    @Override
    public void run() {
        try {
            try {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                 getCommand();

            }
            finally {
                socket.close();
                for(int i  = 0; i < ChatRoomMenu.connectedUsers.size();i++){
                    if(ChatRoomMenu.connectedUsers.get(i) == socket)
                        ChatRoomMenu.connectedUsers.remove(i);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void getCommand() throws IOException {
          while (true){
              String command = dataInputStream.readUTF();
              if(command.equals("back"))
                  break;
              processCommand(command);

          }
    }

    private void processCommand(String command) throws IOException {
        if(command.startsWith("send")){
         String[] split = command.split("\\.");
         String username = RegisterMenu.getUsernameByToken(split[2]);
         for(int i = 0; i < ChatRoomMenu.connectedUsers.size(); i++){
           Socket temp = ChatRoomMenu.connectedUsers.get(i);
           DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
           dataOutputStream.writeUTF("receive."+username+": "+split[1]);
         }
        }
        else if(command.startsWith("delete")){
            for(int i = 0; i < ChatRoomMenu.connectedUsers.size();i++){
                Socket temp = ChatRoomMenu.connectedUsers.get(i);
                DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
                dataOutputStream.writeUTF(command);
            }

        }
        else if(command.startsWith("pin")){
            for(int i = 0; i < ChatRoomMenu.connectedUsers.size();i++){
                Socket temp = ChatRoomMenu.connectedUsers.get(i);
                DataOutputStream dataOutputStream  = new DataOutputStream(temp.getOutputStream());
                dataOutputStream.writeUTF(command);
            }
        }
        else if(command.startsWith("edit")){
            String[] split = command.split("\\.");
            String username = RegisterMenu.getUsernameByToken(split[2]);
            for(int i = 0; i < ChatRoomMenu.connectedUsers.size();i++){
                Socket temp = ChatRoomMenu.connectedUsers.get(i);
                DataOutputStream dataOutputStream = new DataOutputStream(temp.getOutputStream());
                dataOutputStream.writeUTF(split[0]+"."+split[1]+"."+username+": "+split[3]);
            }
        }
    }
}
