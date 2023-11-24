package domain;
import java.awt.Color;


/**
 * Write a description of class Flower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flower implements Entity
{
    // instance variables - replace the example below with your own
    private int x;
    protected char soy = 'P';
    private Color color = Color.red;
     private boolean isRound = true;
    /**
     * Constructor for objects of class Flower
     */
    public Flower()
    {
    
        
    }
    public void act(){
        isRound =  !isRound;
        if (color.equals(Color.red)){
            color = Color.green;
        }
        else{
            color = Color.red;
        }
    }
    public int getRow(){
        return 5;
    }
    public int getColumn(){
        return 5;
    }
    
    public char getSoy(){
        return soy;
    }
}
