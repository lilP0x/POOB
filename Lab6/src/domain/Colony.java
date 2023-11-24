package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class Colony{
    static private int LENGTH=30;
    private Entity[][] colony;
    protected int ticTacs = 0;
    
    public Colony() {
        colony=new Entity[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                colony[r][c]=null;
            }
        }
        setEntity(0,0,new Food());
        setEntity(0,1,new Food());
        setEntity(0,2,new Food());
        setEntity(1,0,new Food());
        setEntity(1,1,new Food());
        setEntity(0,8,new Flower());
        setEntity(0,10,new Flower());
        someEntities();
    }

    public int  getLength(){
        return LENGTH;
    }

    public Entity getEntity(int r,int c){
        return colony[r][c];
    }

    public void setEntity(int r, int c, Entity e){
        colony[r][c]=e;
    }

    public void someEntities(){
        Ant a = new Ant(this, 0, 10);
        Ant flik = new Ant(this, 10, 10);
        Ant molt = new Ant(this, 15, 15); 
        Hambrientas rachel = new Hambrientas(this, 10, 20);
        Hambrientas monica = new Hambrientas(this, 20, 15); 
        
    }
    
    public void ticTac(){
        ticTacs++;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                Entity entity = colony[i][j];
                if (entity != null && entity.getSoy() == 'S' && ticTacs % 10 == 0){
                    entity.act();
                    int[] food = food(i,j);
                    colony[i][j] = null;
                }
                if (entity != null && (entity.getSoy() == 'H' || entity.getSoy() == 'S')){
                    entity.act();
                    int row = entity.getColumn();
                    int column = entity.getRow();
                    if (row >= 0 && row < LENGTH && column >= 0 && column < LENGTH && colony[row][column] == null && ticTacs < 50) {
                        colony[i][j] = null;
                        colony[row][column] = new Ant(this, row, column);
                    }
                }else if (entity != null && entity.getSoy() == 'P'){
                    entity.act();
                }
                if(ticTacs >= 50){
                        colony[i][j] = null;
                    }
            }
        }
        
    }    
    
    private int[] food(int i,int j){
        int [] food = new int[2];
        Entity entity = colony[i][j];
        if (entity != null && entity.getSoy() == 'F'){
             food[0] = i;
             food[1] = j;
        }
        return food;
    }
}

    

