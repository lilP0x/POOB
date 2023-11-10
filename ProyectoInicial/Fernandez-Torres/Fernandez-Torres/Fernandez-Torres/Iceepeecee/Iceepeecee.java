import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Color;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * The Iceepeecee class represents a canvas for managing islands and fligths.
 * It provides methods for adding and removing islands and fligths, as well as
 * making them visible or invisible on the canvas. Additionally, it allows
 * querying the location of islands and fligths based on their colors.
 * @author Maria Torres , Juan Fernandez 
 * @version 2 4/11/2023
 */
public class Iceepeecee
{
    private boolean isVisible, ok;
    private HashMap<String, Island> islands = new HashMap<>();
    private HashMap<String, Fligth> fligths = new HashMap<>();
    private int width, heigth;
    private Canvas canvas;
    /**
     * Constructor for objects of class Iceepeecee
     * @param width determine the width of the Iceepeecee.
     * @param heigth determine the height of the Iceepeecee.
     */ 
    public Iceepeecee(int width, int heigth)
    {
        this.width =  width;
        this.heigth = heigth;
        canvas = Canvas.getCanvas(width, heigth);
        ok = false;
    }
    
     /**
     * Constructor for the Iceepeecee class. Initializes the canvas and adds islands and flights.
     *
     * @param islands An array of islands represented as 3D coordinates.
     * @param flights An array of flights represented as 3D coordinates.
     */
    public Iceepeecee(int[][][] islands, int[][][] fligths){
        canvas = Canvas.getCanvas(500, 500);
        ArrayList<String> coloresI = new ColorPropio(islands.length).rgbString();
        for (int i = 0; i< islands.length; i++){
            int[][] polygon = islands[i];
            addIsland(coloresI.get(i),polygon);
        }
        ArrayList<String> coloresF = (new ColorPropio(fligths.length)).rgbString();
        for(int i = 0; i< fligths.length;i++ ){
            int [][] coordenadas = fligths[i];
            int[] from = fligths[i][0];
            int[] to = coordenadas[1];
            addFligth(coloresF.get(i),from,to);
        }
    }
    
        /**
     * Returns an array of observed islands based on the provided flights.
     *
     * @return An array of observed island colors.
     */
    public String[] observedIsland(){
        ok = false;
        ArrayList<String> islandSObserved = new ArrayList<>();
        for( String c: islands.keySet()){
            Island i = islands.get(c);
            if (i.observedIsland(fligths)){
                islandSObserved.add(c);
            }
        }
        ok = true;
        String[] islandsObserved = islandSObserved.toArray(new String[islandSObserved.size()]);
        ok();
        return islandsObserved;
    }
    
        /**
     * Returns an array of useless flights by checking each island and flight.
     *
     * @return An array of useless flight colors.
     */
    public String[] uselessFligth() {
        ArrayList<String> uselessFligths = new ArrayList<>();
        for(String c: islands.keySet()){
            Island i = islands.get(c);
            i.uselessFligth(fligths);
        }
        for(String c: fligths.keySet()){
            if((fligths.get(c)).uselessFligth()){
                uselessFligths.add(c);
            }
        }
        String[] uselessFligth = uselessFligths.toArray(new String[uselessFligths.size()]);
        return uselessFligth;
    }
    
    /**
     * Returns an array of all island colors.
     * @return An array of island colors.
     */
    public String[] islands(){
        ok = false;
        String[] islands1 = islands.keySet().toArray(new String[islands.size()]);
        ok = true;
        return islands1;
    }
    
    /**
     * Returns an array of all fligth colors.
     * @return An array of fligth colors.
     */
    public String[] fligths(){
        ok = false;
        String[] fligths1 = fligths.keySet().toArray(new String[fligths.size()]);
        ok = true;
        return fligths1;
    }
    
    /**
     * Returns the canvas associated with this Iceepeecee object.
     * @return The canvas object.
     */
    
    private Canvas getCanvas(){
        ok = true;
        return canvas;
    }
    
    /**
     * Adds an Island object to the map.
     *
     * @param color The color of the Island.
     * @param polygon A two-dimensional array representing the vertices of the island's polygon.
     */
    public void addIsland(String color, int[][] polygon) {
        boolean intersect =false;
        if (!islands.containsKey(color)) {
            for (String c : islands.keySet()) {
                if(islands.get(c).isIntersect(polygon, width, heigth)){
                    intersect  = true;
                    ok = false;
                }
            }
            if(!intersect ){
                Normal i = new Normal(color, polygon);
                islands.put(color, i);
                ok = true;
            }
        }
        ok();
    }
    
    /**
     * Adds an Island object to the map using a specified type.
     *
     * @param type    The class name of the Island type.
     * @param color   The color of the Island.
     * @param polygon A 2D array representing the vertices of the island's polygon.
     */
    public void addIsland(String type, String color, int[][] polygon) {
        ok = false;
        try {
            Class<? extends Island> islaClass = Class.forName(type).asSubclass(Island.class);
            Constructor<? extends Island> constructor = islaClass.getConstructor(String.class, int[][].class);
            boolean intersect = false;
            for (String c : islands.keySet()) {
                if(islands.get(c).isIntersect(polygon, width, heigth)){
                    intersect  = true;
                }
            }
            if(!intersect){
                Island isla = constructor.newInstance(color, polygon);
                islands.put(color, isla);
                ok = true;
            }
        } catch (Exception e) {
            System. out. println(e.getMessage());
        }
        ok();
    }
    
    /**
     * Adds a Flight object to the map using a specified type.
     *
     * @param type  The class name of the Flight type.
     * @param color The color of the Flight.
     * @param from  An array representing the departure location.
     * @param to    An array representing the destination location.
     */
    public void addFligth(String type, String color, int[]from, int[]to){
       ok = false;
       boolean intersect = false; 
       if (!fligths.containsKey(color)){
            try {
                Class<? extends Fligth> fligthClass = Class.forName(type).asSubclass(Fligth.class);
                Constructor<? extends Fligth> constructor = fligthClass.getConstructor(String.class, int[].class, int[].class);
                for(String i :fligths.keySet()){
                    Fligth f = fligths.get(i);
                    int[] ff = f.fligthLocation()[0];
                    int[] ft = f.fligthLocation()[1];
                    if (Arrays.equals(ff, from) && Arrays.equals(ft, from)) {
                        intersect = true;
                        }
                } 
                if(!intersect){
                    Fligth vuelo = constructor.newInstance(color, from ,to);
                    fligths.put(color,vuelo);
                    ok = true;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
                ok = false;
            } 
        }
        ok();
    }
    
   
    /**
     * Adds a Fligth object to the map.
     *
     * @param color The color of the Fligth.
     * @param from An integer array representing the departure location.
     * @param to An integer array representing the destination location.
     */
    public void addFligth(String color , int[] from, int[] to){
        ok = false;
        boolean intersect = false;
        if (!fligths.containsKey(color)){
            for(String i :fligths.keySet()){
                Fligth f = fligths.get(i);
                int[] ff = f.fligthLocation()[0];
                int[] ft = f.fligthLocation()[1];
                if (Arrays.equals(ff, from) && Arrays.equals(ft, from)) {
                    intersect = true;
                    }
            } 
            if(!intersect){
                NormalF f = new NormalF(color,from, to);
                fligths.put(color,f);
                ok = true;
            }
        }
        ok();
    }
    
    
    /**
     * Takes photographs of all fligths at a given angle.
     * @param teta The angle at which the photographs are taken.
     */
    public void photograph(int teta){
        ok = false;
        if(teta > 0){
            for(String c: fligths.keySet()){
                Fligth f = fligths.get(c);
                f.photograph(teta,c);
            }
            ok = true;
        }
        ok();
    }
    
    /**
     * Takes a photograph of a specific fligth at a given angle.
     * @param fligth The color of the fligth to photograph.
     * @param teta The angle at which the photograph is taken.
     */
    public void photograph(String fligth, int teta){
        ok = false;
        if(fligths.containsKey(fligth) && teta > 0){
            Fligth f = fligths.get(fligth);    
            f.photograph(teta,fligth);
            ok = true;
        }
        ok();
    }
    
    /**
     * Takes photographs of all fligths at a given angle.
     * @param teta The angle at which the photographs are taken.
     */
    public void photograph(float teta){
        ok = false;
        if(teta > 0){
            for(String c: fligths.keySet()){
                Fligth f = fligths.get(c);
                f.photograph(teta,c);
            }
            ok = true;
        }
        ok();
    }
    
    /**
     * Deletes an Island object from the map by color.
     *
     * @param color The color of the Island to be deleted.
     */
    public void delIsland(String color){
        ok = false;
        if (islands.get(color) != null) {
            Island island = islands.get(color);
            island.del();
            if (!island.getVisible()){
                islands.remove(color);
            }
            ok = true;
        }
        ok();
    }

    /**
     * Deletes a fligth object from the map by color.
     *
     * @param color The color of the fligth to be deleted.
     */
    public void delFligth(String color){
        ok = false;
        if (fligths.get(color) != null){
            Fligth fligth = fligths.get(color);
            fligth.makeInvisible();
            fligths.remove(color);
            ok = true;
        }
        ok();
    }
    
    /**
     * Retrieves the location of a fligth by its color.
     *
     * @param fligth The color of the fligth.
     * @return A two-dimensional array representing the location of the fligth, or null if not found.
     */
    public int[][] fligthLocation(String fligth ){
        ok = false;
        int [][] cor = null; 
        if (fligths.get(fligth) != null){
            Fligth f = fligths.get(fligth);
            cor = f.fligthLocation();
            ok = true;
        }
        ok();
        return cor;

    }
    
    /**
     * Retrieves the location of an Island by its color.
     *
     * @param island The color of the Island.
     * @return A two-dimensional array representing the location of the Island, or null if not found.
     */
    public int[][] islandLocation(String island) {
        ok = false;
        int[][] cor = null;
        if (islands.containsKey(island)) {
            Island i = islands.get(island);
            cor = i.islandLocation();
            ok = true;
        }
        ok();
        return cor;
    }

    /**
     * Makes all fligths and Islands visible on the canvas.
     */
    public void makeVisible(){
        ok = false;
        for (String s:fligths.keySet()){
            if(!fligths.get(s).getVisible()){
                fligths.get(s).makeVisible();
                fligths.get(s).setVisible(true);
            }
        }
        for (String s:islands.keySet()){
            if(!islands.get(s).getVisible()){
                islands.get(s).makeVisible();
                islands.get(s).setVisible(true);
            }
        }
        ok = true;
        ok();
    }
    
    /**
     * Makes all fligths and Islands invisible on the canvas.
     */
    public void makeInvisible(){
        ok = false;
        for (String s:fligths.keySet()){
            if(fligths.get(s).getVisible()){
                fligths.get(s).makeInvisible();
                fligths.get(s).setVisible(false);
            }
        }
        for (String s:islands.keySet()){
            if(islands.get(s).getVisible()){
                islands.get(s).makeInvisible();
                islands.get(s).setVisible(false);
            }
        }
        ok = true;
        ok();
    }
    
    /**
     * Gets the camera angle of a flight by its color.
     *
     * @param color The color of the flight.
     * @return The camera angle of the flight.
     */
    public int fligthCamera(String color){
        return fligths.get(color).fligthCamera();
    }
    
    /**
     * Gets a fligth object by its color.
     * @param color The color of the fligth to retrieve.
     * @return The fligth object, or null if not found.
     */
    public Fligth getfligths(String color){
        ok = false; 
        Fligth f = null;
        if(fligths.get(color) != null){
            ok = true;
            f = fligths.get(color);
        }
        ok();
        return f;
    }
    
    /**
     * Gets a HashMap of all fligths.
     * @return A HashMap containing all fligths.
     */
    public HashMap getfligths(){
        ok = true;
        ok();
        return fligths;
    }
    
    /**
     * Gets a HashMap of all Islands.
     * @return A HashMap containing all Islands.
     */
    public HashMap getIslands(){
        ok = true;
        ok();
        return islands;
    }
    
    /**
     * Gets an Island object by its color.
     * @param color The color of the Island to retrieve.
     * @return The Island object, or null if not found.
     */
    public Island getIslands(String color){
        ok = false;
        Island i = null;
        if(islands.get(color) != null){
            ok = true;
            i = islands.get(color);
        }
        ok();
        return i;
    }
    
    /**
     * Exits the program.
     */
    public void finish(){
        System.exit(0);
    }
    
    /**
     * Checks if the last operation was successful.
     * @return True if the last operation was successful, otherwise false.
     */
    public boolean ok(){
        if (!ok){
            System.out.println("No se pudo realizar la accion");
        }
        return ok;
    }
}