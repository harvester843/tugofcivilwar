import greenfoot.*;

/**
 * Union Reinforcemtns deploy and fire at confederate enemies
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class UnionReinforcements extends UnionSoldier
{
    
      private int stability;
      private GreenfootImage deadconfed;
      private GreenfootImage unionmarch;
      private GreenfootImage unionmarch2;
      private GreenfootImage unionsoldierfire;
      private GreenfootImage unionsoldierfire2;
      private static final int gunReloadTime = Greenfoot.getRandomNumber(150)+100;  
      private int reloadDelayCount;
      private static final int damage = 32;  //damage per bullet
      private int move;
      public static int counter;
     public UnionReinforcements()
    {
        unionmarch = new GreenfootImage("unionsoldiermarch.png");
        unionmarch2 = new GreenfootImage("unionsoldier.png");
        unionsoldierfire = new GreenfootImage("unionsoldierfire.png");
        unionsoldierfire2 = new GreenfootImage("unionsoldierfire2.png");
        setImage(unionmarch);
        stability = 32;  // gives the player 32HP
    }
    
     public void act() 
    {
    //  reinforce();
      counter++;
      //checkEnemyHit();
     // checkCsHit();
      readyMarch();
      reloadDelayCount++;    
      checkCollision();
    }
    /**
     * Alternate the soldier's image to appear to be marching.
     */
    public void switchImage()
    {
        if (getImage() == unionmarch) 
        {
            
            setImage(unionmarch2);
        }
        else
        {
            
            setImage(unionmarch);
        }
    }
    /**
     * Makes the union reinforcements march then fire at confederate enemies.
     */
    public void readyMarch()
    {
        switchImage();
       if (move > 40)
       {
            move(0);
            setImage(unionsoldierfire);
            if(getImage() == unionsoldierfire)
            {
                shoot();
                muzzleFlash();
            }
        }
            else
            {
                move(1);
                move++;
            }
        }
    /**
     * Creates a muzzle flash.
     */
    public void muzzleFlash()
    {
        if (getImage() == unionsoldierfire) 
        {
            setImage(unionsoldierfire2);
        }
        else
        {
            setImage(unionsoldierfire);
        }
    }
         
       /**
     * Fire a bullet if the gun is ready.
     */
    private void shoot() 
    {
            if (reloadDelayCount >= gunReloadTime)
            {
            Bullets bullet = new Bullets();
            getWorld().addObject (bullet, getX()+3, getY()-7);
            bullet.setRotation(getRotation());
            Greenfoot.playSound("musketfire.mp3");
            setImage(unionsoldierfire);
            bullet.move();
            reloadDelayCount = 0;
            
        }
        reloadDelayCount++;
        muzzleFlash();
    }
    
    /**
     * Return the current life of ConfederateSoldier. 
     * 
     */
    public int getStability() 
    {
        return stability;
    }
    
     /**
     * Hit the Confederate Soldier dealing the given amount of damage.
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
     * . If the ConfederateSoldier has no more HP, it dies.
     * 
     **/
    private void breakUp() 
    {
        Greenfoot.playSound("deathscream.wav");
       // setImage(deadconfed);
        if (stability == 0) {
            getWorld().removeObject(this);
            Battlefield battlefield = (Battlefield) getWorld();
            battlefield.getCounter();
           
        }
        }
    
    /**
     * Check whether we have hit a Confederate enemy.
     */
    
    private void checkEnemyHit()
    {
        ConfederateSoldier confed = (ConfederateSoldier) getOneIntersectingObject(ConfederateSoldier.class);
        if (confed != null) 
        {
            confed.hit(damage);
            getWorld().removeObject(this);
        }
    }
    private void checkCsHit()
       {
        ConfederateReinforcements reConfed = (ConfederateReinforcements) getOneIntersectingObject(ConfederateReinforcements.class);
        if (reConfed != null) 
        {
            reConfed.hit(damage);
            getWorld().removeObject(this);
        }
    }
    private void checkCollision()
    {
    if(isTouching(ConfederateBullet.class))
    {
        removeTouching(UnionReinforcements.class);
        Battlefield battlefield = (Battlefield)getWorld();
       // battlefield.addScore(10);
      
        Counter count = battlefield.getCounter();
        count.addScore();
    }
    if (isTouching( CannonBall.class))
    {
        removeTouching(UnionReinforcements.class);
        Battlefield battlefield = (Battlefield)getWorld();
       // battlefield.addScore(10);
      
        Counter count = battlefield.getCounter();
        count.addScore();
    }
}
    
  
  /*  public void reinforce()
    {
        counter = counter + 1;
        World world = getWorld();
        
        if (counter == 10)
        {
            getWorld().addObject(new UnionReinforcements(), 300, 200);
            getWorld().addObject(new UnionReinforcements(), 300, 240);
            getWorld().addObject(new UnionReinforcements(), 300, 260);
            return;
        }
        
    }*/
  }

