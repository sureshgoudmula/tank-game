import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    
    public BackButton() {
        GreenfootImage image = new GreenfootImage("Back", 30, null, null);
        this.setImage(image);
    }
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            MainMenu menu = new MainMenu();
            Greenfoot.setWorld(menu);
        }
    }
}
