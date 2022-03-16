import greenfoot.*;

/**
 * Write a description of class RightKey here.
 * 
 * @author GuruKarthik 
 * @version 11/23/2021
 */
public class RightKey implements TankCommands
{
    private Tank tank;
    //debounce time to wait before next turn
    long tank_rotation_interval = 200000000;
    //counter for tank rotation debounce time
    long last_turned = -1;
    
    /**
     * This method is a constructor for RightKey class.
     * @param Tank This method takes the instance of Tank object for which the right key is pressed
     * @return None
     */
    public RightKey(Tank tank)
    {
        this.tank = tank;
    }

    /**
     * This method rotates the tank towards it's right direction.
     * @param None
     * @return None
     */
    public void execute()
    {
        int actorX = this.tank.getX();
        int actorY = this.tank.getY();
        int x_offset;
        int y_offset;
        if(last_turned == -1 || System.nanoTime() - last_turned >= tank_rotation_interval) {
            if(tank.getRotation() == 0){
                tank.turn(90);
            }
            else{
                tank.turn(90);
            }
            last_turned = System.nanoTime();
        }
    }
}
