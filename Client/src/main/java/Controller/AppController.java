package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*

    IMPORTANT NOTE:
    Clean code practices are not important for "client" code in Question #2
    They are only important for "server" code in Question #2 and also inside "runQ3" in Question #3

 */

public class AppController {

    private static Socket socket;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    public static void setupConnection() {
        try {
            socket = new Socket("localhost", 7776);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getServerOutput(String input) {
         try {
            System.out.println("mmd");
            dataOutputStream.writeUTF(input);
             System.out.println("mmd2");
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();
             System.out.println("mmd3");

            //dataOutputStream.close();
             System.out.println("mmd4");
            //socket.close();
             System.out.println("mmd5");
            return result;
        }catch (IOException ignored) {
            return "SERVER CONNECTION FAILED";
        }
        //return "";
    }

}
