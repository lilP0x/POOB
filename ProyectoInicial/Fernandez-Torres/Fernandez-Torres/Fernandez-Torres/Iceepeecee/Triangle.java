import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle{
    
    public static int VERTICES=3;
    
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String colorD;
    private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(){
        height = 10;
        width = 10;
        xPosition = 140;
        yPosition = 15;
        colorD = "green";
        isVisible = false;
    }
    
    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(String color,int[] to ){
        height = 10;
        width = 10;
        xPosition = to[0];
        yPosition = to[1];
        colorD = color;
        isVisible = false;
    }
    
    public Triangle(String color, double angle) {
        // Constructor basado en un ángulo
        double radians = Math.toRadians(angle);
        int size = 100;
        int[] xpoints = {
            xPosition,
            (int) (xPosition + size * Math.cos(radians)),  // Modificado
            xPosition  // Modificado
        };
        int[] ypoints = {
            yPosition,
            (int) (yPosition + size * Math.sin(radians)),  // Modificado
            yPosition  // Modificado
        };
        height = size;
        width = size;
        xPosition = xpoints[0];
        yPosition = ypoints[0];
        colorD = color;
        isVisible = false;
        makeVisible();
    }
    
    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the triangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the triangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the triangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the triangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidht must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
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
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        colorD = newColor;
        draw();
    }

    /*
     * Draw the triangle with current specifications on screen.
     */
    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition - (width / 2), xPosition + (width / 2), xPosition };
            int[] ypoints = { yPosition, yPosition, yPosition + height };
            canvas.draw(this, this.colorD,new Polygon(xpoints, ypoints, 3),255);
            canvas.wait(10);
            isVisible = true;
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    

}