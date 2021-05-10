import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattlePhase {

    private static BattlePhase b = null;
    private static GameView view;
    private String command;
    private Matcher matcher;

    private BattlePhase(GameView view){
        this.view = view;
    }

    public static BattlePhase getInstance(){
        if(b == null){
            b = new BattlePhase(GameView.getInstance());
        }
        return b;
    }
    public void run(Player me , Player rival){
        Board myBoard = Board.getBoardByPlayer(me);
        Board rivalBoard = Board.getBoardByPlayer(rival);
        while(true){
            command = view.scan();
            if(getCommandMatcher(command,"attack (\\d+)").find()){
                matcher = getCommandMatcher(command,"attack (\\d+)");
                ProcessAttack(myBoard,rivalBoard,Integer.parseInt(matcher.group(1)));
            }




        }




    }
    private void ProcessAttack(Board myBoard,Board rivalBoard,int number){
        if(Select.getInstance().getLocation()==null)
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        else if(Select.getInstance().getLocation()!=Select.Location.MONSTER){
            view.printMessage(GameView.Command.NOTATTACK);
        }
        else if(myBoard.hasAttackInTurn(Select.getInstance().getPosition()-1)){
           view.printMessage(GameView.Command.HASATTACKED);
        }
        else if(rivalBoard.getMonsterZoneByNumber(number -1).equals("E"))
            view.printMessage(GameView.Command.NOCARDTOATTACK);
        else
            attack((MonsterCard)myBoard.getMonsterCardByKey(Select.getInstance().getPosition()-1),(MonsterCard)rivalBoard.getMonsterCardByKey(number-1),rivalBoard.getMonsterZoneByNumber(number -1));






    }
    private void attack(MonsterCard myMonster,MonsterCard rivalMonster,String rivalMonsterStatus){

        if(rivalMonsterStatus.equals("OO"))
           // handleOOAttack(myMonster,rivalMonster);




    }
    private Matcher getCommandMatcher(String input,String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
