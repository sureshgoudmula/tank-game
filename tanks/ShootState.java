//One state of the NPCTank state machine
//The behaviour of this state is to always go to RestState unless damaged or defeated
//Th NPCTank will reevaluate its position after shooting
public class ShootState extends NullState{
    public ShootState(){
        super();
    }
    public ShootState(NPCTankBrainInterface stateMachine){
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
        this.stateMachine.setToDamagedState();
    }
    public void zeroHealth(){
        this.stateMachine.setToDefeatState();
    }
}