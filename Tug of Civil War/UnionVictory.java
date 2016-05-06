import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class UnionVictory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnionVictory extends Actor
{
    /**
     * Act - do whatever the UnionVictory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Union Victory", 48, Color.BLUE, null));
    }    

    public UnionVictory()
    {
        setImage(new GreenfootImage("Union Victory", 48, Color.BLUE, null)); 
    }

    public void unionWins()
    {
        setImage(new GreenfootImage("Union Victory", 48, Color.BLUE, null));
    }
}
