import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used as a placeholder object to add information during level play
 * 
 * @author Sachin Pothukuchi
 * @version 1
 */
public class PlaceHolders extends Actor
{
    final static int font_size = 15;
    
    //update current image
    public void updateImage(String value) {
        GreenfootImage newImage = new GreenfootImage(value, font_size, null, null);
        this.setImage(newImage);
    }
}
