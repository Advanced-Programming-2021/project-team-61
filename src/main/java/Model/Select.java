package Model;

import View.GameView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select {
    private Player player;
    private Player rivalPlayer;
    private static Select s = null;
    Location location;
    private int position;//for field we set 10 -- for deselect we set 0
    private Card card;
    public enum Location{
        MONSTER,
        MONSTEROPPONENT,
        SPELL,
        SPELLOPPONENT,
        FIELD,
        FIELDOPPONENT,
        HAND
    }
    public static Select getInstance(){
        if(s==null)
            s = new Select();
        return s;
    }

    public void run(Player my, Player rival, String command){
        player = my;
        rivalPlayer = rival;
        Matcher matcher;
        if ((getCommandMatcher(command,"select -d")).find()){
            deSelect();

        }else if ((matcher = getCommandMatcher(command,"select --monster --opponent (\\d+)")).find()){
            monsterOpponent(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --monster (\\d+)")).find()){
            monster(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --spell --opponent (\\d+)")).find()){
            spellOpponent(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --spell (\\d+)")).find()){
            spell(matcher);

        }else if ((getCommandMatcher(command,"select --field --opponent")).find()){
            position = 10;
            setLocation(Location.FIELDOPPONENT);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((getCommandMatcher(command,"select --field")).find()){
            position = 10;
            setLocation(Location.FIELD);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((matcher = getCommandMatcher(command,"select --hand (\\d+)")).find()){
            hand(matcher);
        }else if(command.startsWith("select")) {
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }
        else
            GameView.getInstance().printMessage(GameView.Command.invalidCommand);

    }

    private void monsterOpponent(Matcher matcher){
       if(handleMonsterSelect(matcher, rivalPlayer) == 1)
        setLocation(Location.MONSTEROPPONENT);
    }

    private void monster(Matcher matcher){
       if(handleMonsterSelect(matcher, player) == 1)
           setLocation(Location.MONSTER);
    }

    private int  handleMonsterSelect(Matcher matcher, Player player) {
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
            return 0;
        }else if (Board.getBoardByPlayer(player).getMonsterByIndex(loc - 1) == null){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
            return 0;
        }else {
            card = Board.getBoardByPlayer(player).getMonsterByIndex(loc - 1).getMonsterCard();
            position = loc;
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
            return 1;
        }
    }

    private void spellOpponent(Matcher matcher){
        if(handleSpellSelect(matcher, rivalPlayer) == 1)
            setLocation(Location.SPELLOPPONENT);

    }

    private int handleSpellSelect(Matcher matcher, Player player) {
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
            return 0;
        }else if (Board.getBoardByPlayer(player).getSpellTrapByIndex(loc - 1) == null){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
            return 1;
        }else {
            position = loc;
            card = Board.getBoardByPlayer(player).getSpellTrapByIndex(loc - 1).getCard();
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
            return 1;
        }
    }

    private void spell(Matcher matcher){
       if(handleSpellSelect(matcher, player) == 1)
           setLocation(Location.SPELL);

    }

    private void hand(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>6){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getHand().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            card = Board.getBoardByPlayer(player).getCardFromHand(loc - 1);
            position = loc;
            setLocation(Location.HAND);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);

        }
    }

    public void deSelect() {
        if (getLocation()==null) {
            GameView.getInstance().printMessage(GameView.Command.NOTCARDSELECTED);
        }else {
            setLocation(null);
            card = null;
            position = 0;
            GameView.getInstance().printMessage(GameView.Command.CARDDESELECTED);

        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getPosition() {
        return position;
    }

    public Card getCard() {
        return card;
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
