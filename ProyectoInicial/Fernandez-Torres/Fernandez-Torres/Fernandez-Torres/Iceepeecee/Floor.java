/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Fligth 
{
    private int x;
    private Triangle planeTo;
    private Triangle planeFrom;
    /**
     * Constructor for objects of class Floor
     */
    public Floor(String color, int[] from, int[] to)
    {
        super(color, from, to);
        planeTo = new Triangle(color, to);
        planeFrom = new Triangle(color, from);
        from[2]=0;
    }

    public void makeVisible(){
        planeTo.makeVisible();
        planeFrom.makeVisible();
        line.makeVisible();
    }
    
    /**
     * Retrieves the visibility status of the objects.
     * This method gets the visibility status of the plane object and returns it.
     *
     * @return True if the plane object is currently visible, false otherwise.
     */
    public boolean getVisible() {
        isVisible = planeTo.getVisible();
        return isVisible;
    }
    
    /**
     * Sets the visibility status of the object.
     *
     * @param state True to make the object visible, false to make it invisible.
     */
    public void setVisible(boolean state) {
        planeTo.setVisible(state);
    }
    
    /**
     * Makes the plane and line objects invisible on the canvas window.
     * This method sets the visibility status of both the plane and line objects to
     * false, making them invisible on the canvas window.
     */
    public void makeInvisible() {
        planeTo.makeInvisible();
        planeFrom.makeVisible();
        line.makeInvisible();
    }
}
