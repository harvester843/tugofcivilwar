import greenfoot.*;

/**
 * Fires cannonballs at a delayed rate at Confederate enemies.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class UnionArtillery extends Actor
{ 
    
    private GreenfootImage unionarty;
    private GreenfootImage unionartyfire;
    private static final int gunReloadTime = 100;
    private int blast;
    private int cannonDelayCount;
    private int stability = 64;
    private static final int cannonReloadTime = 200;  
    public int move;
    private static final int damage = 16;
    public UnionArtillery()
    {
       unionarty = new GreenfootImage("unionarty.png");
       unionartyfire = new GreenfootImage("unionartyfire.png");
       setImage(unionarty);
       stability = 64;
    }
    
    /**
     * Act - do whatever the ConfederateArtillery wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setImage(unionarty);
       primeCannon();
       checkEnemyHit();
       cannonDelayCount++;
    }    
    
          /**
     * Alternate the Union Artillery image between Artillery and Artillery firing.
     */
    public void cannonFire()
    {
        if (getImage() == unionarty) 
        {
            setImage(unionartyfire);
        }
        else
        {
            setImage(unionarty);
        }
    }
    
     /**
     * Return the current stability of the artillery. If it goes down to 
     * zero, it dies.
     */
    public int getStability() 
    {
        return stability;
    }
    
    
      /**
     * Hit this cannonball dealing the given amount of damage.
     */
    public void blast(int cannonDamage) 
    {
        stability = stability - cannonDamage;
        if (stability <= 0) 
        {
           // explode();
        }
    }
    
    
    /**
     * Sequence for artillery moving then firing at a random reload rate.
     */  
    public void primeCannon()
       {
     
       if (move > 60 )
       {
            move(0);
            if(getImage() == unionarty)
            {
                cannonBlast();
                cannonFire();
            }
        }
            else
            {
                move(1);
                move++;
            }
        }
   
    /**
     * Removes objects 
     * 
     */
    private void explode() 
    {
       // setImage(gameover);
        Greenfoot.playSound("deathyell.mp3");
        World world = getWorld();
        world.removeObjects(world.getObjects(null));
        
        }
    
          /**
     * Fire a cannonball if the cannon is ready.
     */
    private void cannonBlast() 
    {
            if (cannonDelayCount >= cannonReloadTime)
            {
            UnionCannonBall shot1 = new UnionCannonBall();
            getWorld().addObject (shot1, getX()+19, getY());
            shot1.setRotation(getRotation());
            Greenfoot.playSound("CannonBlast.mp3");
            shot1.move();
            cannonDelayCount = 0;
        }
        cannonDelayCount++;
        cannonFire();
    }
    
         /**
     * Hit the enemy dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
           // setImage("deadconfed1.png");
            
            getWorld().removeObject(this);
            
            
        }
    }
    
     /**
     * Check whether we have hit a Confederate enemy
     */
    
    private void checkEnemyHit()
    {
        ConfederateArtillery arty = (ConfederateArtillery) getOneIntersectingObject(ConfederateArtillery.class);
        if (arty != null) 
        {
            
            
            //setImage(deadconfed);
            arty.hit(damage);
            getWorld().removeObject(this);

        }
    }
}

