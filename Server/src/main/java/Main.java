import Controller.ChatRoomMenu;
import Controller.RegisterMenu;
import Controller.ScoreBoardController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        runApp();
    }



    private static boolean inChatRoom = false;

    private static void runApp() {
        System.out.println("run");
        try {
            ChatRoomMenu.getInstance().setChatServerSocket(new ServerSocket(7777));
            ServerSocket serverSocket = new ServerSocket(7776);
            while (true) {
                Socket socket = serverSocket.accept();
                startNewThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startNewThread(Socket socket) {
        new Thread(() -> {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                getInputAndProcess(dataInputStream, dataOutputStream);
                dataInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void getInputAndProcess(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        while (true) {
            String input = dataInputStream.readUTF();
            String result = process(input);
            if (result.equals("") && !inChatRoom) break;
            inChatRoom = false;
            dataOutputStream.writeUTF(result);
            dataOutputStream.flush();
        }
    }

    static String process(String command) throws IOException {
        if (command.startsWith("1."))
            return RegisterMenu.getInstance().checkCommand(command);
        if(command.equals("loaddata")){
            inChatRoom = true;
           // return ChatRoomMenu.getMessages();

        }
        if(command.equals("enter chat")){
            ChatRoomMenu.getInstance().runChatRoom();}
        if(command.contains("give")){
            String[] split = command.split("\\s");
            return RegisterMenu.getUsernameByToken(split[1]);
        }
        if(command.contains("save message")){
            String[] split = command.split("\\-");
          //  ChatRoomMenu.saveMessage(split[1]);
            return "OK!";
        }

        if (command.startsWith("5."))
            return ScoreBoardController.getInstance().checkCommand(command);
        return "";
    }
    public static boolean isInChatRoom() {
        return inChatRoom;
    }

    public static void setInChatRoom(boolean inChatRoom) {
        Main.inChatRoom = inChatRoom;
    }




    ////add other classes and edit process...........
}

