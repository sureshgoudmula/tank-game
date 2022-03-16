import greenfoot.*;

public class NPCTank extends Tank implements NPCTankBrainObserverInterface{
    private NPCTankBrainInterface brain;
    private String nextAction;
    private static final int lineOfSightDistance=5;
    
    public NPCTank(){
        super();
        this.brain=new NPCTankBrain();
        this.brain.attachObserver(this);
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 45, image.getHeight() - 15);
        setImage(image);
    }
    //The NPCTank checks with the brain to update its orders
    public void update(NPCTankBrainInterface observed){
        this.nextAction=observed.getState().getClass().toString().substring(6);
    }
    //Every frame, the NPCTank will tell the brain what it senses,
    //then act out what the brain says to do
    public void act(){
        if(this.health<=0){
            this.brain.zeroHealth();
        }
        this.senseEnviron();
        this.executeAction();
    }
    //The NPCTank uses whatever senses are available and communicates relevant information to the brain
    private void senseEnviron(){
        processSight(lookAhead(this.lineOfSightDistance));
    }
    //Having seen something, the NPCTank translates what it saw for the benefit of the brain
    private void processSight(Actor sight){
        if(sight==null){
            this.brain.seeNothing();
        }
        else{
            String sightString=sight.getClass().toString().substring(6);
            if(sightString.equals("P1Tank")){
                this.brain.seeEnemy();
            }
            else if(sightString.equals("P2Tank")){
                this.brain.seeEnemy();
            }
            else if(sightString.equals("NPCTank")){
                this.brain.seeFriend();
            }
            else if(sightString.equals("Brick")){
                this.brain.seeWall();
            }
            else{
                this.brain.seeNothing();
            }
        }
    }
    //The NPCTank looks ahead <distance> steps and reports the closest thing in that direction
    //it loops up to <distance> times, checking further and further each time until it finds something
    //or hits the maximum loop count
    private Actor lookAhead(int distance){
        int increment=25;
        int rot=getRotation();
        int n=1;
        Actor result=null;
        while(result==null&&n<=distance){
            if(rot==0){
                result=lookAheadRot0(n,increment);
            }
            else if(rot==90){
                result=lookAheadRot90(n,increment);
            }
            else if(rot==180){
                result=lookAheadRot180(n,increment);
            }
            else if(rot==270){
                result=lookAheadRot270(n,increment);
            }
            n++;
        }
        return result;
    }
    private Actor lookAheadRot0(int distance,int increment){
        Actor result=null;
        result=getOneObjectAtOffset(increment*distance,0,null);
        return result;
    }
    private Actor lookAheadRot90(int distance,int increment){
        Actor result=null;
        result=getOneObjectAtOffset(0,increment*distance,null);
        return result;
    }
    private Actor lookAheadRot180(int distance,int increment){
        Actor result=null;
        result=getOneObjectAtOffset(-increment*distance,0,null);
        return result;
    }
    private Actor lookAheadRot270(int distance,int increment){
        Actor result=null;
        result=getOneObjectAtOffset(0,-increment*distance,null);
        return result;
    }
    //The NPCTank reads the last order received from the brain and acts on it
    private void executeAction(){
        if(this.nextAction.equals("DamagedState")){
            //
        }
        else if(this.nextAction.equals("DefeatState")){
            //
        }
        else if(this.nextAction.equals("DriveBackwardState")){
            downKey.execute();
        }
        else if(this.nextAction.equals("DriveForwardState")){
            upKey.execute();
        }
        else if(this.nextAction.equals("RestState")){
            //
        }
        else if(this.nextAction.equals("TurnLeftState")){
            leftKey.execute();
        }
        else if(this.nextAction.equals("ShootState")){
            this.shoot();
        }
        else if(this.nextAction.equals("TurnRightState")){
            rightKey.execute();
        }
    }
    //The NPCTank takes a point of damage
    //Overridden to add behavior of informing the brain of the damage
    public void reduceHealth(){
        this.health--;
        this.brain.takeDamage();
    }
}
