import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The two button upon being clicked takes the user to level two of the game where they can play with their friend against the enemy AI tank
 * 
 * @author (Yash Trivedi) 
 * @version (v1)
 */
public class TwoButton extends Actor
{
    public TwoButton(){
        GreenfootImage image = getImage();
        image.scale(175, 100);
    }
    
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
    {
        LevelTwo two = new LevelTwo();
        LevelBuilder levelBuilder = new LevelBuilder(two);
        levelBuilder.buildLevel();
    }
    }
}
