import greenfoot.*;
import java.util.List;
/**
 * Narch and fire bullets at Union enemies
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class ConfederateReinforcements extends ConfederateSoldier
{
    
      private int stability;
      private GreenfootImage deadconfed;
      private GreenfootImage confedmarch;
      private GreenfootImage confedmarch2;
      private GreenfootImage confedmakeready;
      private GreenfootImage confedsoldierfire2;
      private static final int gunReloadTime = Greenfoot.getRandomNumber(150)+100;  
      private int reloadDelayCount;
      private int damage = 32;  //damage per bullet
      private int move;
      public int casualties;
      public int northcasualties;
      public static int cRCounter;
      public int northScore;
      Counter counter = new Counter();
     public ConfederateReinforcements()
    {
         deadconfed = new GreenfootImage("deadconfed1.png");
        confedmarch = new GreenfootImage("confedsoldiermarch.png");
        confedmarch2 = new GreenfootImage("confedsoldier.png");
        confedmakeready = new GreenfootImage("confedsoldierfire.png");
        confedsoldierfire2 = new GreenfootImage("confedsoldierfire2.png");
        setImage(confedmarch);
        damage = 32;
        stability = 16;  // gives the player 32HP
        casualties = 1;
        northcasualties = 0;
       
    }
    
     public void act() 
    {
      cRCounter++;
      reloadDelayCount++;
      readyMarch();
     // breakUp();
      checkCollision();
      //checkUnionHit();
    }
    /**
     * Alternate the soldier's image between confedmarch and confedmarch2.
     */
    public void switchImage()
    {
        //Greenfoot.playSound("SoldiersMarching.mp3");
        if (getImage() == confedmarch) 
        {
            
            setImage(confedmarch2);
        }
        else
        {
            
            setImage(confedmarch);
        }
    }
    
    public void checkCollision()
    {
    if(isTouching(Bullets.class))
    {
       // removeTouching(ConfederateReinforcements.class);
       Battlefield battlefield = (Battlefield)getWorld();
       // battlefield.addScore2(1);
        Rope rope = new Rope();
        rope.moveRope();
        
            Counter count = battlefield.getCounter();
            count.addScore();
    }
    }
    
    /**
     * Confederate Reinforcements march and fire.
     */
    public void readyMarch()
    {
        switchImage();
       if (move > 30 )
       {
            move(0);
            setImage(confedmakeready);
            if(getImage() == confedmakeready)
            {
                fireGuns();
                muzzleFlash();
            }
        }
            else
            {
                move(-1);
                move++;
            }
        }
    /**
     * Creates muzzle flash when bullet is fired.
     */
    public void muzzleFlash()
    {
        if (getImage() == confedmakeready) 
        {
            setImage(confedsoldierfire2);
        }
        else
        {
            setImage(confedmakeready);
        }
    }
         
       /**
     * Fire a bullet if the gun is ready.
     */
    private void fireGuns() 
    {
        if (reloadDelayCount >= gunReloadTime)
        {
            ConfederateBullet bullet = new ConfederateBullet();
            getWorld().addObject (bullet, getX()+3, getY()-7);
            bullet.setRotation(getRotation());
            Greenfoot.playSound("musketfire.mp3");
            setImage(confedsoldierfire2);
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
           
             //Greenfoot.playSound("deathscream.wav");
            getWorld().removeObject(this);

        }
    }
    
      /**
     * . If the ConfederateSoldier has no more HP, it dies.
     * 
     */
    public void breakUp() 
    {
        Greenfoot.playSound("deathscream.wav");
        if (stability == 0) {
            getWorld().removeObject(this);
             World world = getWorld();
            Battlefield battlefield = (Battlefield)getWorld();
            Counter count = battlefield.getCounter();
            count.addScore();
            
        }
        }
    
    /**
     * Check whether we have hit a UnionSoldier.
     */
    
    private void checkEnemyHit()
    {
        UnionSoldier union = (UnionSoldier) getOneIntersectingObject(UnionSoldier.class);
        if (union != null) 
        {
            union.hit(damage);
            getWorld().removeObject(this);
            Battlefield battlefield = (Battlefield)getWorld();
            battlefield.getCounter();
            counter.addScore();
            Rope rope = battlefield.getRope();
            rope.move(10);
           
        }
    }
 
       /**
     * Check whether we have hit a UnionSoldier.
     */
    
    private void checkUnionHit()
    {
        UnionReinforcements reUnion = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
        if (reUnion != null) 
        {
            reUnion.hit(damage);
            getWorld().removeObject(this);
        }
    }
  
    public void csReinforce()
    {
        cRCounter = cRCounter + 1;
        World world = getWorld();
        
        if (cRCounter == 10)
        {
            getWorld().addObject(new ConfederateReinforcements(), 300, 200);
            getWorld().addObject(new ConfederateReinforcements(), 300, 240);
            getWorld().addObject(new ConfederateReinforcements(), 300, 260);
            return;
            // getWorld().removeObject(this);
             
        }
        
    }
  }