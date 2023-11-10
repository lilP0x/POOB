

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IceepeeceeTest1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IceepeeceeTest1
{
    private Iceepeecee iceepeecee;
    private Iceepeecee i;
    private Iceepeecee manage;
    /**
     * Default constructor for test class IceepeeceeTest1
     */
    public IceepeeceeTest1()
    {
    }

    
    /**
     * 
     
    @BeforeEach
    public void setUpFT() {
        int width = 500;
        int height = 500;
        i = new Iceepeecee(width, height);
        int[][] island1 = {{45,60},{50,45},{80,67}};
        int[][] island2 = {{100,70},{34,89},{45,89},{90,34}};
        int[][] island3 = {{45,60},{55,60},{60,65},{80,45}};
        int[] FligthFrom1 = {0, 30,20};
        int[] FligthTo1 = {78,70,5};
        int[] FligthFrom2 = {55, 0,20};
        int[] FligthTo2 = {70,60,10};
        String color1 = "green";
        String color2 = "red";
        String color3 = "blue";
        String color4 = "magenta";
        i.addIsland(color1, island1);
        i.addIsland(color2, island2);
        i.addIsland(color3, island3);
        i.addFligth(color1, FligthFrom1, FligthTo1);
        i.addFligth(color2, FligthFrom2, FligthTo2);
    }
    */
    
    //ADDISLAND
    
    @Test
    public void shouldFTAddIslandFERNANDEZTORRES(){
        int width = 500;
        int height = 500;
        i = new Iceepeecee(width, height);
        int[][] island1 = {{20,30},{10,50},{30,50}};
        int[][] island2 = {{100,70},{34,89},{45,89},{90,30}};
        i.addIsland("magenta",island1);
        i.addIsland("blue",island2);
        i.makeVisible();
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTAddIslandTypeFERNANDEZTORRES(){
        int width = 500;
        int height = 500;
        i = new Iceepeecee(width, height);
        int[][] island1 = {{20,30},{10,50},{30,50}};
        int[][] island2 = {{110,70},{40,89},{55,89},{90,30}};
        i.addIsland("Fixed","magenta",island1);
        i.addIsland("Surprising","blue",island2);
        i.makeVisible();
        assertTrue(i.ok());
    }
}
