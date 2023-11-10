/**
 * The Normal class represents a normal island object with a polygonal shape.
 * It extends the Island class and stores information about the island's color, 
 * position vertices, and visibility status. Normal islands can be deleted, 
 * and their visibility can be toggled.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Normal extends Island
{
    /**
     * Constructor for objects of class Normal.
     *
     * @param color The color of the Normal island object.
     * @param polygon A two-dimensional array representing the vertices of the island's polygon.
     */
    public Normal(String color, int[][] polygon)
    {
        super(color, polygon);
        this.id = 'n';
    }

    /**
     * Gets the location of the island as a two-dimensional array.
     *
     * @return A two-dimensional array representing the location of the Normal island.
     */
    public int[][] islandLocation(){
        return polygon;
    }
    
    /**
     * Deletes the Normal island by making it invisible on the canvas window.
     */
    public void del(){
        makeInvisible();
    }
}
