/**
 * ScoreManager implements Singleton Design Pattern to maintain scores throughout the session.
 * 
 * @author (Yash Trivedi) 
 * @version (v1)
 */
public class ScoreManager  
{
    // instance variables - replace the example below with your own
    private int score;
    private int bestScore;
    private final static int POINTS = 5;
    private static ScoreManager scoreManager = null;
    
    public static ScoreManager getNewInstance(){
        scoreManager = new ScoreManager();
        return scoreManager;
    }
    
    public static ScoreManager getInstance(){
        if(scoreManager == null){
            getNewInstance();
        }
        return scoreManager;
    }
    
    public ScoreManager(){
        score = 0;
        bestScore = Integer.MIN_VALUE;
    }
 /*Calculates the score based on the health and lives of the players*/   
    public int getScore(){
        LevelHandler levelHandler = LevelHandler.getInstance();
        
        int[][] stats = levelHandler.getCurrentTankStatus();
        score += stats[0][0] * 10 + stats[0][1] * 2;
        score += stats[1][0] * 10 + stats[1][1] * 2;
        return score;
    }
  /*adds 5 points each time players destroy AI tank*/  
    public void addScore(){
        score += POINTS;
    }
/*Resets the player score after each game*/  
    public void reset(){
        score = 0;
    }
/*Keeps track of Best Score throughout the session*/
    public int getBestScore(int score){
        if(bestScore < score){
            bestScore = score;
        }
        return bestScore;
    }
    
}
