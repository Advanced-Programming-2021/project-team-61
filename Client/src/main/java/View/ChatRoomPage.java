package View;

import Controller.AppController;
import Controller.ClientChatController;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class ChatRoomPage implements Initializable {

    public TextField messageTextBar;
    public TextArea chatBox;
    public TextField additionField;
    public TextField pinBar;
    private ClientChatController controller;


    private static Socket chatSocket;



    @FXML
    void sendMessage(ActionEvent event) throws IOException {
        System.out.println(messageTextBar.getText());
        controller.send(messageTextBar.getText()+"."+AppController.getToken());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            chatSocket = new Socket("localhost", 7777);
            controller = new ClientChatController(chatSocket);
            Thread thread = new Thread(controller);
            thread.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteMessage(ActionEvent actionEvent) throws IOException {
        controller.delete(additionField.getText());
    }

    public void pinMessage(ActionEvent actionEvent) throws IOException {
        controller.pin(additionField.getText());
    }

    public void editMessage(ActionEvent actionEvent) throws IOException {
        controller.edit(additionField.getText()+"."+AppController.getToken()+"."+messageTextBar.getText());
    }

    public void back(ActionEvent actionEvent) throws IOException {
          controller.back();
   }
 /*   public void pinMessage(ActionEvent actionEvent) {
        int number = Integer.parseInt(numberChooseText.getText());
        String[] split = texts[20 - number].getText().split("\\:");
        pinTextBar.setText(split[1]);

    }

    public void deleteMessage(ActionEvent actionEvent) {
        int number = Integer.parseInt(numberChooseText.getText());
        messages.remove(messages.get(messages.size() - number));
        texts[20 - number].setText(null);
        clearPage(number);
        scrollPage();
    }

    private void clearPage(int number) {
        for(int i = 19 - number; i >=0;i--){
            if(texts[i].getText()!= null)
                texts[i].setText(null);
        }
    }

    private void scrollPage() {
        int x = 0;
        for(int i = messages.size() - 1; i >=0;i--){
            texts[19 - x].setText(messages.get(i));
            x++;
        }
    }

    public void editMessage(ActionEvent actionEvent) {
        int number = Integer.parseInt(numberChooseText.getText());
        String username = AppController.getServerOutput("giveusername " + AppController.getToken());
        texts[20 - number].setText(username + ": " + textMessageBar.getText());
        textMessageBar.setText(null);
    }

    public void backToMainMenu(ActionEvent actionEvent) {
    }*/
}
