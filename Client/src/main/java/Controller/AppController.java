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
    private static String token;

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
            dataOutputStream.writeUTF(input);
            dataOutputStream.flush();
            String result = dataInputStream.readUTF();


            //dataOutputStream.close();
            //socket.close();

            return result;
        }catch (IOException ignored) {
            return "SERVER CONNECTION FAILED";
        }
        //return "";
    }

    public static void setToken(String token) {
        AppController.token = token;
    }

    public static String getToken() {
        return token;
    }

    public static void chatRequest(String message) throws IOException {
        dataOutputStream.writeUTF(message);
        dataOutputStream.flush();
    }
}
