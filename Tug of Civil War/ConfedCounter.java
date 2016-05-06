import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class ConfedCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConfedCounter extends Actor
{
    int southScore = 0;
    /**
     * Act - do whatever the ConfedCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(new GreenfootImage("Confederate Casualties: " + southScore, 25, Color.WHITE,null));
    }    
    
     public void addScore()
    {
        southScore++;
    }
}
