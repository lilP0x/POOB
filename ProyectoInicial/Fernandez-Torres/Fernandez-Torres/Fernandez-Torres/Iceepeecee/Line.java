import java.awt.geom.Line2D;
import java.awt.*;
import java.util.ArrayList;
 
/**
 * This class make a set of lines on canvas with an specific color 
 *
 * @author Maria Valentina Torres, Juan Pablo Fernandez
 * @version 2.0 
 */
public class Line extends Line2D.Double
{
    private ArrayList<Line> factory;
    private boolean isVisible = false;
    private String color = "black";
    private Line2D line;
    public double x1,x2,y1,y2;
    public static boolean bandera;
    /**
     * The constructor of this class makes a line using two given points 
     * @Parameters double x1, 
     * @Return Line 
     */
    public Line(double X1,double Y1,double X2,double Y2,String color){
        line = new Line2D.Double(X1,Y1,X2,Y2);
        x1 = X1;
        x2 = x2;
        Y1 = y1;
        Y2 = y2;
        this.color = color;
     }
     
    public Line(double X1,double Y1,double X2,double Y2){
        line = new Line2D.Double(X1,Y1,X2,Y2);
        x1 = X1;
        x2 = x2;
        Y1 = y1;
        Y2 = y2;
    }
     
    public Line(){
        //aqui hay algo...
    }
     
     /**
     * Change the color of line 
     * @Parameters String color
     * @Return 
     */
    public void cambioColor(String newColor){
        erase();
        color = newColor;
        draw();
    }
    
    /**
     * Create a fligth with a given color and with all vertex of a polygon 
     * @Parameters String color, int [][] matrix
     * @Return ArrayList Line
     */
    public ArrayList<Line> createLados(int matriz[][]){
        factory = new ArrayList();
        int xfinal = matriz[0][0], yfinal = matriz[0][1];
        int xPreFinal = matriz[matriz.length-1][0], yPreFinal = matriz[matriz.length-1][1];
        int x1 = 0,x2 = 0, y1 = 0,y2 = 0, i;

        for (i = 0; i < matriz.length-1; i++) {
            x1 = matriz[i][0];
            y1 = matriz[i][1];
            x2 = matriz[i+1][0];
            y2 = matriz[i+1][1];
            factory.add(new Line(x1,y1,x2,y2));
        }
        factory.add(new Line(xPreFinal,yPreFinal,xfinal,yfinal));
        return factory;
    }
    
    /**
     * Make visible the lines. If it was already invisible, do nothing
     * @Parameters 
     * @Return 
     */
    public void makeVisible(){
        draw();
    }
    
    /**
     * Make visible the lines. If it was already invisible, do nothing
     * @Parameters 
     * @Return 
     */
    public void makeInvisible(){
        erase();
    }
    
    /**
     * Draw the lines on cavas
     * @Parameters 
     * @Return 
     */
    public void draw() {
        if(!isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, this.color,line,255);
            canvas.wait(10);
            isVisible = true;
        }
    }
    
    /**
     * erase lines on canvas
     * @Parameters 
     * @Return 
     */
    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
            isVisible = false;
        }
    }
    
    /**
     * Set the color of the line 
     * @Parameters String color
     * @Return 
     */
    public void setColor( String newColor){
        erase();
        color = newColor;
        draw();
    }
    /**
     * Get the color of the line 
     * @Parameters 
     * @Return String color
     */
    public String getColor(){
        return color;
    }
    
    /**
     * Calculates the length (size) of the line segment.
     *
     * @return The length (size) of the line segment.
     */
    public double size() {
        double size = 0, x, y;
        x = (line.getX2() - line.getX1()) * (line.getX2() - line.getX1());
        y = (line.getY2() - line.getY1()) * (line.getY2() - line.getY1());
        size = Math.sqrt(x + y);
        return size;
    }
    

    /**
     * Retrieves the coordinates of the line segment as an array.
     *
     * @return An array containing the X and Y coordinates of both endpoints of the line segment.
     * The array has the format [x1, y1, x2, y2].
     */
    public double[] getCoordenadas() {
        double[] coordenadas = new double[4];
        coordenadas[0] = line.getX1();
        coordenadas[1] = line.getY1();
        coordenadas[2] = line.getX2();
        coordenadas[3] = line.getY2();
        return coordenadas;
    }

}