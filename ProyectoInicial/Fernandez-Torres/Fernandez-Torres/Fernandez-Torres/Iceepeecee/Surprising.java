import java.awt.*;

/**
 * The Surprising class represents a surprising island object with a polygonal shape.
 * It extends the Island class and stores information about the island's color, 
 * position vertices, and visibility status. Surprising islands have a special behavior
 * when their location is queried: they temporarily remove a vertex before providing
 * the updated location.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Surprising extends Island
{
    
    /**
     * Constructor for objects of class Surprising.
     *
     * @param color The color of the Surprising island object.
     * @param polygon A two-dimensional array representing the vertices of the island's polygon.
     */
    public Surprising(String color, int[][] polygon)
    {
       super(color, polygon); 
       this.id = 's';
       createLados("RGB,73,89,200");
    }

    /**
     * Gets the location of the Surprising island as a two-dimensional array.
     *
     * If the island is currently visible, it temporarily removes a vertex before
     * providing the updated location with one vertex removed.
     *
     * @return A two-dimensional array representing the location of the Surprising island.
     */
    @Override
    public int[][] islandLocation(){
        if(isVisible){
            makeInvisible();
            this.polygon = delVertex(this.polygon);
            super.makeVisible();
            return this.polygon;
        }
        return this.polygon;
    }
    
    /**
     * Helper method to remove a vertex from the island's location.
     *
     * @param vertex The original vertices of the island.
     * @return A new array of vertices with one vertex removed.
     */
    private int[][] delVertex(int [][] vertex){
        if(vertex.length <= 3 || vertex[0].length == 0 || vertex == null){
            return vertex;
        }
        int filas = vertex.length;
        int columnas = vertex[0].length;
        int [][] newVertex = new int[filas-1][columnas];
        for(int i = 0; i < filas-1; i++){
            for(int j = 0; j < columnas; j++){
                newVertex[i][j] = newVertex[i][j];
            }
        }
        this.xPoints = new int[newVertex.length];
        this.yPoints = new int[newVertex.length];
        for(int i = 0; i < newVertex.length;i++){
            this.xPoints[i] = newVertex[i][0];
            this.yPoints[i] = newVertex[i][1];
        }
        return newVertex;    
    }
    
    /**
     * Deletes the Surprising island by making it invisible on the canvas window.
     */
    public void del(){
        makeInvisible();
    }
}
