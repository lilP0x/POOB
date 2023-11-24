package domain;
import java.awt.Color;

public final class Food  implements Entity{
    protected char soy = 'F';
    private Color color = Color.orange;
    public void act(){
         
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
