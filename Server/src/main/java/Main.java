import Controller.*;
import Model.Database;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        File f = new File("src\\main\\resources\\Monster.csv");
        String absolute = f.getAbsolutePath();
        File f2 = new File("src\\main\\resources\\SpellTrap.csv");
        String absolute2 = f2.getAbsolutePath();
        Database.readDataLineByLine(absolute, absolute2);
        Database.setupForTest();
        runApp();
    }



    private static boolean inChatRoom = false;

    private static void runApp() {
        System.out.println("run");
        try {
            ChatRoomMenu.getInstance().setChatServerSocket(new ServerSocket(7777));
            ShopMenu.getInstance().setShopServerSocket(new ServerSocket(7778));
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
        if (command.startsWith("6."))
            return GameRequestController.getInstance().checkCommand(command);
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

