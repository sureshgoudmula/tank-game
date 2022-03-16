import greenfoot.*;
/**
 * Decorates level for adding functionality like number of lives left etc
 * 
 * @Sachin Pothukuchi 
 * @1.0
 */
public class LevelDecorator extends World implements ILevelInterface  
{
    ILevelInterface base;
    
    PlaceHolders P1PlaceHolder;
    PlaceHolders P2PlaceHolder;
    PlaceHolders AIPlaceHolder;
    PlaceHolders P1PlaceHolderLives;
    PlaceHolders P2PlaceHolderLives;
    PlaceHolders AIPlaceHolderLives;
    PlaceHolders P1PlaceHolderHealth;
    PlaceHolders P2PlaceHolderHealth;
    PlaceHolders AIPlaceHolderHealth;
    
    /**
     * Constructor
     */
    public LevelDecorator(ILevelInterface base) {
        super(900, 600, 1);
        this.base = base;
    }
    
    /**
     * dont want to decorate
     */
    public void setWorld(World dec) {
        //do nothing
    }
    
    // act function called repeatedly, keep updating info on the side
    public void act() {
        base.act();
        updateInfo();
    }
    
    
    //create level, add barrier, set background for the barrier and initialize the side information
    public void createLevel() {
        base.createLevel();
        addBarrier();
        setBackground();
        setInfo();
    }
    
    //initializing the side information
    private void setInfo() {     
        
        //temp placeholder dont need reference to these
        PlaceHolders tankHeading = new PlaceHolders();
        tankHeading.updateImage("Tank");
        PlaceHolders livesRemainingHeading = new PlaceHolders();
        livesRemainingHeading.updateImage("Lives");
        PlaceHolders healthRemainingHeading = new PlaceHolders();
        healthRemainingHeading.updateImage("Health");
        
        P1PlaceHolder = new PlaceHolders();
        P1PlaceHolder.setImage(new P1Tank().getImage());
        
        P2PlaceHolder = new PlaceHolders();
        P2PlaceHolder.setImage(new P2Tank().getImage());
        
        AIPlaceHolder = new PlaceHolders();
        AIPlaceHolder.setImage(new NPCTank().getImage());
        
        P1PlaceHolderLives = new PlaceHolders();
        P2PlaceHolderLives = new PlaceHolders();
        AIPlaceHolderLives = new PlaceHolders();
        
        P1PlaceHolderHealth = new PlaceHolders();
        P2PlaceHolderHealth = new PlaceHolders();
        AIPlaceHolderHealth = new PlaceHolders();
        
        
        addObject(tankHeading, 750, 150);
        addObject(livesRemainingHeading, 800, 150);
        addObject(healthRemainingHeading, 850, 150);
        
        addObject(P1PlaceHolder, 750, 200);
        addObject(P1PlaceHolderLives, 800, 200);
        addObject(P1PlaceHolderHealth, 850, 200);
        
        addObject(P2PlaceHolder, 750, 300);
        addObject(P2PlaceHolderLives, 800, 300);
        addObject(P2PlaceHolderHealth, 850, 300);
        
        addObject(AIPlaceHolder, 750, 400);
        addObject(AIPlaceHolderLives, 800, 400);
        addObject(AIPlaceHolderHealth, 850, 400);
    }

    
    //function to update the placeholders
    public void updateInfo() {
        int[][] stats = getCurrentTankStatus();

        P1PlaceHolderLives.updateImage(Integer.toString(stats[0][0]));
        P2PlaceHolderLives.updateImage(Integer.toString(stats[1][0]));
        AIPlaceHolderLives.updateImage(Integer.toString(stats[2][0]));
        
        P1PlaceHolderHealth.updateImage(Integer.toString(stats[0][1]));
        P2PlaceHolderHealth.updateImage(Integer.toString(stats[1][1]));
        AIPlaceHolderHealth.updateImage(Integer.toString(stats[2][1]));
    }
    
    //set background for the side bar
    private void setBackground() {
        GreenfootImage image = getBackground();
        image.setColor(Color.LIGHT_GRAY);
        image.fillRect(700, 0, 200, 600);
    }
    
    //add barrier between the level and the side information
    private void addBarrier(){
        Barrier barrier = new Barrier();
        addObject(barrier, 700, 300);
    }
    
    // get current tank status to display on the sidebar
    public int[][] getCurrentTankStatus() {
        return base.getCurrentTankStatus();
    }
    
    //return this world, used in levelHandler to spawn tanks
    public World returnWorld() {
        return this;
    }
}
