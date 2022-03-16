import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main purpose of this World is to have guidelines for the game
 * It shows how to control playerOne and playerTwo tanks
 * 
 * @Suresh Goud Mula 
 * @1.0
 */
public class TutorialPage extends World
{

    /**
     * Constructor for objects of class TutorialPage.
     * 
     */
    PlaceHolders playerOneHeading;
    PlaceHolders playerOneControls;
    PlaceHolders playerTwoHeading;
    PlaceHolders playerTwoControls;
    
    public TutorialPage()
    {    
        super(700, 600, 1); 
        showGuidelines();
        setBackground();
    }

    //This method return a getImage with specific font
    public GreenfootImage getImage(){
        GreenfootImage image = new GreenfootImage(400, 400);
        image.setFont(new Font("Verdana", 20));
        return image;
    }
    

    /*
     * It add Text Images to the world
     */
    public void showGuidelines(){
        GreenfootImage playerOneHeadingImage = getImage();        
        playerOneHeadingImage.drawString("Player One Controls", 20, 20);
        playerOneHeading = new PlaceHolders();
        playerOneHeading.setImage(playerOneHeadingImage);
        addObject(playerOneHeading, 200,200);
        
        GreenfootImage playerOneControlsImage = getImage();        
        playerOneControlsImage.drawString(getPlayerOneControls(), 20, 20);
        playerOneControls = new PlaceHolders();
        playerOneControls.setImage(playerOneControlsImage);
        addObject(playerOneControls, 225,225);
        
        GreenfootImage playerTwoHeadingImage = getImage();        
        playerTwoHeadingImage.drawString("Player Two Controls", 20, 20);
        playerTwoHeading = new PlaceHolders();
        playerTwoHeading.setImage(playerTwoHeadingImage);
        addObject(playerTwoHeading, 200,400);
        
        GreenfootImage playerTwoControlsImage = getImage();        
        playerTwoControlsImage.drawString(getPlayerTwoControls(), 20, 20);
        playerTwoControls = new PlaceHolders();
        playerTwoControls.setImage(playerTwoControlsImage);
        addObject(playerTwoControls, 225,425);
        
        BackButton back = new BackButton();
        addObject(back, 600, 550);
        
        
    }

    /*
     * Return PlayerOne controls as String Value
     */
    public String getPlayerOneControls(){
        String out = "";
        out += "Up Arrow :: move forward\n";
        out += "Down Arrow :: move backward\n";
        out += "Left Arrow :: Rotates Left\n";
        out += "Right Arrow :: Rotates Right\n";
        out += "Space :: shoot bullets";
        return out;
    }
    
    private void setBackground() {
        GreenfootImage image = getBackground();
        image.setColor(Color.LIGHT_GRAY);
        image.fillRect(700, 0, 200, 600);
    }
    
    /*
     * Return PlayerTwo controls as String Value
     */
    public String getPlayerTwoControls(){
        String out = "";
        out += "W :: move forward\n";
        out += "S :: move backward\n";
        out += "A :: Rotates Left\n";
        out += "D :: Rotates Right\n";
        out += "R  :: shoot bullets";
        return out;
    }
}
