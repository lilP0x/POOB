import java.awt.Polygon;

/**
 * The `Photograph` class represents a photograph taken from one position to another.
 * It calculates the coordinates of the photograph based on the given parameters.
 * 
 * @author Maria Torres, Juan Fernandez
 * @version 1.5 23/09/2023
 */
public class Photograph {
    private int angle;
    private int altitude1;
    private int altitude2;
    private int fromX;
    private int fromY;
    private int toX;
    private int toY;
    private Polygon pol;
    private String color;
    private float angles;
    private int[][] vertices;
    private boolean useless;
    private boolean isVisible;

    /**
     * Constructor for objects of class Photograph.
     *
     * @param angle  The angle of the photograph.
     * @param from   An array representing the starting position coordinates.
     * @param to     An array representing the target position coordinates.
     * @param color  The color of the photograph.
     */
    public Photograph(int angle, int[] from, int[] to, String color) {
        this.angle = angle;
        this.altitude1 = from[2];
        this.altitude2 = to[2];
        this.fromX = from[0];
        this.fromY = from[1];
        this.toX = to[0];
        this.toY = to[1];
        this.color = color;
        vertices = calculateFieldOfVision();
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class Photograph.
     *
     * @param angle  The angle of the photograph.
     * @param from   An array representing the starting position coordinates.
     * @param to     An array representing the target position coordinates.
     * @param color  The color of the photograph.
     */
    public Photograph(float angle, int[] from, int[] to, String color) {
        this.angles = angle;
        this.altitude1 = from[2];
        this.altitude2 = to[2];
        this.fromX = from[0];
        this.fromY = from[1];
        this.toX = to[0];
        this.toY = to[1];
        this.color = color;
        vertices = calculateFieldOfVision();
        draw();
    }
    
    /**
     * Checks if the photograph captures islands at the specified positions.
     *
     * @param xPos An array of X-coordinates representing positions.
     * @param yPos An array of Y-coordinates representing positions.
     * @return `true` if the photograph captures islands at the specified positions, `false` otherwise.
     */
    public boolean hasIslands(int[] xPos, int[] yPos) {
        int count = 0;
        boolean yesOrNo = false;
        int n = vertices[0].length;
        for (int j = 0; j < xPos.length; j++) {
            int intersections = 0; 
            for (int i = 0; i < n; i++) {
                int x1 = vertices[0][i];
                int y1 = vertices[1][i];
                int x2 = vertices[0][(i + 1) % n];
                int y2 = vertices[1][(i + 1) % n]; 
                if (y1 != y2 && yPos[j] >= Math.min(y1, y2) && yPos[j] <= Math.max(y1, y2) &&
                    xPos[j] <= Math.max(x1, x2) && y1 != y2) {
                    double xIntersection = (yPos[j] - y1) * (x2 - x1) / (y2 - y1) + x1;
                    if (x1 == x2 || xPos[j] <= xIntersection) {
                        intersections++;
                    }
                }
            }
            if (intersections % 2 == 1) {
                count++;
            }
        }
        if (count == xPos.length) {
            yesOrNo = true;
        }
        return yesOrNo;
    }
    
    /**
     * Calculate the vertices of the polygon representing the field of vision.
     *
     * @return A two-dimensional array representing the X and Y coordinates of the polygon's vertices.
     */
    private int[][] calculateFieldOfVision() {
        double halfVisibleWidthf = altitude1 * Math.tan(Math.toRadians(angle / 2.0));
        double halfVisibleWidtht = altitude2 * Math.tan(Math.toRadians(angle / 2.0));
        double slope = (double) (toY - fromY) / (toX - fromX);
        double perpendicularSlope = -1 / slope;
        int x1 = (int) (fromX - halfVisibleWidthf);
        int y1 = (int) (fromY - halfVisibleWidthf * perpendicularSlope);
        int x2 = (int) (fromX + halfVisibleWidthf);
        int y2 = (int) (fromY + halfVisibleWidthf * perpendicularSlope);
        int x3 = (int) (toX + halfVisibleWidtht);
        int y3 = (int) (toY + halfVisibleWidtht * perpendicularSlope);
        int x4 = (int) (toX - halfVisibleWidtht);
        int y4 = (int) (toY - halfVisibleWidtht * perpendicularSlope);
        int[] xPoints = { x1, x2, x3, x4 };
        int[] yPoints = { y1, y2, y3, y4 };
        int[][] coordinates = { xPoints, yPoints };
        return coordinates;
    }
    
    /**
     * Draws the photograph on the canvas.
     */
    public void draw() {
        pol = new Polygon(vertices[0], vertices[1], vertices[0].length);
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, pol, 110);
        canvas.wait(10);
    }
    
    /**
     * Erases the photograph from the canvas.
     */
    public void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(pol);
        }
    }
    
    /**
     * Checks if the photograph is visible.
     *
     * @return `true` if the photograph is visible, `false` otherwise.
     */
    public boolean getVisible() {
        return isVisible;
    }

    /**
     * Retrieves the angle of the photograph.
     *
     * @return The angle of the photograph.
     */
    public int getAngle() {
        return angle;
    }
}
