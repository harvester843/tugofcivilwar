import greenfoot.*;

/**
 * Write a description of class GeneralLee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GeneralLee extends Actor
{
    private int stability;
    public int dx = 0; // local field to hold movement along the x-axis
    public int dy = 0; // local field to hold movement along the y-axis
    public int timer = 0;
    public int gameTime = 0;
    public int damage = 0;
    /**
     * Act - do whatever the GeneralLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        walk();
    }    

    public GeneralLee()
    {
       stability=500;
    }

    public void walk()
    {
        if (dx * dy == 0)
        {
            setLocation(getX()+dx, getY()+dy);
        }
        timer++;
        if (gameTime < 10000)
        {
            if (timer < 100)
            {
                setLocation(getX(), getY()+1);
            }
            else if(timer >= 100 && timer <= 200)
            {
                setLocation(getX(), getY()-1);
            }
            else if(timer >= 200 && timer <=300)
            {
                setLocation(getX(), getY()-2);
            }
            else if(timer >= 300 && timer <= 400)
            {
                setLocation(getX(), getY()+2);
            }
            else if(timer >= 400 && timer <=500)
            {
                setLocation(getX(), getY()-3);
            }
            gameTime++;
        }

    }

    /**
     * Return the current amount of life of the General
     * 
     */
    public int getStability() 
    {
        return stability;
    }

    /**
     * Hit the General dealing the given amount of damage.
     */
    public void hit(int damage) 
    {
        stability = stability - damage;
        if (stability <= 0) 
        {
            generalDead();
        }
    }

    /**
     * Will end the game if the General is killed.
     */
    public void generalDead() 
    {
        Greenfoot.playSound("deathyell.mp3");
        World world = getWorld();
        world.removeObjects(world.getObjects(null));
        world.addObject(new UnionVictory(), world.getWidth()/2, world.getHeight()/2);
        Greenfoot.stop();
    }

}
