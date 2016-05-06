import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class Bullets extends SmoothMover
{
    private int damage = 32;
    private int hit;
    private int life = 32;
    public Bullets()
    {
        
    }

    public Bullets(Vector speed, int rotation)
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
        move(10);
        checkEnemyHit();
    }

    /**
     * Check whether we have hit an enemy.
     */

    public void checkEnemyHit()
    {
        ConfederateSoldier confed = (ConfederateSoldier) getOneIntersectingObject(ConfederateSoldier.class);
        ConfederateReinforcements confed2 = (ConfederateReinforcements) getOneIntersectingObject(ConfederateReinforcements.class);
        GeneralLee general = (GeneralLee) getOneIntersectingObject(GeneralLee.class);
        ConfederateArtillery artillery = (ConfederateArtillery) getOneIntersectingObject(ConfederateArtillery.class);
        Battlefield battlefield = (Battlefield)getWorld();
        ConfedCounter confedCounter = battlefield.getConfedCounter();
        Rope rope = battlefield.getRope();
        if (isTouching(ConfederateSoldier.class) )
        {
            rope.move(-5);
            getWorld().removeObject(this);
            confed.hit(damage);
            confedCounter.addScore();
        }
        else if (isTouching(ConfederateArtillery.class))
        {
            rope.move(-10);
            confedCounter.addScore();
            getWorld().removeObject(this);
            artillery.hit(damage);

        }
          else  if (isTouching(ConfederateReinforcements.class)) 
        {
            rope.move(-5);
            confedCounter.addScore();
            getWorld().removeObject(this);
            confed2.hit(damage);


        }
        else if (isTouching(GeneralLee.class))
        {
            rope.move(-5);
            confedCounter.addScore();
            general.hit(damage);
            getWorld().removeObject(this);

        }
      

    }

}


