/**
 * Write a description of class IBulletCollisionStrategy here.
 * 
 * @author Shafeeq
 * @version 1.0
 */
public interface IBulletCollisionStrategy  
{
    
    void display(Tank t); // Parameter: Tank object. To display the appropriate strategy after bullet collision. 
    public String getCurrentStrategy(); // Get the current strategy name
}
