import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test

    public void testCreateUser(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        RegisterMenu menu = RegisterMenu.getInstance();
        menu.CreatePlayer("alireza","ali","1234");
        Assertions.assertEquals("user created successfully!",outContent.toString());




    }

}