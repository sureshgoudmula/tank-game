import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        super(700, 600, 1);
        MainMenu mainMenu = new MainMenu();
        Greenfoot.setWorld(mainMenu);
        //LevelOne one = new LevelOne();
        //LevelDecorator oneD = new LevelDecorator(one);
        //one.setDaddy(oneD);
        //Greenfoot.setWorld(oneD);
        //oneD.createLevel();
    }
    
    
}
