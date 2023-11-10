import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.util.Arrays;

/**
 * The Flight class represents a flight object that extends the Triangle class.
 * It stores information about the flight's color, departure, and destination points.
 * @author Maria Torres , Juan Fernandez 
 * @version 1.5 23/09/2023
 */
public abstract class  Fligth  
{
    private ArrayList<Line> fTrack = new ArrayList();
    protected int[] positionX,positionY,from,to;
    private double xPosition,yPosition,widthc,heigthc;
    private String color;
    protected Line line;
    protected boolean isVisible;
    protected ArrayList<Photograph> photographs = new ArrayList<>();
    private boolean useless;
     /**
     * Constructor for objects of class Flight.
     *
     * @param color The color of the Flight object.
     * @param from  An integer array representing the departure location.
     * @param to    An integer array representing the destination location.
     */
    public Fligth(String color, int[] from, int[] to)
    {
        this.color = color;
        this.to = to;
        this.from = from;
        useless = true;
        line = new Line(from[0],from[1],to[0],to[1],color);
    }
    
    public int fligthCamera(){
        return photographs.get(photographs.size()-1).getAngle();
    }
    
    /**
     * Checks if there are islands within the specified positions.
     * This method iterates through the list of photographs and checks if any of them capture
     * islands within the given positions.
     *
     * @param positionX An array of X-coordinates representing positions.
     * @param positionY An array of Y-coordinates representing positions.
     * @return True if there are islands within the specified positions, false otherwise.
     */
    public boolean hasislands(int[] positionX, int[] positionY) {
        boolean yesORno = false;
        for (Photograph p : photographs) {
            if (p.hasIslands(positionX, positionY)) {
                yesORno = true;
                this.useless = false;
            }
        }
        return yesORno;
    }
    
    /**
     * Marks the current fligth as not useless if there are islands within the specified positions.
     * This method iterates through the list of photographs and checks if any of them capture
     * islands within the given positions. If islands are observed, the current fligth is marked
     * as not useless.
     *
     * @param positionX An array of X-coordinates representing positions.
     * @param positionY An array of Y-coordinates representing positions.
     */
    public void useless(int[] positionX, int[] positionY) {
        for (Photograph p : photographs) {
            if (p.hasIslands(positionX, positionY)) {
                this.useless = false;
            }
        }
    }
    
    
    /**
     * Takes a photograph at a specified angle with a given color.
     * @param teta The angle at which to take the photograph.
     * @param color The color of the photograph.
     */
    public void photograph(int teta, String color) {
        if (photographs.size() > 0) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(photographs.get(photographs.size() - 1));
        }
        Photograph photograph = new Photograph(teta, from, to, color);
        photographs.add(photograph);
        photograph.draw();

    }
    
    /**
     * Takes a photograph at a specified angle with a given color.
     * @param teta The angle at which to take the photograph.
     * @param color The color of the photograph.
     */
    public void photograph(float teta, String color) {
        if (photographs.size() > 0) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(photographs.get(photographs.size() - 1));
        }
        Photograph photograph = new Photograph(teta, from, to, color);
        photographs.add(photograph);
        photograph.draw();
    }

    
    
    /**
     * Gets the location of the photograph's starting position.
     * @return An array containing the X, Y, and height coordinates of the starting position.
     */
    public int[] getLocation() {
        return to;
    }
    
    /**
     * Leaves the track of the movement of the fligth
     * @Parameters int[] position, boolean error, int x, int y
     * @Return
     */
    public void recorridefligth(int[] from,int[] to){       
        Line line = new Line(from[0],from[1],to[0],to[1],color);
    }
    
    /**
     * Makes the plane and line objects visible on the canvas window.
     * This method sets the visibility status of both the plane and line objects to
     * true, making them visible on the canvas window.
     */
    abstract void makeVisible();
    
    
    /**
     * Retrieves the visibility status of the objects.
     * This method gets the visibility status of the plane object and returns it.
     *
     * @return True if the plane object is currently visible, false otherwise.
     */
    abstract boolean getVisible();
  
    
    /**
     * Sets the visibility status of the object.
     *
     * @param state True to make the object visible, false to make it invisible.
     */
    abstract void setVisible(boolean state);
    
    /**
     * Makes the plane and line objects invisible on the canvas window.
     * This method sets the visibility status of both the plane and line objects to
     * false, making them invisible on the canvas window.
     */
    abstract void makeInvisible();
    
    
    /**
     * Retrieves the flight's location as a two-dimensional array.
     *
     * @return A two-dimensional array representing the location of the flight.
     *         Each row contains a pair of X and Y coordinates.
     */
    public int[][] fligthLocation(){
        int[][] matrix = {from,to};
        return matrix;
    }
    
    /**
     * Checks if the current flight is marked as useless.
     * This method returns the current status of the flight, indicating whether it
     * is marked as useless or not.
     *
     * @return True if the flight is marked as useless, false otherwise.
     */
    public boolean uselessFligth() {
        return useless;
    }
    
    /**
     * Retrieves the color of the flight.
     * This method returns the color of the flight.
     *
     * @return The color of the flight as a string.
     */
    public String getColor() {
        return color;
    }
    
    
}