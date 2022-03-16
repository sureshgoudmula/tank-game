import java.util.Random;
import java.util.Arrays;
import greenfoot.*;

/**
 * Creates Level Two game 
 * 
 * @Suresh Goud Mula 
 * @1.0
 */
public class LevelTwo extends World implements ILevelInterface{

    private LevelHandler levelHandler;

    private World nextLevel;

    World dec;
    public LevelTwo(){
        super(700,600,1);
        dec = this;
    }
    
    public void act() {
        levelHandler.run();
    }
    
    /*
     * Associate with LevelDecorator
     */
    public void setWorld(World dec){
        this.dec = dec;
    }
    
    /*
     * Builds Level Two
     */
    public void createLevel(){
        levelHandler =  LevelHandler.getInstance();
        createBricks();
        createP1Tank();
        createP2Tank();
        createEnemyTanks();
    }
    
    /*
     * Creates Player One Tank
     */
    public void createP1Tank(){
        P1Tank p1Tank = new P1Tank();
        dec.addObject(p1Tank, 25, 325);
    }
    
    /*
     * Creates Player Two Tank
     */
    public void createP2Tank(){
        P2Tank p2Tank = new P2Tank();
        dec.addObject(p2Tank, 425, 575);
    }
    
    /*
     * Creates AI Tanks
     */
    public void createEnemyTanks(){
        levelHandler.createEnemyTanks();
    }

    /*
     * Return Player and AI tanks status like health, lives
     */
    public int[][] getCurrentTankStatus(){
        return levelHandler.getCurrentTankStatus();
    }

    /*
     * Create Bricks objects and adds to the LevelTwo World
     */
    public void createBricks() {
        Brick brick1 = new Brick();
        dec.addObject(brick1,125,25);
        Brick brick2 = new Brick();
        dec.addObject(brick2,175,75);
        Brick brick3 = new Brick();
        dec.addObject(brick3,75,175);

        Brick brick6 = new Brick();
        dec.addObject(brick6,75,275);
        Brick brick7 = new Brick();
        dec.addObject(brick7,125,325);
        Unbreakable unbreakable3 = new Unbreakable();
        dec.addObject(unbreakable3,175,275);
        Brick brick9 = new Brick();
        dec.addObject(brick9,225,225);
        Brick brick10 = new Brick();
        dec.addObject(brick10,275,275);
        Brick brick11 = new Brick();
        dec.addObject(brick11,325,275);
        Brick brick12 = new Brick();
        dec.addObject(brick12,25,225);

        Brick brick14 = new Brick();
        dec.addObject(brick14,375,575);
        Brick brick15 = new Brick();
        dec.addObject(brick15,375,525);

        Brick brick17 = new Brick();
        dec.addObject(brick17,475,525);
        Brick brick18 = new Brick();
        dec.addObject(brick18,475,575);

        Unbreakable unbreakable8 = new Unbreakable();
        dec.addObject(unbreakable8,325,225);
        Brick brick22 = new Brick();
        dec.addObject(brick22,325,175);
        Brick brick24 = new Brick();
        dec.addObject(brick24,325,175);
        Brick brick25 = new Brick();
        dec.addObject(brick25,325,125);
        Unbreakable unbreakable9 = new Unbreakable();
        dec.addObject(unbreakable9,325,75);
        Brick brick27 = new Brick();
        dec.addObject(brick27,325,25);

        Brick brick28 = new Brick();
        dec.addObject(brick28,125,125);
        Unbreakable unbreakable2 = new Unbreakable();
        dec.addObject(unbreakable2,175,125);
        Brick brick30 = new Brick();
        dec.addObject(brick30,225,125);
        Brick brick31 = new Brick();
        dec.addObject(brick31,275,125);

        Brick brick32 = new Brick();
        dec.addObject(brick32,25,425);
        Brick brick33 = new Brick();
        dec.addObject(brick33,75,375);
        

        Brick brick35 = new Brick();
        dec.addObject(brick35,175,375);

        Brick brick37 = new Brick();
        dec.addObject(brick37,275,375);
        Brick brick38 = new Brick();
        dec.addObject(brick38,325,375);
        Unbreakable unbreakable10 = new Unbreakable();
        dec.addObject(unbreakable10,375,375);
        Brick brick40 = new Brick();
        dec.addObject(brick40,425,425);
        Brick brick41 = new Brick();
        dec.addObject(brick41,475,375);

        Brick brick43 = new Brick();
        dec.addObject(brick43,575,375);
        Brick brick44 = new Brick();
        dec.addObject(brick44,625,375);
        Unbreakable unbreakable7 = new Unbreakable();
        dec.addObject(unbreakable7,675,375);

        Brick brick46 = new Brick();
        dec.addObject(brick46,125,425);
        Brick brick47 = new Brick();
        dec.addObject(brick47,175,475);
        Brick brick48 = new Brick();
        dec.addObject(brick48,225,525);
        Unbreakable unbreakable6 = new Unbreakable();
        dec.addObject(unbreakable6,275,575);
        Brick brick50 = new Brick();
        dec.addObject(brick50,225,425);
        Brick brick51 = new Brick();
        dec.addObject(brick51,275,475);
        Brick brick52 = new Brick();
        dec.addObject(brick52,325,425);

        Brick brick53 = new Brick();
        dec.addObject(brick53,525,425);
        Brick brick54 = new Brick();
        dec.addObject(brick54,575,475);
        Brick brick55 = new Brick();
        dec.addObject(brick55,625,525);
        Brick brick56 = new Brick();
        dec.addObject(brick56,675,575);
        Brick brick57 = new Brick();
        dec.addObject(brick57,575,575);

        Unbreakable unbreakable5 = new Unbreakable();
        dec.addObject(unbreakable5,25,475);
        Brick brick60 = new Brick();
        dec.addObject(brick60,75,525);
        Brick brick61 = new Brick();
        dec.addObject(brick61,125,575);
        Brick brick62 = new Brick();
        dec.addObject(brick62,675,575);
        Brick brick63 = new Brick();
        dec.addObject(brick63,575,575);

        

        Brick brick66 = new Brick();
        dec.addObject(brick66,425,225);
        Brick brick67 = new Brick();
        dec.addObject(brick67,475,175);
        Unbreakable unbreakable1 = new Unbreakable();
        dec.addObject(unbreakable1,525,125);
        Brick brick69 = new Brick();
        dec.addObject(brick69,475,75);
        Brick brick70 = new Brick();
        dec.addObject(brick70,425,25);
        Brick brick71 = new Brick();
        dec.addObject(brick71,575,75);
        Brick brick72 = new Brick();
        dec.addObject(brick72,625,25);
        Brick brick73 = new Brick();
        dec.addObject(brick73,675,175);
        Brick brick74 = new Brick();
        dec.addObject(brick74,675,175);
        Brick brick75 = new Brick();
        dec.addObject(brick75,625,225);
        Brick brick76 = new Brick();
        dec.addObject(brick76,575,275);
        Brick brick77 = new Brick();
        dec.addObject(brick77,475,275);
        Brick brick78 = new Brick();
        dec.addObject(brick78,525,325);
        Brick brick79 = new Brick();
        dec.addObject(brick79,625,325);

        Brick brick81 = new Brick();
        dec.addObject(brick81,400,325);
        brick81.setLocation(425,325);
        Brick brick80 = new Brick();
        dec.addObject(brick80,475,275);
        Unbreakable unbreakable4 = new Unbreakable();
        dec.addObject(unbreakable4,625,125);
        Unbreakable unbreakable = new Unbreakable();
        dec.addObject(unbreakable,425,475);
    
    }

    
}
