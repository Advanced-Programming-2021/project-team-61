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
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
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

    public static void AISetup(){
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
    }

}
