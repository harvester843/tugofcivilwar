import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class GameOver here.
 * 
 * @author Benjamin Lipscomb 
 * @version 12-13-15
 */
public class GameOver extends Actor
{
    public GameOver()
    {
        setImage(new GreenfootImage("Confederate Victory", 48, Color.RED, null));
    }

    public GameOver(String txt)
    {
        updateImage();
    }

    public void unionWins()
    {
        setImage(new GreenfootImage("Union Pyrrhic Victory", 48, Color.BLUE, null));
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(getWorld().getWidth(), getWorld().getHeight()); // or whatever size you want the object
        image.setColor(Color.cyan); // color of your choice
        image.fill();
    }
}

