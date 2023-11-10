/**
 * Write a description of class Lazy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lazy extends Fligth
{
    private Rectangle plane ;
    private char id = 'l';
    /**
     * Constructor for objects of class Lazy
     */
    public Lazy(String color, int[] from, int[] to) throws IceepeeceeException
    {
        super(color, from, to);
        plane = new Rectangle(color,to[0],to[1]);
    }
    
    
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