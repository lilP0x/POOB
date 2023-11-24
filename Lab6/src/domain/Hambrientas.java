package domain;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;


/**
 * Write a description of class Hambrientas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hambrientas extends Ant 
{
    protected char nextState;
    private Colony colony;
    protected int row,column;
    protected char soy = 'S';
    

    /**
     * Constructor for objects of class Hambrientas
     */
    public Hambrientas(Colony colonyy,int row, int column){
        super(colonyy, row, column);
        this.colony = colonyy;
        color = Color.green;
    }

  
     public void move(){
        Random rand = new Random();
        int nuevaFila = rand.nextInt((colony.getLength()-0) + 1) + 0; 
        int nuevaColumna = rand.nextInt((colony.getLength()-0) + 1) + 0; 
        setRow(nuevaFila);
        setColumn(nuevaColumna);
    }
    
    public void setColor(Color coll){
        this.color = coll;
    }

    
    @Override
    public  void act(){
        if (getAge() == 0 || getAge() == 10){
            ArrayList<Integer> food = food();
            setRow(food.get(0));
            setColumn(food.get(1));
            int newRow = food.get(0);
            int newColumn = food.get(1);
            System.out.println(row);
            System.out.println(column);
            colony.setEntity(row, column, this);
            colony.setEntity(newRow, newColumn, null);
        }else{
            move(); 
        }
        turn();
    }
    
    private ArrayList<Integer> food(){
        int m = 0;
        ArrayList<Integer> food = new ArrayList<Integer>();
        for (int i = 0; i < colony.getLength(); i++) {
            for (int j = 0; j < colony.getLength(); j++) {
                Entity entity = colony.getEntity(i,j);
                if (entity != null && entity.getSoy() == 'F'){
                    food.add(m);
                    food.add(m+1);
                    m += 2;
                }
            }
        }
        return food;
    }
}