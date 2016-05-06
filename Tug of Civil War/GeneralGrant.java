import greenfoot.*;

/**
 * General Grant sits around looking boss, commanding troops. If he dies you lose the game.
 * 
 * @author Benjamin Lipscomb
 * @version 12-13-15
 */
public class GeneralGrant extends Actor
{
    private int stability;
    public int dx = 0; // local field to hold movement along the x-axis
    public int dy = 0; // local field to hold movement along the y-axis
    int timer=0;
    int timer2=0;
    /**
     * Act - do whatever the GeneralLee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        walk();
    }    

    public GeneralGrant()
    {
        stability = 150; //general has 64HP
    }

    public void walk()
    {
        int gameTime = 0;
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

                setLocation(getX(), getY()+1);
            }
            else if(timer >= 300 && timer <= 400)
            {

                setLocation(getX(), getY()-3);

            }
            else if(timer >= 400 && timer <=500)
            {

                setLocation(getX(), getY()+3);
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
            grantDies();
        }
    }

    /**
     * Will end the game if the General is killed.
     */
    public void grantDies() 
    {
        Greenfoot.playSound("deathyell.mp3");
        World world = getWorld();
        world.removeObjects(world.getObjects(null));
        world.addObject(new GameOver(), world.getWidth()/2, world.getHeight()/2); //adds the game over screen in the middle of the world;
        Greenfoot.playSound("taps.mp3");
        Greenfoot.stop();
        return;
    }
}
