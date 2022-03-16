import greenfoot.*;

/**
 * Write a description of class UpKey here.
 * 
 * @author Guru Karthik
 * @version 11/23/2021
 */
public class UpKey implements TankCommands
{
    private Tank tank;
    /**
     * This method is a constructor for UpKey class.
     * @param Tank This method takes the instance of Tank object for which the up key is pressed
     * @return None
     */
    public UpKey(Tank tank)
    {
        this.tank = tank;
    }

    /**
     * This method moves the tank in forward direction upon checking the presense of obstacle.
     * @param None
     * @return None
     */
    public void execute()
    {
        int actorX = this.tank.getX();
        int actorY = this.tank.getY();
        int x_offset;
        int y_offset;
        int rotation = tank.getRotation();
        
        if(this.tank.getObstacle("up") == null){
                if(rotation == 0) {
                x_offset = 2;
                y_offset = 0;
            }else if(rotation == 90) {
                x_offset = 0;
                y_offset = 2;
            }else if(rotation == 180) {
                x_offset = -2;
                y_offset = 0;
            }else{
                x_offset = 0;
                y_offset = -2;
            }
            this.tank.setLocation(actorX + x_offset, actorY + y_offset);
        }
    }
}
