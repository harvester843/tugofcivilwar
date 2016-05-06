import greenfoot.*;

/**
 * Write a description of class ConfederateArtillery here.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class ConfederateArtillery extends Actor
{
    private GreenfootImage confedarty;
    private GreenfootImage confedartyfire;
    private static final int gunReloadTime = 100;
    private int hit;
    private int cannonDelayCount;
    private int stability = 64;
    private static final int cannonReloadTime = 200;  
    public int move;
    private static final int damage = 16;
    public ConfederateArtillery()
    {
       confedarty = new GreenfootImage("confedarty.png");
       confedartyfire = new GreenfootImage("confedartyfire.png");
       setImage(confedarty);
       stability = 64;
    }
    
    /**
     * Act - do whatever the ConfederateArtillery wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(confedarty);
       primeCannon();
       cannonBlast();
       checkEnemyHit();
       //cannonFire();
       cannonDelayCount++;
    }    
    
          /**
     * Alternate the artillery image between artillery and artillery firing.
     */
    public void cannonFire()
    {
        if (getImage() == confedarty) 
        {
            setImage(confedartyfire);
        }
        else
        {
            setImage(confedarty);
        }
    }
    
     /**
     * Return the amount of life the ConfederateArtillery has.
     *
     */
    public int getStability() 
    {
        return stability;
    }
    
    /**
     * Sequence for the Confederate Artillery marching and firing.
     */ 
    public void primeCannon()
    {
       if (move > 60 )
       {
            move(0);
            setImage(confedartyfire);
            if(getImage() == confedartyfire)
            {
                cannonBlast();
                cannonFire();
            }
        }
            else
            {
                move(-1);
                move++;
            }
        }
   
    /**
     * Kills and removes the cannon.
     */
    private void explode() 
    {
        Greenfoot.playSound("deathyell.mp3");
        World world = getWorld();
        world.removeObjects(world.getObjects(null));
        return;
        }
    
          /**
     * Fire a cannonball if the cannon is ready.
     */
    private void cannonBlast() 
    {
            if (cannonDelayCount >= cannonReloadTime)
            {
            CannonBall shot = new CannonBall();
            getWorld().addObject (shot, getX()-19, getY());
            shot.setRotation(getRotation());
            Greenfoot.playSound("CannonBlast.mp3");
            shot.move();
            cannonDelayCount = 0;
            }
            cannonDelayCount++;
            cannonFire();
    }
    
         /**
          * Defines the hit damage done to an enemy.
          */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
     /**
     * Check whether we have hit a UnionSoldier.
     */
    
    private void checkEnemyHit()
    {
        UnionArtillery arty = (UnionArtillery) getOneIntersectingObject(UnionArtillery.class);
        if (arty != null) 
        {
            arty.hit(damage);
            getWorld().removeObject(this);
        }
    }
}
