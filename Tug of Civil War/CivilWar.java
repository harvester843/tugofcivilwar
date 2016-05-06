import greenfoot.*;

/**
 * Write a description of class CivilWar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CivilWar extends Actor
{
    private GreenfootImage civilwar;
    /**
     * Act - do whatever the CivilWar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CivilWar ()
    {
      // civilwar = new GreenfootImage("civilwar2.jpg");
       nextScreen();
    }
    public void act() 
    {
        CivilWar war = new CivilWar();
       // addObject(war, 763, 578);
        
        Greenfoot.playSound("intro.mp3");
        
    }    
    
    private void nextScreen()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            //Greenfoot.setWorld(new Battlefield());
            Greenfoot.setWorld(new HowToPlay());
        }
    }
}
