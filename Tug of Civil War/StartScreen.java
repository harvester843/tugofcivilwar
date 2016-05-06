import greenfoot.*;

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private GreenfootImage civilwar;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        
        super(763, 578, 1); 
        prepare();
       // civilwar = new GreenfootImage("civilwar2.jpg");
        
    }
    private void prepare()
    {
       // CivilWar war = new CivilWar();
       // addObject(war, 763, 578);
        
        Greenfoot.playSound("intro.mp3");

    }
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new HowToPlay());
           // Greenfoot.setWorld(new Battlefield());
            
        }
    }
}
