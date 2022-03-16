import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Barrier class for showing distinction between barrier and the world
 * 
 * @author Sachin Pothukuchi 
 * @version 1.0
 */
public class Barrier extends UnmovableObjects
{
    //constructor
    public Barrier() {
        super();
        GreenfootImage image = new GreenfootImage(5, 600);
        image.setColor(Color.BLACK);
        image.fill();
        this.setImage(image);
    }
    
    public void bulletCollision() {
        //do nothing
    }
}
