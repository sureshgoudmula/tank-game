import greenfoot.Actor;

/**
 * Write a description of class Tank here.
 * 
 * @author Guru Karthik
 * @version 11/23/2021
 */
public abstract class Tank extends Actor
{
    //Health of tank
    int health;
    //debounce time to wait before firing next bullet
    static long bullet_interval = 200000000;
    //bullet position offset from tank position
    static final int bullet_offset = 40;
    //counter for bullet debounce time
    long last_shot = -1;
    
    IBulletCollisionStrategy strategy;
    IBulletCollisionStrategy health1Strategy = new Health1Strategy(); 
    IBulletCollisionStrategy health0Strategy = new Health0Strategy(); 
    
    //keys for tank movement control
    protected TankCommands upKey;
    protected TankCommands leftKey;
    protected TankCommands rightKey;
    protected TankCommands downKey;
    public Tank()
    {
        upKey = new UpKey(this);
        leftKey = new LeftKey(this);
        rightKey = new RightKey(this);
        downKey = new DownKey(this);
        setStrategy(health1Strategy) ;
        health = 3;
    }
    
    //fire function to enable the tanks to shoot
    public void shoot(){
        //check if bullet debounce time has elapsed
        if(last_shot == -1 || System.nanoTime() - last_shot >= bullet_interval) {
            Bullet bullet = new Bullet();
            int x_offset;
            int y_offset;
            int rotation = getRotation();
            
            //get the tank orientation to fire bullet in same direction 
            if(rotation == 0) {
                x_offset = bullet_offset;
                y_offset = 0;
            }else if(rotation == 90) {
                x_offset = 0;
                y_offset = bullet_offset;
            }else if(rotation == 180) {
                x_offset = -bullet_offset;
                y_offset = 0;
            }else{
                x_offset = 0;
                y_offset = -bullet_offset;
            }
            bullet.setRotation(rotation);
            //add bullet to game screen
            getWorld().addObject(bullet, getX() + x_offset, getY() + y_offset);
            
            //update debounce counter of bullet
            last_shot = System.nanoTime();
        }
    }
    
    /**
    * This method is used for reducing the tank's health.
    * @param None
    * @return None
    */
    public void reduceHealth(){
        health--;
    }
    
    /**
    * This method is used for fetching the tank's health.
    * @param None
    * @return int This returns health of tank
    */
    public int getHealth() {
        return health;
    }
    
    /**
    * This method is used for fetching the tank's health.
    * @param String This is the direction in which obstacle needs to be fetched
    * @return UnmovableObjects This returns the obstacle for tank in the given direction
    */
    public UnmovableObjects getObstacle(String direction){
        //tank's coordinates in the world
        int actorX = getX();
        int actorY = getY();
        //null if no obstacle is present
        UnmovableObjects a = null;
        int x_offset;
        int y_offset;
        //fetch tank's current orientation
        int rotation = getRotation();    
        switch (direction) {
            case "up":
                    
                if(rotation == 0) {
                    a = (UnmovableObjects)getOneObjectAtOffset(25, 0, UnmovableObjects.class);
                }else if(rotation == 90) {
                    a = (UnmovableObjects)getOneObjectAtOffset(0, 25, UnmovableObjects.class);
                }else if(rotation == 180) {
                    a = (UnmovableObjects)getOneObjectAtOffset(-25, 0, UnmovableObjects.class);
                }else{
                    a = (UnmovableObjects)getOneObjectAtOffset(0, -25, UnmovableObjects.class);
                }
                break;
            case "down":    
                if(rotation == 0) {
                    a = (UnmovableObjects)getOneObjectAtOffset(-25, 0, UnmovableObjects.class);
                }else if(rotation == 90) {
                    a = (UnmovableObjects)getOneObjectAtOffset(0, -25, UnmovableObjects.class);
                }else if(rotation == 180) {
                    a = (UnmovableObjects)getOneObjectAtOffset(25, 0, UnmovableObjects.class);
                }else{
                    a = (UnmovableObjects)getOneObjectAtOffset(0, 25, UnmovableObjects.class);
                }
                break;
        }
        return a;
    }
    
    // Setting strategy
    public void setStrategy(IBulletCollisionStrategy s){
        this.strategy = s ;
    }
    
    // Reduce health of the tank and display the tank after the hit of bullet
    /**
    * This method is used for reducing the tank's health and change it's appearance upon taking a bullet.
    * @param None
    * @return None
    */
    public void bulletCollision(){
        reduceHealth();
        
        if(getHealth() == 0){
            setStrategy(health0Strategy) ;
        }
        strategy.display(this);
    }
}
