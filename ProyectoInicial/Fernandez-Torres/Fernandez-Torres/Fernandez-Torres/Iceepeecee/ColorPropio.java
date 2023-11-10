import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;


/**
 * The ColorPropio class is responsible for generating and managing unique colors.
 * It provides methods to create random RGB colors and store them, as well as translating
 * RGB color strings into Color objects.
 * 
 * Note: It uses the java.awt.Color class to represent colors.
 */
public class ColorPropio
{
    private int numero;
    private Random random;
    private String color;
    private ArrayList<Integer> red = new ArrayList<>();
    private ArrayList<Integer> green = new ArrayList<>();
    private ArrayList<Integer> blue = new ArrayList<>();
    
    /**
     * Constructor for objects of class ColorPropio, used for generating random colors.
     *
     * @param numero The number of unique colors to generate.
     */
    public ColorPropio(int numero)
    {
        this.numero = numero;
        random = new Random();
        red.add(73);
        red.add(226);
        green.add(89);
        green.add(25);
        blue.add(200);
        blue.add(230);
    }
    
    /**
     * Constructor for objects of class ColorPropio, used for translating RGB color strings.
     *
     * @param color A string in the "RGB" format representing a color.
     */
    public ColorPropio(String color)
    {
        this.color = color;
    }

    /**
     * Generates a random RGB color.
     *
     * @return An array of integers representing the red, green, and blue components of the color.
     */
    private int[] rgbRandom(){
        int red = random.nextInt(256); 
        int green = random.nextInt(256);
        int blue = random.nextInt(256); 
        int[] rgb = {red, green, blue};
        return rgb;
    }
    
    /**
     * Generates a list of unique Color objects with a specified number of unique colors.
     *
     * @return An ArrayList of unique Color objects.
     */
    public ArrayList<Color> rgbADD(){
        int count = 0; 
        ArrayList<Color> colores = new ArrayList();
        while (count < numero){
            int[] rgb = rgbRandom();
            if (count == 0 || (!red.contains(rgb[0]) && !green.contains(rgb[1]) && !blue.contains(rgb[2]))){
                red.add(rgb[0]);
                green.add(rgb[1]);
                blue.add(rgb[2]);
                Color colorAleatorio = new Color(rgb[0], rgb[1], rgb[2]);
                colores.add(colorAleatorio);
                count++;
            }
        }
        return colores;
    }
    
    /**
     * Generates a list of unique RGB color strings with a specified number of unique colors.
     *
     * @return An ArrayList of unique RGB color strings.
     */
    public ArrayList<String> rgbString(){
        int count = 0; 
        String color = "RGB,";
        ArrayList<String> colores = new ArrayList();
        while (count < numero){
            int[] rgb = rgbRandom();
            if (count == 0 || (!red.contains(rgb[0]) && !green.contains(rgb[1]) && !blue.contains(rgb[2]))){
                red.add(rgb[0]);
                green.add(rgb[1]);
                blue.add(rgb[2]);
                color += Integer.toString(rgb[0]) + "," + Integer.toString(rgb[1]) + "," + Integer.toString(rgb[2]);
                colores.add(color);
                color = "RGB,";
                count++;
            }
        }
        return colores;
    }
    
    /**
     * Translates an RGB color string to a Color object.
     *
     * @return A Color object representing the RGB color.
    */
    public Color traductor(){
        String[] ArrayRGB = color.split(",");
        int[] rgbArray = new int[ArrayRGB.length-1];
        for (int i = 1; i < rgbArray.length; i++) {
            rgbArray[i-1] = Integer.parseInt(ArrayRGB[i]);
        }
        Color colorTraductor = new Color(rgbArray[0], rgbArray[1], rgbArray[2]);
        return colorTraductor;
    }
    
}