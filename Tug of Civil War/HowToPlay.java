import greenfoot.*;

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends World
{

    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
    public HowToPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(763, 578, 1); 
        //HowToPlay play = new HowToPlay();
    }
    
    public void act()
    {
      if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Battlefield());
           // Greenfoot.setWorld(new Battlefield());
            
        }
    }
    
    public void nextScreen()
    {
        
    }
}
