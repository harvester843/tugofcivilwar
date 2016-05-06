import greenfoot.*;

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
    public Play()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       // super(763, 578, 1); 
        nextScreen2();
        
        Battlefield battlefield = new Battlefield();
    }
    
    public void act()
    {
       Play play = new Play();
    }
    
    public void nextScreen2()
    {
         if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Battlefield());
           // Greenfoot.setWorld(new Battlefield());
            
        }
    }
}
