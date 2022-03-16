//One state of the NPCTank state machine
//The behaviour of this state is to always go to RestState
//unless already defeated
//The idea is to create a momentary pause as the NPCTank reevaluates after being struck
public class DamagedState extends NullState{
    public DamagedState(){
        super();
    }
    public DamagedState(NPCTankBrainInterface stateMachine){
        super(stateMachine);
    }
    public void seeEnemy(){
        this.stateMachine.setToRestState();
    }
    public void seeFriend(){
        this.stateMachine.setToRestState();
    }
    public void seeNothing(){
        this.stateMachine.setToRestState();
    }
    public void seeWall(){
        this.stateMachine.setToRestState();
    }
    public void takeDamage(){
        this.stateMachine.setToRestState();
    }
    public void zeroHealth(){
        this.stateMachine.setToDefeatState();
    }
}