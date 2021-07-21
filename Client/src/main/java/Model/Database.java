package Model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<String[]> MonsterCardsInformation = new ArrayList<>();
    private static List<String[]> SpellAndTrapInformation = new ArrayList<>();

    public static void readDataLineByLine(String monsterFile, String spellAndTrapFile) {
        try {
            FileReader fileReader = new FileReader(monsterFile);
            CSVReader csvReader = new
                    CSVReaderBuilder(fileReader).withSkipLines(1).build();
            MonsterCardsInformation = csvReader.readAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(spellAndTrapFile);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            SpellAndTrapInformation = csvReader.readAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        makeObject();

    }
    public static void makeObject(){
        for(String[]row : MonsterCardsInformation){
            new MonsterCard(row[0],Integer.parseInt(row[1]),row[2],row[3],row[4],Integer.parseInt(row[5]),Integer.parseInt(row[6]),row[7],Integer.parseInt(row[8]));
        }
        for(String[]row: SpellAndTrapInformation){
            if(row[1].equals("Trap"))
                new TrapCard(row[0],row[2],row[3],row[4],Integer.parseInt(row[5]));
            else
                new SpellCard(row[0],row[2],row[3],row[4],Integer.parseInt(row[5]));
        }
    }

    public static List<String[]> getMonsterCardsInformation() {
        return MonsterCardsInformation;
    }

    /*public static void AISetup(){
        new Player("AI","AI","AI");
        new Deck("AI","AI");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Battle Ox");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Battle Ox");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Curtain of Dark Ones");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Curtain of Dark Ones");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Dark Magician");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Dark Magician");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Baby Dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Baby Dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Hero of the East");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Battle Warrior");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Hero of the East");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Battle Warrior");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Flame Manipulator");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Flame Manipulator");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Blue-Eyes White Dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Blue-Eyes White Dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Alexandrite Dragon");
        Deck.getDeckByName("AI",Player.getPlayerByUsername("AI")).addCardToMainDeck_Deck("Alexandrite Dragon");

        Deck.activateDeck("AI",Player.getPlayerByUsername("AI"));
    }*/

    public static void setupForTest(){
        new Player("ahmad","ahmad","ahmad").setScore(200);
        new Player("sara","sara","sara").setScore(150);
        new Player("mmd","mmd","mmd").setScore(100);
        new Player("reza","reza","reza").setScore(220);
        new Player("ali","ali","ali").setScore(80);
       /* new Player("amir","amir","amir");
        new Deck("amir","amir");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Battle OX");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Battle OX");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Curtain of the dark ones");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Curtain of the dark ones");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Dark magician");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Dark magician");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Baby dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Baby dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Hero of the east");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Battle warrior");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Hero of the east");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Battle warrior");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Flame manipulator");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Flame manipulator");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Blue-Eyes white dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Blue-Eyes white dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Alexandrite Dragon");
        Deck.getDeckByName("amir",Player.getPlayerByUsername("amir")).addCardToMainDeck_Deck("Alexandrite Dragon");

        Deck.activateDeck("amir",Player.getPlayerByUsername("amir"));

       // new Player("ali","ali","ali");
        new Deck("ali","ali");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Battle Ox");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Battle Ox");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Axe Raider");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Horn Imp");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Silver Fang");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Fireyarou");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Curtain of the dark ones");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Curtain of the dark ones");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Feral Imp");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Dark magician");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Dark magician");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Wattkid");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Baby dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Baby dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Hero of the east");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Battle warrior");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Hero of the east");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Battle warrior");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Crawling dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Flame manipulator");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Flame manipulator");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Blue-Eyes white dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Blue-Eyes white dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Slot Machine");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Haniwa");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Bitron");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Leotron");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Alexandrite Dragon");
        Deck.getDeckByName("ali",Player.getPlayerByUsername("ali")).addCardToMainDeck_Deck("Alexandrite Dragon");

        Deck.activateDeck("ali",Player.getPlayerByUsername("ali"));*/
    }

}
