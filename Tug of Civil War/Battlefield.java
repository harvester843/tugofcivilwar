import java.util.List;
import greenfoot.*;

/**
 * Write a description of class Battlefield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battlefield extends World
{
    private int reinforceDelayCount;
    private int reinforceTime = 100;
    private int count;
    private int secondwave=200;
    private int tofront = 100;
    private int reinforce = 100;
    private int health;
    public int score;
    public int score2;
   
    Counter counter = new Counter();
    ConfedCounter confedCounter = new ConfedCounter();
    Rope rope = new Rope();
    GeneralLee lee = new GeneralLee();
   

    /**
     * Constructor for objects of class Battlefield.
     * 
     */
    public Battlefield()
    {   
        super(763, 578, 1); 
        prepare();
        reinforceDelayCount = 100;
        count = 16;
        secondwave = 15;
    }

    public ConfedCounter getConfedCounter()
    {
        return confedCounter;
    }

    public Rope getRope()

    {
        return rope;
    }

    public Counter getCounter()
    {
        return counter;
    }

    public GeneralLee getLee()
    {
        return lee;
    }

    public void act ()
    {
        reinforcements();
        yankeeReinforcements();
        generalReinforcements();
        secondWave();

    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(confedCounter, 610,15);
        addObject(counter, 90,15);
        GeneralGrant grant = new GeneralGrant();
        addObject(grant, 15, 340);
        UnionSoldier soldier = new UnionSoldier();
        addObject(soldier, 15, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier10 = new UnionReinforcements();
        addObject(soldier10, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier11 = new UnionReinforcements();
        addObject(soldier11, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier12 = new UnionReinforcements();
        addObject(soldier12, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier13 = new UnionReinforcements();
        addObject(soldier13, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier2 = new UnionReinforcements();
        addObject(soldier2, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier3 = new UnionReinforcements();
        addObject(soldier3, 10, Greenfoot.getRandomNumber(570));
        UnionArtillery arty = new UnionArtillery();
        addObject(arty, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier4 = new UnionReinforcements();
        addObject(soldier4, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier5 = new UnionReinforcements();
        addObject(soldier5, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier6 = new UnionReinforcements();
        addObject(soldier6, 10, Greenfoot.getRandomNumber(570));
        UnionArtillery arty2 = new UnionArtillery();
        addObject(arty2, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier7 = new UnionReinforcements();
        addObject(soldier7, 10, Greenfoot.getRandomNumber(570));
        UnionReinforcements soldier8 = new UnionReinforcements();
        addObject(soldier8, 10, Greenfoot.getRandomNumber(570));

        GeneralLee general = new GeneralLee();
        addObject(general, 740, 360);
        ConfederateSoldier confedsoldier = new ConfederateSoldier();
        addObject(confedsoldier, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier2 = new ConfederateSoldier();
        addObject(confedsoldier2, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier3 = new ConfederateSoldier();
        addObject(confedsoldier3, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier4 = new ConfederateSoldier();
        addObject(confedsoldier4, 755, Greenfoot.getRandomNumber(640));
        ConfederateArtillery confedarty4 = new ConfederateArtillery();
        addObject(confedarty4, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier6 = new ConfederateSoldier();
        addObject(confedsoldier6, 755, Greenfoot.getRandomNumber(640));
        ConfederateArtillery confedarty = new ConfederateArtillery();
        addObject(confedarty, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier7 = new ConfederateSoldier();
        addObject(confedsoldier7, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier9 = new ConfederateSoldier();
        addObject(confedsoldier9, 755, Greenfoot.getRandomNumber(640));
        ConfederateSoldier confedsoldier8 = new ConfederateSoldier();
        addObject(confedsoldier8, 755, Greenfoot.getRandomNumber(640));

        addObject(rope, 385, 289);
    }

    public void reinforcements()
    {
        reinforceDelayCount++; // increment timer
        if (reinforceDelayCount >= reinforceTime) // if timer has reached limit
        {
            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(600));
            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(620));
            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(640));
            addObject(new ConfederateArtillery(), 750, Greenfoot.getRandomNumber(660));

            reinforceDelayCount = 0; // reset timer
        }
    }

    public void generalReinforcements()
    {
        reinforceDelayCount++; // increment timer
        if (reinforceDelayCount >= reinforceTime) // if timer has reached limit
        {

            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(600));
            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(620));
            addObject(new ConfederateReinforcements(), 750, Greenfoot.getRandomNumber(640));

            reinforceDelayCount = 0; // reset timer
        }
    }

    public void yankeeReinforcements()
    {
        count++; // increment timer
        if (count >= reinforce) // if timer has reached limit
        {
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(620));
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(640));
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(660));

            count = 0; // reset timer
        }
    }

    public void secondWave()
    {
        secondwave++; // increment timer
        if (secondwave >= tofront) // if timer has reached limit
        {
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(580));
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(600));
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(620));
            addObject(new UnionReinforcements(), 70, Greenfoot.getRandomNumber(640));

            UnionArtillery arty33 = new UnionArtillery();
            addObject(arty33, 10, Greenfoot.getRandomNumber(600));
            secondwave = 0; // reset timer
        }
    }

}
