import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class ConfederateBullet extends SmoothMover
{
    private int damage = 32;
    private int reloadDelayCount; 
    private int life = 32;
    private int hit;
    public ConfederateBullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, -15));
    }

    public ConfederateBullet()
    {

    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-10);
        checkEnemy();
    }

    /**
     * Check whether we have hit an Union Reinforcement.
     */

    public void checkUnionHit()
    {
        UnionReinforcements reiUnion = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
        if (reiUnion != null) 
        {
            getWorld().removeObject(this);
            reiUnion.hit(damage);
        }
    }

    public void checkEnemy()
    {
        UnionSoldier soldier = (UnionSoldier) getOneIntersectingObject(UnionSoldier.class);
        UnionArtillery arty = (UnionArtillery) getOneIntersectingObject(UnionArtillery.class);
        GeneralGrant general = (GeneralGrant) getOneIntersectingObject(GeneralGrant.class);
        UnionReinforcements reiUnion = (UnionReinforcements) getOneIntersectingObject(UnionReinforcements.class);
        Battlefield battlefield = (Battlefield)getWorld();
        Rope rope = battlefield.getRope();
        if (isTouching(UnionSoldier.class)) 
        {
            rope.move(5);
            getWorld().removeObject(this);
            soldier.hit(damage);
            Counter count = battlefield.getCounter();
            count.addScore();
        }

        else if (isTouching(UnionArtillery.class)) 
        {
            rope.move(10);
            Counter count = battlefield.getCounter();
            count.addScore();
            getWorld().removeObject(this);
            arty.hit(damage);
        }
        else if(isTouching(GeneralGrant.class))
        {
            Counter count = battlefield.getCounter();
            count.addScore();
            getWorld().removeObject(this);
            general.hit(damage);
        }
        else if (reiUnion != null) 
        {
            getWorld().removeObject(this);
            reiUnion.hit(damage);
            rope.move(10);
            Counter count = battlefield.getCounter();
            count.addScore();
        }
    }

    /*
     * Check whether we have hit an Union Artillery.
     */

    private void checkArty()
    {
        UnionArtillery arty = (UnionArtillery) getOneIntersectingObject(UnionArtillery.class);
        if (arty != null) 
        {
            getWorld().removeObject(this);
            arty.hit(damage);
        }
    }
}


