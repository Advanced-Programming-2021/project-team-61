import Controller.*;
import Model.Database;
import Model.Deck;
import Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProjectTest {

    @Test
    public void testUserCreateProcess(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        RegisterMenu menu = RegisterMenu.getInstance();
        Player player = new Player("alirez","ali","1234");
        String command = "user create --u alireza --n ali --p 1234";
        String regex = "user create --u ([^\\s]+) --n ([^\\s]+) --p ([^\\s]+)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(command);
        if(m.find()){
         menu.userCreateProcess(m);
         Assertions.assertEquals("user with nickname ali already exists\r\n",outContent.toString());
        }
    }
    @Test
    public void testMenuEnter(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        MainMenu mainMenu = MainMenu.getInstance();
        mainMenu.menuEnter("Duel","");
        Assertions.assertEquals("yes!\r\n",outContent.toString());



    }
    @Test
    public void testProfileMenu(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ProfileMenu p = ProfileMenu.getInstance();
        Player player = new Player("alireza","alirezaert","1234");
        Player player1 = new Player("alireza","ali","1234");
        String command = "profile change --nickname ali";
        String regex = "profile change --nickname ([^\\s]+)";
        Pattern x = Pattern.compile(regex);
        Matcher m = x.matcher(command);
        if(m.find())
        p.changeNickname(player,m);
        Assertions.assertEquals("user with nickname ali already exists\r\n",outContent.toString());
    }
    @Test
    public void testDeckMenu(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        File f = new File("src\\main\\resources\\Monster.csv");
        String absolute = f.getAbsolutePath();
        File f2 = new File("src\\main\\resources\\SpellTrap.csv");
        String absolute2 = f2.getAbsolutePath();
        Database.readDataLineByLine(absolute, absolute2);
        DeckMenu deckMenu = DeckMenu.getInstance();
        String command2 ="shop buy Black Pendant";
        String regex2 = "shop buy ([a-zA-Z]+[a-zA-Z ]*)";
        Pattern x1 = Pattern.compile(regex2);
        Matcher m1 = x1.matcher(command2);
        Player player = new Player("alireza","alirezaert","1234");
        ShopMenu shopMenu = ShopMenu.getInstance();
        if(m1.find())
        shopMenu.buyCard(m1,player);
        Deck deck = new Deck("ali reza","alireza");
        String command = "deck add-card --card Black Pendant --deck ali reza";


        String regex = "^deck add-card --card ([a-zA-Z\\s]+) --deck ([a-zA-Z\\s]+)( --side)?$";
        Pattern x = Pattern.compile(regex);
        Matcher m = x.matcher(command);
        if(m.find())
            deckMenu.addCardToMainDeck(m.group(1),m.group(2),player);
            Assertions.assertEquals("card added to deck successfully\r\n",outContent.toString());




    }






}