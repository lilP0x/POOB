package domain;
import java.util.*;
import java.io.File;


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
        setEntity(20,10,new Flower());
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
        Lentas rache = new Lentas(this, 15, 25);
        Lentas monic = new Lentas(this, 23, 15);         
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
      
   /**
 * Placeholder method for the 'open' operation.
 *
 * @param file The file to be opened.
 * @throws ColonyException Thrown to indicate that the 'open' option is under construction.
 *                         Includes a message specifying the operation and file details.
 */
public void open(File file) throws ColonyException {
    throw new ColonyException("Option 'open' under construction. File: " + file.getName());
}

/**
 * Placeholder method for the 'save' operation.
 *
 * @param file The file to be saved.
 * @throws ColonyException Thrown to indicate that the 'save' option is under construction.
 *                         Includes a message specifying the operation and file details.
 */
public void save(File file) throws ColonyException {
    throw new ColonyException("Option 'save' under construction. File: " + file.getName());
}

/**
 * Placeholder method for the 'import' operation.
 *
 * @param file The file to be imported.
 * @throws ColonyException Thrown to indicate that the 'import' option is under construction.
 *                         Includes a message specifying the operation and file details.
 */
public void importFile(File file) throws ColonyException {
    throw new ColonyException("Option 'import' under construction. File: " + file.getName());
}

/**
 * Placeholder method for the 'export' operation.
 *
 * @param file The file to be exported.
 * @throws ColonyException Thrown to indicate that the 'export' option is under construction.
 *                         Includes a message specifying the operation and file details.
 */
public void export(File file) throws ColonyException {
    throw new ColonyException("Option 'export' under construction. File: " + file.getName());
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

    

