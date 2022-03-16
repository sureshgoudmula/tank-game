import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Sachin Pothukuchi 
 */
public abstract class UnmovableObjects extends Actor
{
    //constructor
    public UnmovableObjects() {
        GreenfootImage image = getImage();
        image.scale(50,50);
    }
    
    
    //unmovable objects dont move
    public void act()
    {
        // doesnt act as they are immovable
    }
    
    /**
     * called whenever bullets collide
     * needs to be overridden as some might be destoryed the others might not be
     */
    public abstract void bulletCollision();
}