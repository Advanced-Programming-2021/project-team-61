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
            }else if (getCommandMatcher(command,"attack direct").find()){
                ProcessDirectAttack(myBoard,rivalBoard);
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
        else{
            String status = rivalBoard.getMonsterZoneByNumber(number-1);
            if(status.equals("OO"))
            attackOO((MonsterCard)myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),(MonsterCard)rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);
            else if(status.equals("DO"))
                attackDO((MonsterCard)myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),(MonsterCard)rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);
            else{
                attackDH((MonsterCard)myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),(MonsterCard)rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);
            }



        }






    }
    private void attackOO(MonsterCard myMonster,MonsterCard rivalMonster,Board myBoard,Board rivalBoard,int number){
        if(myMonster.getAttack() > rivalMonster.getAttack()){
            int damage = myMonster.getAttack() - rivalMonster.getAttack();
            rivalBoard.destroyCardInMonsterZone(number);
            rivalBoard.setLifePoint(damage);
            view.printMessageByAddingString(GameView.Command.damageOpponent,damage);
        }
        else if(myMonster.getAttack() == rivalMonster.getAttack()){
            myBoard.destroyCardInMonsterZone(Select.getInstance().getPosition());
            rivalBoard.destroyCardInMonsterZone(number);
            view.printMessage(GameView.Command.bothDamage);
        }
        else if(myMonster.getAttack() < rivalMonster.getAttack()){
            myBoard.destroyCardInMonsterZone(Select.getInstance().getPosition());
            int damage = rivalMonster.getAttack() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessageByAddingString(GameView.Command.damageMe,damage);
        }
    }
    private void attackDO(MonsterCard myMonster,MonsterCard rivalMonster,Board myBoard,Board rivalBoard,int number){
        if(rivalMonster.getDefense() < myMonster.getAttack()){
            rivalBoard.destroyCardInMonsterZone(number);
            view.printMessage(GameView.Command.damageRivalDOMonster);
        }
        else if(rivalMonster.getDefense() == myMonster.getAttack()){
            view.printMessage(GameView.Command.noDamage);
        }
        else if(rivalMonster.getDefense() > myMonster.getAttack()){
            int damage = rivalMonster.getDefense() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessageByAddingString(GameView.Command.justLifePointDecrease,damage);
        }
    }
    private void attackDH(MonsterCard myMonster,MonsterCard rivalMonster,Board myBoard,Board rivalBoard,int number){
        if(rivalMonster.getDefense() < myMonster.getAttack()){
            rivalBoard.destroyCardInMonsterZone(number);
            view.printMessageByString(GameView.Command.damageRivalDOMonster,rivalMonster.getCardName());
        }
        else if(rivalMonster.getDefense() == myMonster.getAttack()){
            view.printMessageByString(GameView.Command.noDamage,rivalMonster.getCardName());
        }
        else if(rivalMonster.getDefense() > myMonster.getAttack()){
            int damage = rivalMonster.getDefense() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessageByString(GameView.Command.cardName,rivalMonster.getCardName());
            view.printMessageByAddingString(GameView.Command.justLifePointDecrease,damage);
        }

    }

    private void ProcessDirectAttack(Board myBoard, Board rivalBoard){
        if(Select.getInstance().getLocation()==null) {
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }else if(Select.getInstance().getLocation()!=Select.Location.MONSTER){
            view.printMessage(GameView.Command.NOTATTACK);
        }else if(myBoard.hasAttackInTurn(Select.getInstance().getPosition()-1)){
            view.printMessage(GameView.Command.HASATTACKED);
        }else if (!rivalBoard.isMonsterZoneEmpty()){//add condition that we can't have direct attack ?????
            view.printMessage(GameView.Command.CANTDIRECTATTACK);
        }else {
            int damage = 0;  // =attackOfCard + extraAttack
            view.printMessageByAddingString(GameView.Command.DIRECTATTACKSUCCESSFULLY, damage);
            // decrease lifePoint : amount => damage
        }
    }
    private Matcher getCommandMatcher(String input,String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
