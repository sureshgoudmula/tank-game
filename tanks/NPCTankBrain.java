import java.util.ArrayList;
//The implementation of NPCTankBrainInterface
//This class is the core of the NPCTank state machine
//As the NPCTankBrain receives event inputs, it will change its state and update any observers
//Those observers can read the NPCTankBrain's state and act as they please
public class NPCTankBrain implements NPCTankBrainInterface{
    private DamagedState damaged;
    private DefeatState defeat;
    private DriveBackwardState driveBackward;
    private DriveForwardState driveForward;
    private RestState rest;
    private ShootState shoot;
    private TurnLeftState turnLeft;
    private TurnRightState turnRight;
    private NPCTankBrainStateInterface currentState;
    private ArrayList<NPCTankBrainObserverInterface> observers;
    public NPCTankBrain(){
        this.damaged=new DamagedState(this);        
        this.defeat=new DefeatState(this);        
        this.driveBackward=new DriveBackwardState(this);
        this.driveForward=new DriveForwardState(this);
        this.rest=new RestState(this);
        this.shoot=new ShootState(this);
        this.turnLeft=new TurnLeftState(this);
        this.turnRight=new TurnRightState(this);
        this.observers=new ArrayList<NPCTankBrainObserverInterface>();
        this.setToRestState();
    }
    //handling observers
    public void attachObserver(NPCTankBrainObserverInterface newObserver){
        observers.add(newObserver);
    }
    public void notifyObservers(){
        if(!observers.isEmpty()){
            for(int i=0;i<observers.size();i++){
                observers.get(i).update(this);
            }
        }
    }
    //handling events
    public void seeEnemy(){
        this.currentState.seeEnemy();
    }
    public void seeFriend(){
        this.currentState.seeFriend();
    }
    public void seeNothing(){
        this.currentState.seeNothing();
    }
    public void seeWall(){
        this.currentState.seeWall();
    }
    public void takeDamage(){
        this.currentState.takeDamage();
    }
    public void zeroHealth(){
        this.currentState.zeroHealth();
    }
    //handling states
    public NPCTankBrainStateInterface getState(){
        return this.currentState;
    }
    public void setToDamagedState(){
        this.currentState=this.damaged;
        this.notifyObservers();
    }
    public void setToDefeatState(){
        this.currentState=this.defeat;
        this.notifyObservers();
    }
    public void setToDriveBackwardState(){
        this.currentState=this.driveBackward;
        this.notifyObservers();
    }
    public void setToDriveForwardState(){
        this.currentState=this.driveForward;
        this.notifyObservers();
    }
    public void setToRestState(){
        this.currentState=this.rest;
        this.notifyObservers();
    }
    public void setToShootState(){
        this.currentState=this.shoot;
        this.notifyObservers();
    }
    public void setToTurnLeftState(){
        this.currentState=this.turnLeft;
        this.notifyObservers();
    }
    public void setToTurnRightState(){
        this.currentState=this.turnRight;
        this.notifyObservers();
    }
}