import greenfoot.*;

/**
 * Rope gets pulled to whoever's side is touching it. Whoever wins gets a gatling gun deployed.
 * 
 * @author Benjamin Lipscomb 
 * @version 12-13-15
 */
public class Rope extends Actor
{
   // int move = 0;
    /**
     * Act - do whatever the Rope wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        confedGatling();
    }    
   
    public void moveRope()
    {
        move(1);
    }
  
    GatlingSoldier gatling = new GatlingSoldier();
    /**
     * If the rope is at the edge of the map it deploys a gatling gun and removes itself.
     */
   public void gatling()
    
     {    
       if (isAtEdge()) 
       {  
           getWorld().addObject(gatling, 700, 200);
           getWorld().removeObject(this);
      }
    }
  
    ConfederateGatling confederategatling = new ConfederateGatling();
    /**
     * Adds a confederate or union gatling gun.
     */
    public void confedGatling()
    
     {    
       if (getX()>760 &&getX()<763) //if the rope is pulled to the confederate side a confederate gatling gun deploys
       {
           //add the coordinates ↑  
           getWorld().addObject(confederategatling, 700, 400);
           getWorld().removeObject(this);
        }
           else if ( isAtEdge())
           {
           getWorld().addObject(gatling, 10, 300);
           getWorld().removeObject(this);
        }
           
    
      }
    }


