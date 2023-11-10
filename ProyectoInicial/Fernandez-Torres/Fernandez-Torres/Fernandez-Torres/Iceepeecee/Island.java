import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.Color;
import java.util.HashMap;

/**
 * The Island class represents an island object with a polygonal shape.
 * It stores information about the island's color, position vertices, and visibility status.
 * @author Maria Torres, Juan Fernandez
 * @version 1.5 23/09/2023
 */
public abstract class Island 
{
    private String colorD;
    public int[][] polygon;
    public int[] xPoints;
    public int[] yPoints;
    protected boolean isVisible;
    private ArrayList<Line> lados = new ArrayList();
    protected char id;
    private boolean observed;

    /**
     * Constructor for the Island class.
     *
     * @param color The color of the Island object.
     * @param polygon A two-dimensional array representing the vertices of the island's polygon.
     */
    public Island(String color, int[][] polygon) {
        this.polygon = polygon;
        xPoints = new int[polygon.length];
        yPoints = new int[polygon.length];
        correccionParaAgregar();
        colorD = color;
        isVisible = false;
        observed = false;
    }
    
    /**
     * Helper method to initialize the xPoints and yPoints arrays from the polygon data.
     */
    private void correccionParaAgregar(){
        for (int i = 0; polygon.length > i; i++){
            xPoints[i] = polygon[i][0];
            yPoints[i] = polygon[i][1];
        }
    }

    /**
     * Creates line segments to represent the sides of the island.
     *
     * @param color The color of the line segments.
     */
    public void createLados(String color) {
        for (int i = 0; i < xPoints.length - 1; i++) {
            double x1 = xPoints[i];
            double y1 = yPoints[i];
            double x2 = xPoints[i + 1];
            double y2 = yPoints[i + 1];
            Line l = new Line(x1, y1, x2, y2, color);
            lados.add(l);
        }
        double x1 = xPoints[xPoints.length - 1];
        double y1 = yPoints[xPoints.length - 1];
        double x2 = xPoints[0];
        double y2 = yPoints[0];
        Line l = new Line(x1, y1, x2, y2, color);
        lados.add(l);
    }

    /**
     * Checks if the island has been observed by any flight.
     *
     * @param fligths A HashMap containing flight objects.
     * @return True if the island has been observed, false otherwise.
     */
    public boolean observedIsland(HashMap<String, Fligth> fligths) {
        for (String f : fligths.keySet()) {
            Fligth fligth = fligths.get(f);
            if (fligth.hasislands(xPoints, yPoints)) {
                observed = true;
            }
        }
        if (observed) {
            createLados("black");
            linesObservedIsland();
        }
        return observed;
    }

    /**
     * Marks the island as useless for all flights that intersect with it.
     *
     * @param fligths A HashMap containing flight objects.
     */
    public void uselessFligth(HashMap<String, Fligth> fligths) {
        for (String f : fligths.keySet()) {
            Fligth fligth = fligths.get(f);
            fligth.useless(xPoints, yPoints);
        }
    }

    /**
     * Makes the line segments representing the island's sides visible on the canvas.
     */
    private void linesObservedIsland() {
        for (Line l : lados) {
            l.makeVisible();
        }
    }

    /**
     * Gets the location of the island as a two-dimensional array.
     *
     * @return A two-dimensional array representing the location of the island.
     */
    abstract int[][] islandLocation();

    /**
     * Makes the island visible on the canvas window.
     */
    public void makeVisible() {
        if (!isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.colorD, new Polygon(xPoints, yPoints, xPoints.length), 255);
            canvas.wait(10);
            linesObservedIsland();
            isVisible = true;
        }
    }
    
    /**
     * Retrieves the identifier of the island.
     *
     * @return The identifier of the island.
     */
    public char getId(){
        return id;
    }

    /**
     * Checks if the island intersects with the given region defined by its vertices, width, and height.
     *
     * @param vertex The vertices of the region.
     * @param width The width of the region.
     * @param height The height of the region.
     * @return True if the island intersects with the region, false otherwise.
     */
    public boolean isIntersect(int[][] vertex, int width, int height){
        boolean v = false;
        if (vertex.length < 3) {
            v = true;
        }
        
        int[] yPoint = new int[vertex.length];
        int[] xPoint = new int[vertex.length];
        
        for (int i = 0; i < vertex.length; i++){
            xPoint[i] = vertex[i][0];
            yPoint[i] = vertex[i][1];
        }
        
        Polygon polygon1 = new Polygon(xPoint, yPoint, xPoint.length);
        Polygon polygon2 = new Polygon(xPoints, yPoints, xPoints.length);
        if (polygon1.intersects(polygon2.getBounds2D())){
            v = true;
        }        
        return v;
    }

    /**
     * Retrieves the visibility status of the object.
     *
     * @return True if the object is currently visible, false otherwise.
     */
    public boolean getVisible() {
        return isVisible;
    }

    /**
     * Sets the visibility status of the object.
     *
     * @param state True to make the object visible, false to make it invisible.
     */
    public void setVisible(boolean state) {
        isVisible = state;
    }
    
    /**
     * Makes the island invisible on the canvas window.
     */
    public void makeInvisible(){
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
        isVisible = false;
    }
    
    /**
     * Abstract method to delete the island. Subclasses should implement this method.
     */
    abstract void del();
}
