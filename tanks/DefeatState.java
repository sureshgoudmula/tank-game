//One state of the NPCTank state machine
//This state has no behaviour, the NPCTank is defeated
public class DefeatState extends NullState{
    public DefeatState(){
        super();
    }
    public DefeatState(NPCTankBrainInterface stateMachine){
        super(stateMachine);
    }
    public void seeEnemy(){
        return;
    }
    public void seeFriend(){
        return;
    }
    public void seeNothing(){
        return;
    }
    public void seeWall(){
        return;
    }
    public void takeDamage(){
        return;
    }
    public void zeroHealth(){
        return;
    }
}