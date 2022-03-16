import greenfoot.*;

/**
 * Write a description of class DownKey here.
 * 
 * @author Guru Karthik
 * @version 11/23/2021
 */
public class DownKey implements TankCommands
{
    /**
     * This method is a constructor for DownKey class.
     * @param Tank This method takes the instance of Tank object for which the down key is pressed
     * @return None
     */
    private Tank tank;
    public DownKey(Tank tank)
    {
        this.tank = tank;
    }

    /**
     * This method moves the tank in reverse direction upon checking the presense of obstacle.
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
        
        if(this.tank.getObstacle("down") == null){
                if(rotation == 180) {
                x_offset = 2;
                y_offset = 0;
            }else if(rotation == 90) {
                x_offset = 0;
                y_offset = -2;
            }else if(rotation == 0) {
                x_offset = -2;
                y_offset = 0;
            }else{
                x_offset = 0;
                y_offset = 2;
            }
            this.tank.setLocation(actorX + x_offset, actorY + y_offset);
        }
    }
}
