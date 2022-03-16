import java.util.Random;
//Defines a generic state for the NPCTank statemachine; all states should extend this class
public abstract class NullState implements NPCTankBrainStateInterface{
    protected NPCTankBrainInterface stateMachine;
    protected Random rng;
    public NullState(){
        this.rng=new Random();
    }
    public NullState(NPCTankBrainInterface stateMachine){
        this();
        this.stateMachine=stateMachine;
    }
    public void setStateMachine(NPCTankBrainInterface stateMachine){
        this.stateMachine=stateMachine;
    }
}