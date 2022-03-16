import greenfoot.*;

/**
 * Bricks that are scattered over the level
 * @author Sachin Pothukuchi 
 */
public class Brick extends UnmovableObjects
{
    int health;
    
    //constructor
    public Brick() {
        super();
        health = 1;
    }
    
    //reduce health, if health is 0 then remove the object from the world
    public void bulletCollision() {
        health--;
        
        if(health == 0){
            getWorld().removeObject(this);
        }
    }
}