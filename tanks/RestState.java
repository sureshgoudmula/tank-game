//One state of the NPCTank state machine
//This is the state the NPCTank defaults to on creation
//The behaviour of this state is to randomly pick to go forward, backward, or turn
//The NPCTank will avoid  or walls and may shoot at them
//The NPCTank will shoot at enemies and follow friends
public class RestState extends NullState{
    public RestState(){
        super();
    }
    public RestState(NPCTankBrainInterface stateMachine){
        super(stateMachine);
    }
    public void seeEnemy(){
        this.stateMachine.setToShootState();
    }
    public void seeFriend(){
        this.stateMachine.setToDriveForwardState();
    }
    public void seeNothing(){
        int roll=rng.nextInt(100);
        if(roll<5){
            this.stateMachine.setToDriveBackwardState();
        }
        else if(roll<60){
            this.stateMachine.setToDriveForwardState();
        }
        else if(roll<80){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<100){
            this.stateMachine.setToTurnRightState();
        }
    }
    public void seeWall(){
        int roll=rng.nextInt(100);
        if(roll<20){
            this.stateMachine.setToDriveBackwardState();
        }
        else if(roll<50){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<80){
            this.stateMachine.setToTurnRightState();
        }
        else if(roll<100){
            this.stateMachine.setToShootState();
        }
    }
    public void takeDamage(){
        this.stateMachine.setToDamagedState();
    }
    public void zeroHealth(){
        this.stateMachine.setToDefeatState();
    }
}