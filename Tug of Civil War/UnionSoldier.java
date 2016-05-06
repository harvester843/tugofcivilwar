import greenfoot.*;

/**
 * Player controls the Union Soldier
 * 
 * @author Benjamin Lipscomb 
 * @version 12-13-15
 */
public class UnionSoldier extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    private GreenfootImage image5;
    private GreenfootImage image6;
    private GreenfootImage gameover;
    private int reloadDelayCount;
    private Vector velocity;
    private int stability;
    private int size;
    private int gunReloadTime = 10;
    public int dx = 0; // local field to hold movement along the x-axis
    public int dy = 0; // local field to hold movement along the y-axis
    private int score;
    
     /**
     * Create a UnionSolider and initialize its two images.
     */
    public UnionSoldier()
    {
        image1 = new GreenfootImage("unionsoldiermarch.png");
        image2 = new GreenfootImage("unionsoldier.png");
        image3 = new GreenfootImage("unionsoldierfire.png");
        image4 = new GreenfootImage("unionsoldierfire2.png");
        image5 = new GreenfootImage("unionkia.png");
        gameover = new GreenfootImage("metalgear.png");
        setImage(image1);
        reloadDelayCount = 5;
        stability = 200;
       
    }
    
    /**
     * Act - do whatever the UnionSoldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      checkKeypress();
      reloadDelayCount++;
      reinforcements();
      counter++;
      checkCollision();
    }    

       /**
     * Alternate the soldiers image to marching.
     */
    public void switchImage()
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }
        else
        {
            setImage(image1);
        }
    }
    
    
        /**
     * Alternate the soldiers image between standing and ready to fire.
     */
    public void makeReady()
    {
        if (getImage() == image1) 
        {
            setImage(image3);
        }
        else
        {
            setImage(image1);
        }
        
    }

    
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    
    {
        int dx = 0; // local field to hold movement along the x-axis
        int dy = 0; // local field to hold movement along the y-axis
        if (Greenfoot.isKeyDown("left")) 
        {
            dy--;
            switchImage();
        }
        if (Greenfoot.isKeyDown("right")) 
        { 
            dy++;
            switchImage();
        }
        if (Greenfoot.isKeyDown("up")) 
        {          
           move(5);
           switchImage();          
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            move(-5);
            switchImage();
        }
        if (Greenfoot.isKeyDown("enter")) 
        {
            
            setImage(image3);
        }

        if ("space".equals(Greenfoot.getKey()))
         {
            fire();
        } 
      
        if (dx * dy == 0)
        {
            setLocation(getX()+dx, getY()+dy);
        }
    }  
    
    private void checkCollision()
    {
    if(isTouching(ConfederateBullet.class))
    {
        removeTouching(UnionSoldier.class);
        Battlefield battlefield = (Battlefield)getWorld();
        ConfedCounter count = battlefield.getConfedCounter();
        count.addScore();
        Rope rope = battlefield.getRope();
        rope.move(10);
    }
    }
    
    /**
     * Return the current health of the union soldier.
     * 
     */
    public int getStability() 
    {
        return stability;
    }
    /**
     * Hit this Union soldier dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            breakUp();
        }
    }
    
    /**
     *
     * 
     */
    private void breakUp() 
    {
        setImage(gameover);
        Greenfoot.playSound("deathyell.mp3");
        Greenfoot.playSound("taps.mp3");
        World world = getWorld();
        world.removeObjects(world.getObjects(null)); //removes all the objects in the world;
        world.addObject(new GameOver(), world.getWidth()/2, world.getHeight()/2); //adds the game over screen in the middle of the world;
        Greenfoot.stop();
        return;
        }
        
      /**
     * Alternates image between firing and not firing.
     **/
    private void firing() 
    {
        if (getImage () == image4) 
        {
            setImage(image3);
            
        }
        else 
        {
            setImage(image3);        
        }
    }
    /**
     * Creates muzzle flash when the gun is fired.
     */
     public void muzzleFire()
    {
        if (getImage() == image3) 
        {
            setImage(image4);
            firing();
        }
        else
        {
            setImage(image3);
        }
    }
    private int counter;
    public void reinforcements()
    {
        if ( UnionReinforcements.counter == 5)
        {
            getWorld().addObject(new UnionReinforcements(),200, 200);
            counter = 0;
         }
         counter++;
    }
    
       /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
              
              if (reloadDelayCount >= gunReloadTime)
              {
                Bullets bullet = new Bullets();
                getWorld().addObject (bullet, getX()+3, getY()-7);
                bullet.setRotation(getRotation());
                
                Greenfoot.playSound("musketfire.mp3");
                bullet.move();
                setImage(image4);
                
                reloadDelayCount = 0;
              }
              
              reloadDelayCount++;
              muzzleFire();
    }
    }
    
    
   
  
 
