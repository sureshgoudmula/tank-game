import greenfoot.*;

/**
 * Write a description of class P1Tank here.
 * 
 * @author Guru Karthik
 * @version 11/23/2021
 */
public class P1Tank extends Tank
{
    public P1Tank(){
        super();
        //set tank image
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 45, image.getHeight() - 15);
        setImage(image);
    }
    
    /**
     * Act - do whatever the P1Tank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(this.health>0){
            if(Greenfoot.isKeyDown("left"))
                leftKey.execute();
            if(Greenfoot.isKeyDown("right"))
                rightKey.execute();
            if(Greenfoot.isKeyDown("up"))
                upKey.execute();
            if(Greenfoot.isKeyDown("down"))
                downKey.execute();
            if(Greenfoot.isKeyDown("space"))
                this.shoot();
        }    
    }
}
