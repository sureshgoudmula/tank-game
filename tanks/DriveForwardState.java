//One state of the NPCTank state machine
//The behaviour of this state is to continue driving forward until randomly turning
//The NPCTank will avoid walls and may shoot at them
//The NPCTank will shoot at enemies
public class DriveForwardState extends NullState{
    public DriveForwardState(){
        super();
    }
    public DriveForwardState(NPCTankBrainInterface stateMachine){
        super(stateMachine);
    }
    public void seeEnemy(){
        this.stateMachine.setToShootState();
    }
    public void seeFriend(){
        int roll=rng.nextInt(100);
        if(roll<80){
            this.stateMachine.setToDriveForwardState();
        }
        else if(roll<90){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<100){
            this.stateMachine.setToTurnRightState();
        }
    }
    public void seeNothing(){
        int roll=rng.nextInt(100);
        if(roll<80){
            this.stateMachine.setToDriveForwardState();
        }
        else if(roll<90){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<100){
            this.stateMachine.setToTurnRightState();
        }
    }
    public void seeWall(){
        int roll=rng.nextInt(100);
        if(roll<33){
            this.stateMachine.setToTurnLeftState();
        }
        else if(roll<66){
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