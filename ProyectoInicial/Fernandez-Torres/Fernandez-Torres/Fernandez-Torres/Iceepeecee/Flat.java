/**
 * Write a description of class Flat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flat extends Fligth
{
    private Circle plane;
    private char id = 'f';
    private int photograph = 0;
    /**
     * Constructor for objects of class Flat
     */
    public Flat(String color, int[] from, int[] to)throws IceepeeceeException
    {
        super(color, from, to);
        plane = new Circle(color,to[0],to[1]);;
        int f = from[2];
        to[2]=f;
    }
    
    
    /**
     * Makes the plane and line objects visible on the canvas window.
     * This method sets the visibility status of both the plane and line objects to
     * true, making them invisible on the canvas window.
     */
    public void makeVisible(){
        plane.makeVisible();
        line.makeVisible();
    }
    
    /**
     * Retrieves the visibility status of the objects.
     * This method gets the visibility status of the plane object and returns it.
     *
     * @return True if the plane object is currently visible, false otherwise.
     */
    public boolean getVisible() {
        isVisible = plane.getVisible();
        return isVisible;
    }
    
    
    /**
     * Sets the visibility status of the object.
     *
     * @param state True to make the object visible, false to make it invisible.
     */
    public void setVisible(boolean state) {
        plane.setVisible(state);
    }
    
    /**
     * Makes the plane and line objects invisible on the canvas window.
     * This method sets the visibility status of both the plane and line objects to
     * false, making them invisible on the canvas window.
     */
    public void makeInvisible() {
        plane.makeInvisible();
        line.makeInvisible();
    }
}