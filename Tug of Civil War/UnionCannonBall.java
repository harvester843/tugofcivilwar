import greenfoot.*;

/**
 * Cannonball that gives damage to Confederate actors only.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class UnionCannonBall extends SmoothMover
{
    private static final int damage = 32;
    public int casualties = 1;
    private int move;
    private int life = 30;
    private int hit;
    public UnionCannonBall()
    {

    }

    public UnionCannonBall(Vector speed, int rotation)
    {
        super(speed);
        setRotation(Greenfoot.getRandomNumber(90));
        addToVelocity(new Vector(rotation, 15));
        Greenfoot.playSound("EnergyGun.wav");
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(15);
        checkEnemy();
    }

    /**
     * Check whether we have hit a Confederate enemy.
     */

    private void checkEnemy()
    {
        ConfederateSoldier confed = (ConfederateSoldier) getOneIntersectingObject(ConfederateSoldier.class);
        ConfederateArtillery arty = (ConfederateArtillery) getOneIntersectingObject(ConfederateArtillery.class);
        ConfederateReinforcements confed2 = (ConfederateReinforcements) getOneIntersectingObject(ConfederateReinforcements.class);
        Battlefield battlefield = (Battlefield)getWorld();
        ConfedCounter confedCounter = battlefield.getConfedCounter();
        Rope rope = battlefield.getRope();
        if (isTouching(ConfederateSoldier.class)) 
        {
            getWorld().removeObject(this);
            confed.hit(damage);
            rope.move(-5);
            confedCounter.addScore();
        }
        else if (isTouching(ConfederateArtillery.class))
        {
            getWorld().removeObject(this);
            arty.hit(damage);
            rope.move(-10);
            confedCounter.addScore();
        }
        else if (isTouching(ConfederateReinforcements.class)) 
        {
            getWorld().removeObject(this);
            confed2.hit(damage);
            rope.move(-5);
            confedCounter.addScore();
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

