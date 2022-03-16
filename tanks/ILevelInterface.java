import greenfoot.World;

/**
 * ILevelInterface declare methods that has to be implemented by Level classes
 * 
 * @Suresh Goud Mula
 * @1.0
 */
public interface ILevelInterface{
    public void createLevel();
    void setWorld(World dec);

    int[][] getCurrentTankStatus(); // [[p1Lives, p1Health],[p2Lives, p2Health], [AITanksLeft, CurrentAITanks]] 
    
    void act();
}