//The state machine that uses this interface must react in some way to these events
public interface NPCTankBrainStateInterface{
    public void seeEnemy();
    public void seeFriend();
    public void seeNothing();
    public void seeWall();
    public void takeDamage();
    public void zeroHealth();
}