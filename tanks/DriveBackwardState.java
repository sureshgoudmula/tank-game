//One state of the NPCTank state machine
//The behaviour of this state is to continue to drive backward until randomly turning
//The NPCTank may shoot at walls and will shoot at enemies or follow friends
public class DriveBackwardState extends NullState{
    public DriveBackwardState(){
        super();
    }
    public DriveBackwardState(NPCTankBrainInterface stateMachine){
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
        if(roll<70){
            this.stateMachine.setToDriveBackwardState();
        }
        else if(roll<85){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<100){
            this.stateMachine.setToTurnRightState();
        }
    }
    public void seeWall(){
        int roll=rng.nextInt(100);
        if(roll<70){
            this.stateMachine.setToDriveBackwardState();
        }
        else if(roll<80){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<90){
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