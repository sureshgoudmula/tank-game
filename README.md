# tank-game
The project is about a game developed using Greenfoot in java. This game revolves around two player battle tanks fighting against enemy tanks in order to win the game. The tanks have movement controls, rotation controls and shoot functionality. Using these features, the tanks move in any desired direction in search of enemy tanks to find and kill them. Players' score depends on the respective number of enemy tanks damaged or killed. The game ends when either all enemy tanks are destroyed or if both the players' lives are exhausted. The players' high score is then recorded for comparison with subsequent rounds' score.

## High Level Diagrams

### UI WireFrame

![UI Wireframe Final](https://user-images.githubusercontent.com/91751941/158706040-5af86cd3-fb71-4ab9-a3b6-b58d981f3636.png)

### Component Diagram

![Component Diagram](https://user-images.githubusercontent.com/91751941/158706078-9ffc8417-6c5e-4bb1-96b8-9c3497283fcb.jpeg)


### Class Diagrams For Each Pattern


Decorator

![Class Diagram Decorator](https://user-images.githubusercontent.com/91751941/158706138-47248d74-0e09-4b8c-9be0-807f6bd103f8.jpg)


StateMachine (for NPC Tank)

![ClassDiagramTankBrain](https://user-images.githubusercontent.com/91751941/158706239-64779f47-454f-48f0-9b1b-014652ef1841.png)

![NPCTankStateTransitionChart](https://user-images.githubusercontent.com/91751941/158706260-9155db80-b42c-4380-97ce-9e2dd9d56285.png)


The State Machine design pattern is used to control the behavior of the NPCTanks:
- An NPCTank object keeps an NPCTankBrain object as an attribute.
- Every frame, the NPCTank communicates what it senses to the NPCTankBrain, reads an order from the NPCTankBrain, and acts on it.
- The state transition rules are as follows:
  - States cannot transition to their opposite. (for example DriveForward into DriveBackward, or vice versa) If you want to undo what you just did, you should have just stayed still from the start. This I believe was a contributing factor for the early versions' spastic and chaotic movement.
  - Defeat has no transitions, not even self transitions, and all other states transition into Defeat on a zeroHealth event. The NPCTank is dead and about to be deleted
  - All states except Damaged and Defeat transition to Damaged on a takeDamage event. The Damaged state goes to Rest instead, giving already damaged tanks get a grace period before redamaging.
  - All states except Damaged and Shoot transition to Shoot on a seeEnemy event. Those two States transition to Rest instead; the tank is taking a moment to recover
  - All states except Damaged, Shoot, and DriveForward transition to DriveForward on a seeFriend event. Damaged and Shoot go to Rest, and DriveForward usually goes to DriveForward with a chance to go to TurnLeft or Turn Right. I wanted to encourage NPCTanks to travel in packs but give followers a chance to break off and do their own thing too.
  - On a seeWall event, all states exept Damged and Shoot (which both go to Rest) will randomly choose DriveBackward, TurnLeft, TurnRight, or Shoot. The exact weights vary between states, partly because of the above "no opposites" rule and partly to give extra weight to repeating the previous action to avoid jittery chaotic movement. The intended effet is that NPCTanks will avoid obstacles or open fire to clear a path. I included DriveBackward because I liked the idea of the tank backing up to make space for a turn or to get clear of the blast before shooting, even if the action isn't actually necessary.
  - On a seeNothing event, all states except Damaged and Shoot (which both go to Rest) randomly choose DriveBackward, DriveForward, TurnLeft, or TurnRight. Unlike with seeWall, Shoot is unavailable because there is nothing to shoot at. The exact weights vary between states for similar reasons as seeWall. Further, TurnLeft and Turn Right cannot go to DriveBackward. If the tank "wanted" to go in that direction, it would have turned the opposite way and picked DriveForward.

Singleton pattern (for handling level)

![LevelHandlerSingletonClassDiagram](https://user-images.githubusercontent.com/91751941/158706339-3249d09c-e1c3-47d0-9278-de027e036608.png)


Strategy Pattern (for Bullet Collision) 

![Twin Tanks Class Diagram](https://user-images.githubusercontent.com/91751941/158706430-4d30fd8f-fa80-4409-b8ea-253ded3602ca.png)

Design Notes:
- Two stragies are set for Bullet collision feature for all the tanks. 
  - Health1Stratgey: After a tank is collided with a bullet, it will get damaged. Therefore, damaged tank is displayed if the health reduces after bullet collision.
  - Health2Strategy: After the health is completely exhausted per life ( i.e. if health becomes zero), the skeleton image is displayed to show that the tank is dead. 
- "IBulletCollisionStrategy" acts as the interface for the strategies. 
- "Heath0Strategy" and "Health1Strategy" are the concrete strategies. 
- Tank class instantiates the "IBulletCollisionStrategy" interface object, using this object the specific strategies are set at respective times.  
- Initially for each tank "Health1Strategy" is assigned.  

ScoreManager is implemented using Singleton Design pattern. So that it can maintain all scores throughout the session. 
getBestScore() keep track of best score throughout the session.
addScore() adds 5points each time players destroy AI tank
reset() resets the players score after each game
getScore() calculate the score based on the health and lives of the player then added to original score

Command Pattern (for Tank movements, shoot, health features)

- Command pattern is used for implementing for tank movement controls

 - Interface used in this pattern is TankCommands which provides method to execute tank movement 
 - The keyboard key event handling classes i.e. UpKey, DownKey, LeftKey, RightKey implement TankCommands and provide their respective implementations for execute method
 - Abstract Class Tank holds references to each of the four key event classes.
 - The Player tank classes and enemy tank classes extend the abstract class Tank and thereby inherit the instances of the four key event classes.
 - Upon press of each direction keys, the command is passed on from the tank class to the respective direction class which shall then trigger the respective movement.

![CommandPattern](https://user-images.githubusercontent.com/89321642/144723466-504f6e0f-ab52-493b-8e0f-fd213f6356d2.png)



## Game Features

1. 2 Levels in the game.
2. 2 Player Game to enjoy with your friend
3. Keeps Track of the Highscore to see if you are improving or not
