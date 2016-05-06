import greenfoot.*;

/**
 * Write a description of class GatlingSoldier here.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class GatlingSoldier extends Actor
{
    int reloadDelayCount = 0;
    private int gunReloadTime = 10;
    private GreenfootImage gatling;
    private GreenfootImage gatlingfire;
    public GatlingSoldier()
    {
        reloadDelayCount = 5;
        gatling = new GreenfootImage("gatling2.png");
        gatlingfire = new GreenfootImage("gatlingfire.png");
    }
    /**
     * Act - do whatever the GatlingSoldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyPress();
        fireGatling();
        reloadDelayCount++;
    }    
     public void gatlingFire()
     {
         if (getImage() == gatling) 
        {
            
            setImage(gatlingfire);
        }
        else
        {
            
            setImage(gatling);
        }
     }
          /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeyPress()
    
    {
        if (Greenfoot.isKeyDown("a")) 
        {
           
            turn(-10);

        }
        if (Greenfoot.isKeyDown("d")) 
        {
            
            turn(10);
          
        }
        if (Greenfoot.isKeyDown("w")) 
        {
            
           move(5);
           
        }
        if (Greenfoot.isKeyDown("s")) 
        {
            
            move(-5);
  
        }
        if (Greenfoot.isKeyDown("space")) 
        {
            
          
        }
  
        if ("k".equals(Greenfoot.getKey()))
         {

            fireGatling();
        } 
    }  
    
           /**
     * Fire a bullet if the gun is ready.
     */
    private void fireGatling() 
    {
        if (reloadDelayCount >= gunReloadTime)
              {
                Bullets bullet = new Bullets();
                getWorld().addObject (bullet, getX()+19, getY());
                bullet.setRotation(getRotation());
                Greenfoot.playSound("CannonBlast.mp3");
                bullet.move();
                 reloadDelayCount = 0;
            }
            gatlingFire();
             reloadDelayCount++;
        }
}
