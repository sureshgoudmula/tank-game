import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @Suresh Goud Mula 
 * @1.0
 */
public class Exit extends Actor
{
    public Exit(){
        GreenfootImage image = getImage();
        image.scale(175, 100);
    }
    /**
     * Act - Whenever user clicks on exit button. The game gets reset
     */
    public void act()
    {
        
        if (Greenfoot.mousePressed(this))
        {
        resetGame();
        Greenfoot.setWorld(new MainMenu());
        }
        
    }
    
    private void resetGame(){
        LevelHandler levelHandler = LevelHandler.getInstance();
        levelHandler.reset();
        ScoreManager scoreManager =  ScoreManager.getInstance();
        scoreManager.reset();
    }
}
