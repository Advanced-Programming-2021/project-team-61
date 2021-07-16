import Controller.RegisterMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("run");
        try {
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
            if (result.equals("")) break;
            dataOutputStream.writeUTF(result);
            dataOutputStream.flush();
        }
    }

    static String process(String command) {
        if (command.startsWith("1."))
            return RegisterMenu.getInstance().checkCommand(command);

        return "";
    }




    ////add other classes and edit process...........
}

