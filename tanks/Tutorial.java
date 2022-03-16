import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tutorial Page Icon class
 * 
 * @Suresh Goud Mula 
 * @1.0
 */
public class Tutorial extends Actor
{
    static final int font_size = 30;
    public Tutorial(){
        GreenfootImage image = new GreenfootImage("Tutorial", font_size, null, null);
        
        this.setImage(image);
    }
    
    /**
     * Act - do whatever the Tutorial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
        TutorialPage tutorialPage = new TutorialPage();
        Greenfoot.setWorld(tutorialPage);
        }
    }
}
