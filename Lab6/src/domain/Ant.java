package domain;
import java.awt.Color;
import java.util.Random;

/**Information about a Ant<br>
<b>(colony,row,column,age,state,nextState, color)</b><br>
<br>
 */
public class Ant extends Agent implements Entity{
    protected char nextState;
    protected Color color;
    private Colony colony;
    protected int row,column;
    protected char soy = 'H';


    /**Create a new Ant (<b>row,column</b>) in the colony <b>colony</b>.
     * Every new Ant is going to be alive in the following state.
     * @param colony 
     * @param row 
     * @param column 
     */
    public Ant(Colony colonyy,int roww, int columnn){
        colony = colonyy;
        row=roww;
        column=columnn;
        nextState=Agent.ALIVE;
        colony.setEntity(row,column,this);  
        color=Color.black;
    }
    
    
    /**Returns the shape
    @return 
     */
    public final int shape(){
        return Entity.INSECT;
    }
    
    
    public void setRow(int nRow){
        this.row = nRow;
    }
    
    
    public void setColumn(int nColumn){
        this.column = nColumn;
    }
    
    
    /**Returns the row
    @return 
     */
    public final int getRow(){
        return row;
    }
    
    
    /**Returns tha column
    @return 
     */
    public final int getColumn(){
        return column;
    }

    /**Returns the color
    @return 
     */ 
    public final Color getColor(){
        return color;
    }
    
     public void move(){
        Random rand = new Random();
        int nuevaFila = rand.nextInt((colony.getLength()-0) + 1) + 0; 
        int nuevaColumna = rand.nextInt((colony.getLength()-0) + 1) + 0; 
        setRow(nuevaFila);
        setColumn(nuevaColumna);
    }

    public  void act(){
        turn();
        move(); 
    }
    
    public char getSoy(){
        return soy;
    }
}
