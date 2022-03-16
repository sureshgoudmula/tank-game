import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
This is the class for the main menu page
 * 
 * @author (Yash Trivedi) 
 * @version (v1)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        showMainMenu();
        prepare();
    }

    public void showMainMenu(){
        Menu menu = new Menu();
        addObject(menu, 350, 225);
        OneButton oneButton = new OneButton();
        TwoButton twoButton = new TwoButton();
        Tutorial tutorial = new Tutorial();
        addObject(oneButton,350,275);
        addObject(twoButton,350,425);
        addObject(tutorial,575,525);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
