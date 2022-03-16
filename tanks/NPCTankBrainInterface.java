//Classes that implement this interface make the core of the NPCTank state machine as well
//They have to track observers and state, as well as account for the events from NPCTankBrainStateInterface
public interface NPCTankBrainInterface extends NPCTankBrainStateInterface{    
    //handling observers
    public void attachObserver(NPCTankBrainObserverInterface observer);
    public void notifyObservers();
    //handling state changes
    public NPCTankBrainStateInterface getState();
    public void setToDamagedState();
    public void setToDefeatState();
    public void setToDriveBackwardState();
    public void setToDriveForwardState();
    public void setToRestState();
    public void setToShootState();
    public void setToTurnLeftState();
    public void setToTurnRightState();
}