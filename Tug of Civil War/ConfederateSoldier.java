import greenfoot.*;

/**
 * Marches and fires bullets at Union enemies.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */

public class ConfederateSoldier extends Actor
{   
      private int stability;
      private GreenfootImage deadconfed;
      private GreenfootImage confedmarch;
      private GreenfootImage confedmarch2;
      private GreenfootImage confedmakeready;
      private GreenfootImage confedsoldierfire;
      private static final int gunReloadTime = Greenfoot.getRandomNumber(150)+100;  
      private int reloadDelayCount;
      private int damage = 32;  //damage per bullet
      private int move;
      public int northScore;
      private int score2;
      public int csMove;
     /**
      * 
      */ 
    public ConfederateSoldier()
    {
        deadconfed = new GreenfootImage("deadconfed1.png");
        confedmarch = new GreenfootImage("confedsoldiermarch.png");
        confedmarch2 = new GreenfootImage("confedsoldier.png");
        confedmakeready = new GreenfootImage("confedsoldierfire.png");
        confedsoldierfire = new GreenfootImage("confedsoldierfire2.png");
        setImage(confedmarch);
        damage=32;
        stability = 32;  // gives the player 32HP
    }
     
    /**
     * Act - do whatever the ConfederateSoldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     // checkEnemyHit();
      readyFire();
      reloadDelayCount++;
      checkCollision();
    }
      
       /**
     * Alternate the soldier's image between confedmarch and confedmarch2.
     */
    public void switchImage()
    {
        if (getImage() == confedmarch) 
        {
            setImage(confedmarch2);
        }
        else
        {
            setImage(confedmarch);
        }
    }
    /**
     * Confederate Soldier will move a certain number of paces then stop and fire.
     */
    public void readyFire()
    {
        switchImage();
       if (move > 30 )
       {
            move(0);
            setImage(confedmakeready);
            if(getImage() == confedmakeready)
            {
                shoot();
                muzzleFlash();
            }
        }
            else
            {
                move(-1);
                move++;
            }
        }
        
           public void confedTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) 
        {
            move(Greenfoot.getRandomNumber(90)-45);
        }
        
    }
    /**
     * Alternates images between firing and not firing gun.
     */
    public void muzzleFlash()
    {
        if (getImage() == confedmakeready) 
        {
            setImage(confedsoldierfire);
        }
        else
        {
            setImage(confedmakeready);
        }
    }
         
       /**
     * Fire a bullet if the gun is ready.
     */
    private void shoot() 
    {
            if (reloadDelayCount >= gunReloadTime)
            {
            ConfederateBullet bullet = new ConfederateBullet();
            getWorld().addObject (bullet, getX()+3, getY()-7);
            bullet.setRotation(getRotation());
            Greenfoot.playSound("musketfire.mp3");
            setImage(confedsoldierfire);
            bullet.move();
            confedTurn();
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
           // setImage("deadconfed1.png");
            
            getWorld().removeObject(this);
           // move(Rope.class);
            
            
        }
    }
    
      /**
     * . If the ConfederateSoldier has no more HP, it dies.
     * 
     */
    private void breakUp() 
    {
        Greenfoot.playSound("deathscream.wav");
        if (stability == 0) {
            getWorld().removeObject(this);
           World world = getWorld();
            Battlefield battlefield = (Battlefield)getWorld();
            Counter counter = battlefield.getCounter();
            counter.addScore();
        }
        }
    
    /**
     * Check whether we have hit a UnionSoldier.
     */
    
    private void checkEnemyHit()
    {
        UnionSoldier confed = (UnionSoldier) getOneIntersectingObject(UnionSoldier.class);
        if (confed != null) 
        {
            
            
            //setImage(deadconfed);
            confed.hit(damage);
            getWorld().removeObject(this);
            World world = getWorld();
            Battlefield battlefield = (Battlefield)getWorld();
            Counter counter = battlefield.getCounter();
            counter.addScore();
            
        }
    }
    
    public void checkCollision()
    {
    if(isTouching(Bullets.class))
    {
         Battlefield battlefield = (Battlefield)getWorld();
        Rope rope = new Rope();
        rope.move(10);
        removeTouching(ConfederateSoldier.class);
       
        Counter count = battlefield.getCounter();
        count.addScore();
         
       // rope.unionPull();
    }
    }
    
    
   /* public boolean isEmpty()
    {
       ConfederateSoldier confed1 = (ConfederateSoldier) getOneIntersectingObject(ConfederateSoldier.class);
       if (confed1 != null)
       {
           true
        }
    }*/
    
    /*public void ropeSeek()
    {
      //  ConfederateSoldier confederate = 
       if (ConfederateSoldier.class != isTouching(Rope.class) )
       {
           turnTowards(Rope.class.getX(), Rope.class.getY());
        }
    }
   /* public boolean stayDead()
    {
        false;
    }*/
   
}
    
    

