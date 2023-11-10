/**
 * The Fixed class represents a fixed island object with a polygonal shape.
 * It extends the Island class and stores information about the island's color, 
 * position vertices, and visibility status.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fixed extends Island
{
    /**
     * Constructor for objects of class Fixed.
     *
     * @param color The color of the Fixed island object.
     * @param polygon A two-dimensional array representing the vertices of the island's polygon.
     */
    public Fixed(String color, int[][] polygon)
    {
        super(color, polygon);
        this.id = 'f';
        createLados("RGB,226,25,230");
    }
    
    /**
     * Gets the location of the island as a two-dimensional array.
     *
     * @return A two-dimensional array representing the location of the Fixed island.
     */
    public int[][] islandLocation(){
        return polygon;
    }
    
    /**
     * A method to delete the Fixed island. This method does not perform any action
     * and simply prints a message to indicate that the island cannot be deleted.
     */
    public void del(){
        System.out.println("No me puedo borrar");
    }
}
