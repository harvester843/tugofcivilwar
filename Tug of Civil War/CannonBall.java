import greenfoot.*;

/**
 * Write a description of class CannonBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CannonBall extends SmoothMover
{
   /** The damage this bullet will deal */
    private static final int damage = 64;
    
     private int move;
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    private int hit;
    //private int move;
    public CannonBall()
    {
      
    }
    
    public CannonBall(Vector speed, int rotation)
    {
        super(speed);
        setRotation(Greenfoot.getRandomNumber(90));
        addToVelocity(new Vector(rotation, 15));
       Greenfoot.playSound("EnergyGun.wav");
    }
   /* public void turnTowards()
    {
        turnTowards(ConfederateSoldier.getX(), ConfederateSoldier.class.getY());
    }*/
    
   
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-15);
        
        checkEnemy();
       // checkUnionReinforcements();
       
    
    }
    
  
        /**
     * Check whether we have hit an enemy.
     */
    
    private void checkEnemy()
    {
       UnionSoldier union = (UnionSoldier) getOneIntersectingObject(UnionSoldier.class);
       UnionReinforcements reinforcedUnion = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
       Battlefield battlefield = (Battlefield)getWorld();
         Rope rope = battlefield.getRope();
        if (union != null) 
        {
            rope.move(5);
            getWorld().removeObject(this);
            union.hit(damage);
            Counter count = battlefield.getCounter();
            count.addScore();
        }
        else if (reinforcedUnion != null)
        {
            rope.move(5);
            getWorld().removeObject(this);
            reinforcedUnion.hit(damage);
            Counter count = battlefield.getCounter();
            count.addScore();
        }
    }
    
    
    public void atEdge()
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
