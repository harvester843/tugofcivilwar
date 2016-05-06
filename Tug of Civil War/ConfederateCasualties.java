import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class ConfederateCasualties here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConfederateCasualties extends Counter
{
    int southScore = 0;
    /**
     * Act - do whatever the ConfederateCasualties wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         setImage(new GreenfootImage("Confederate Casualties: " + northScore, 25, Color.WHITE,null));
    }   
    
     public void addScore()
    {
        southScore++;
    }
}
