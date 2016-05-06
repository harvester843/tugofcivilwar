import greenfoot.*;

/**
 *Confederate gatling gun gets deployed if they win the tug of war. Shoots all union enemies.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class ConfederateGatling extends Actor
{
    int reloadDelayCount = 0;
    private int gunReloadTime = 10;
    private GreenfootImage confedgatling;
    private GreenfootImage confedgatlingfire;
    public ConfederateGatling()
    {
        reloadDelayCount = 5;
        confedgatling = new GreenfootImage("confedgatling1.png");
        confedgatlingfire = new GreenfootImage("confedgatling.png");
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
        lookForUnion();
        lookForGrant();
    }    
     public void gatlingFire()
     {
         if (getImage() == confedgatling) 
        {
            
            setImage(confedgatlingfire);
        }
        else
        {
            
            setImage(confedgatling);
        }
     }
          /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeyPress()
    
    {
        int dx = 0; // local field to hold movement along the x-axis
        int dy = 0; // local field to hold movement along the y-axis
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
            UnionReinforcements union = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
        }
        //firing(Greenfoot.isKeyDown("enter"));
        if ("k".equals(Greenfoot.getKey()))
         {
           UnionReinforcements union = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
           turnTowards(union.getX(), union.getY());
            fireGatling();
        } 
      
        if (dx * dy == 0)
        {
            setLocation(getX()+dx, getY()+dy); // if not diagonal movement, move (or stay, if no movement at all)
        }
    }  
    
           /**
     * Fire a bullet if the gatling gun is ready.
     */
    private void fireGatling() 
    {
        
        if (reloadDelayCount >= gunReloadTime)
              {          
                ConfederateBullet bullet = new ConfederateBullet();
                getWorld().addObject (bullet, getX()-19, getY());
                bullet.setRotation(getRotation());
                Greenfoot.playSound("CannonBlast.mp3");
                bullet.move();
                reloadDelayCount = 0;
            }
               gatlingFire();
               reloadDelayCount++;
        }
        
         public void lookForUnion()
    {
        UnionReinforcements union = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
        if (union != null) 
        {
            getWorld().removeObject(this);
            Battlefield battlefield = (Battlefield)getWorld();
           
        }
    }
    
          public void lookForGrant()
    {
        GeneralGrant grant = (GeneralGrant) getOneIntersectingObject(GeneralGrant.class);
        if (grant != null) 
        {
            getWorld().removeObject(this);
            Battlefield battlefield = (Battlefield)getWorld();
            
        }
    }
}
   
