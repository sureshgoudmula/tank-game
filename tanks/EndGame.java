import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays Exit Page and Player Scores
 * 
 * @Suresh Goud Mula 
 * @1.0
 */
public class EndGame extends World
{

    public EndGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        showScore();
    }
    
    public void showScore(){
        ScoreManager scoreManager = ScoreManager.getInstance();
        int score = scoreManager.getScore(); 
        showText("Score:  "+score, 325,125);
        showText("Best Score : "+scoreManager.getBestScore(score), 325, 175);
        LevelHandler levelHandler = LevelHandler.getInstance();
        levelHandler.reset();
        Exit exit = new Exit();
        addObject(exit, 350, 325);
    }
    public int calculateScore(int[] player){
        int x = player[0]*10;
        int y = player[1]*20;
        return x+y;
    }
}
