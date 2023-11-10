import java.util.*; // O la importación adecuada según tu caso
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class iTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IceepeeceeTest
{
    
    private Iceepeecee iceepeecee;
    private Iceepeecee i;
    private Iceepeecee manage;
    /**
    @BeforeEach
    public void setUpFT() {
        int width = 500;
        int height = 500;
        i = new Iceepeecee(width, height);
        int[][] island1 = {{45,60},{50,45},{80,67}};+
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
    
    
    //ADDISLAND
    
    @Test
    public void shouldFTAddIslandFERNANDEZTORRES(){
        int[][] island1 = {{20,30},{10,50},{30,50}};
        int[][] island2 = {{100,70},{34,89},{45,89},{90,34}};
        i.addIsland("magenta",island1);
        i.addIsland("blue",island2);
        i.makeVisible();
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTNOTAddIslandFERNANDEZTORRES(){
        int[][] island2 = {{10,10},{40,40},{59,30}};
        i.addIsland("black",island2);
        assertTrue(i.ok());
        int[][] island1 = {{10,40},{40,10},{70,40}};
        i.addIsland("black",island1);
        i.makeVisible();
        assertTrue(i.ok());
    }
    
    //ADDFLIGTH 
    
    @Test
    public void shouldFTNotAddFligthsMismosFERNANDEZTORRES(){
        int[] FligthFrom1 = {0, 30,20};
        int[] FligthTo1 = {78,70,5};
        i.addFligth("black",FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }
    
    
    //ADDFLIGTH CICLO 4
        @Test
    public void shouldAddFligthsTypes1FERNANDEZTORRES(){
        int[] FligthFrom1 = {50, 30,20};
        int[] FligthTo1 = {78,50,5};
        i.addFligth("Flat","magenta",FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }
    
        @Test
    public void shouldFTAddFligthsTypes0FERNANDEZTORRES(){
        int[] FligthFrom1 = {80, 30,60};
        int[] FligthTo1 = {78,30,5};
        i.addFligth("NormalF","yellow",FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTAddFligthsTypes2FERNANDEZTORRES(){
        int[] FligthFrom1 = {100, 30,20};
        int[] FligthTo1 = {10,50,60};
        i.addFligth("Lazy","blue",FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }

    @Test
    public void shouldFTNotAddFligthsMismosTypes1FERNANDEZTORRES(){
        int[] FligthFrom1 = {0, 30,20};
        int[] FligthTo1 = {78,70,5};
        i.addFligth("Flat","magenta",FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTMakeVisible(){
        i.makeVisible();
        assertTrue(i.ok());
    }
    
    
    @Test
    public void shouldObserveIslandsFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);
        i.photograph(80);
        String[] observedIslands = i.observedIsland();
        assertEquals(1, observedIslands.length);
        assertEquals("magenta", observedIslands[0]);
    }

    @Test
    public void shouldNotObserveIslandsFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 10, 15};
        int[] flightTo = {30, 30, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        String[] observedIslands = i.observedIsland();
        assertEquals(0, observedIslands.length);
    }

    @Test
    public void shouldMakeAllVisibleFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        i.makeVisible();

        for (String s : i.islands()) {
            assertTrue(i.getIslands(s).getVisible());
        }

        for (String s : i.fligths()) {
            assertTrue(i.getfligths(s).getVisible());
        }
    }

    @Test
    public void shouldMakeAllInvisibleFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        i.makeInvisible();

        for (String s : i.islands()) {
            assertFalse(i.getIslands(s).getVisible());
        }

        for (String s : i.fligths()) {
            assertFalse(i.getfligths(s).getVisible());
        }
    }

    @Test
    public void shouldPhotographAllFlightsFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        i.photograph(45);

        for (String s : i.fligths()) {
            assertEquals(45, i.getfligths(s).fligthCamera());
        }
    }

    @Test
    public void shouldPhotographSingleFlightFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addIsland("magenta", island1);
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        i.photograph("magenta", 60);

        assertEquals(60, i.getfligths("magenta").fligthCamera());
    }

    @Test
    public void shouldDeleteIslandFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        i.addIsland("magenta", island1);

        i.delIsland("magenta");

        assertNull(i.getIslands("magenta"));
    }
    
    @Test
    public void shouldGetFligthLocationIfExistsFERNANDEZTORRES() {
        int[] from = {10, 40, 15};
        int[] to = {30, 60, 25};
        i.addFligth("NormalF", "red", from, to);
        int [][] loc ={{10, 40, 15},{30, 60, 25}};
        int[][] location = i.fligthLocation("red");
        assertEquals(location,loc);
        assertTrue(i.ok());
    }


    @Test
    public void shouldReturnNullIfFligthDoesNotExistFERNANDEZTORRES() {
        int[][] location = i.fligthLocation("nonExistentColor");
        assertNull(location);
        assertFalse(i.ok());
    }
    
    @Test
    public void shouldGetIslandLocationIfExistsFERNANDEZTORRES() {
        int[][] island1 = {{20, 30}, {10, 50}, {30, 50}};
        i.addIsland("Normal", "magenta", island1);
        
        int[][] location = i.islandLocation("magenta");
        assertNotNull(location);
        assertTrue(i.ok());
    }

    @Test
    public void shouldReturnNullIfIslandDoesNotExistFERNANDEZTORRES() {
        int[][] location = i.islandLocation("nonExistentColor");
        assertNull(location);
        assertFalse(i.ok());
    }


    @Test
    public void shouldDeleteFlightFERNANDEZTORRES() {
        int[] flightFrom = {10, 40, 15};
        int[] flightTo = {30, 60, 25};
        i.addFligth("Flat", "magenta", flightFrom, flightTo);

        i.delFligth("magenta");

        assertNull(i.getfligths("magenta"));
    }
    /**
    @Test
    public void shouldFTObservedIsland(){
        String[] resultado = {"red"} ;
        i.photograph(48);
        boolean s = Arrays.equals(resultado, i.observedIsland());
        assertTrue(s);
        
    }
    @Test
    public void shouldFTNotObservedIsland(){
        String[] resultado = {"red","green"} ;
        i.photograph(48);
        boolean s = Arrays.equals(resultado, i.observedIsland());
        assertFalse(s);
    }
    
    @Test
    public void shouldFTAddIsland(){
        int[][] island1 = {{20,30},{10,50},{30,50}};
        i.addIsland("magenta",island1);
        assertTrue(i.ok());
    }
    
    @Test
    public void ShouldFTNotAddOsland(){
        int[][] island1 = {{50,30},{10,60},{40,70}};
        i.addIsland("magenta",island1);
        assertFalse(i.ok());
    }
     
    @Test
    public void shouldFTAddFligth(){
        int[] FligthFrom1 = {0, 30,20};
        int[] FligthTo1 = {78,70,5};
        i.addFligth("black", FligthFrom1, FligthTo1);
        assertTrue(i.ok());
    }
    
     @Test
    public void shouldFTNotAddFligth(){
        int[] FligthFrom1 = {-10, 30,20};
        int[] FligthTo1 = {78,70,-5};
        i.addFligth("black", FligthFrom1, FligthTo1);
        assertFalse(i.ok());
    }
    
    @Test
    public void shouldFTDelIsland(){
        i.delIsland("magenta");
        assertTrue(i.ok());
    }
    
    
     @Test
    public void shouldFTNotDelIsland(){
        i.delIsland("gray");
        assertFalse(i.ok());
    }
    
    @Test
    public void islandFTLocation(){        
        int [][] test = {{45,60},{50,45},{80,67}};
        Assert.assertArrayEquals(test, i.islandLocation("green"));
        assertTrue(i.ok());
    }
    
       @Test
    public void islandFTNotLocation(){        
        int [][] test = {{45,60},{50,45},{80,67}};
        Assert.assertArrayEquals(test, i.islandLocation("gray"));
        assertFalse(i.ok());
    }
    
    @Test
    public void shouldFTMakeVisible(){
        assertTrue(i.ok());
        i.makeVisible();
        assertFalse(i.ok());
    }
    
    @Test
    public void shouldFTMakeInvisible(){
        assertTrue(i.ok());
        i.makeInvisible();
        assertFalse(i.ok());
    }
    
    @Test
    public void fligthFTLocation(){
        int [][] test = {{20, 50, 10}, {30, 50, 50}};
        int[][] result = i.fligthLocation("green");
        assertEquals(test.length, result.length);
        assertTrue(i.ok());
    }

    @Test
    public void fligthsFT(){
        String [] s = i.fligths();
        assertArrayEquals(new String[]{"red", "green"}, s);
        assertTrue(i.ok());
    }
    
    @Test
    public void testSimulateShould() {

        int[][][] islands = {{{20,30}, {50,50},{10,50}},{{40,20},{60,10},{75,20},{60,30}},{{45,60},{55,55},{60,60},{55,65}}};
        int[][][] flights = {{{0,30,20},{78,70,5}},{{55,0,20},{70,60,10}}};
        iContest solver = new iContest();
        solver.simulate(islands, flights);
        
        assertTrue(i.ok());
    }
    
    @Test void shouldFTMakePhotograph(){
        i.photograph(48);
        assertTrue(i.ok());
        i.photograph("magenta",48);
        assertFalse(i.ok());
        float t = 48;
        i.photograph(t);
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTDelFligth(){
        i.delFligth("green");
        assertTrue(i.ok());
    }
    
    @Test
    public void shouldFTNotDelFligth(){    
        i.delFligth("purple");
        assertFalse(i.ok());
    }
    
    @Test
    public void fTshouldMakeVisible(){
        i.makeVisible();
        assertTrue(i.ok());
    }
    
    @Test
    public void fTshouldCreateIsland() {
        i.makeVisible();
        assertTrue(i.ok());
    }

    @Test
    public void shouldCreatei2(){
        int[][][] islands = {{{20,30}, {50,50}, {10,50}}, 
                             {{40,20}, {60,10}, {72,20}, {60,30}}, 
                             {{45,60}, {55,55}, {60,60}, {55,65}}};
        int[][][] fligths = {{{0,30,20}, {78,70,5}}, 
                             {{55,0,20}, {70,60,10}}};
        i prueba = new i(islands, fligths);
        prueba.makeVisible();
        Assert.assertEquals(prueba.fligths().length, 2);
        Assert.assertEquals(prueba.islands().length, 3);
    }
    
    @Test
    public void shouldNotCreatei2(){ 
        int[][][] islands = {{{20,30}, {50,50}, {10,50}}, 
                             {{40,20}, {60,10}, {72,20}, {60,30}}, 
                             {{45,60}, {55,55}, {60,60}, {55,65}}};
        int[][][] fligths = {{{0,30,20}, {78,70,5}}, 
                             {{55,0,20}, {70,60,10}}};
        i prueba = new i(-300, -300);
        Assert.assertFalse(prueba.ok());
    }
    
    @Test
    public void shouldNotAddIsland(){
        i prueba = new i(300, 300);
        int[][] matrix = {{10,70}, {10,30}, {80,440}, {80,180}};
        prueba.addIsland("green", matrix);
        prueba.addIsland("green", matrix); 
        Assert.assertFalse(prueba.ok());
    }

    @Test
    public void shouldAddFlight(){
        i prueba = new i(300, 300);
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        prueba.addFligth("red", from, to);
        Assert.assertTrue(prueba.ok());
    }
    
    @Test
    public void shouldNotFlight(){
        i prueba = new i(300, 300);
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        prueba.addFligth("red", from, to);
        prueba.addFligth("red", from, to);
        Assert.assertFalse(prueba.ok());
    }
    
    @Test
    public void shouldPhotographColor(){
        i prueba = new i(300, 300);
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        prueba.addFligth("red", from, to);
        prueba.photograph("red", 45);
        Assert.assertTrue(prueba.ok());
    }
    
    @Test
    public void shouldNotPhotographColor(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.photograph("green", 45); 
        i.photograph("magenta", -100); 
        Assert.assertFalse(i.ok());
    }
    
    @Test
    public void shouldPhotograph2(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.photograph("red", 45);
        Assert.assertTrue(i.ok());
    }
    
    @Test
    public void shouldNotPhotograph2(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.photograph("green", 45); 
        i.photograph("red", -10); 
        Assert.assertFalse(i.ok());
    }
 
    @Test
    public void shouldPhotograph3(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.photograph("red", 45);
        Assert.assertTrue(i.ok());
    }
    
    @Test
    public void shouldNotPhotograph3(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.photograph("green", 45); 
        i.photograph("red", -10); 
        Assert.assertFalse(i.ok());
    }

    @Test
    public void shouldDelIsland(){
        i prueba = new i(300, 300);
        int[][] matrix = {{10,70}, {10,240}, {80,240}, {80,180}};
        prueba.addIsland("green", matrix);
        prueba.delIsland("green");
        Assert.assertTrue(prueba.ok());
    }
    

 
    @Test
    public void shouldDelFlight(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        i.addFligth("red", from, to);
        i.delFligth("red");
        Assert.assertTrue(i.ok());
    }
    
    @Test
    public void shouldNotDelFlight(){
        i prueba = new i(300, 300);
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        prueba.addFligth("red", from, to);
        prueba.delFligth("green"); 
        Assert.assertFalse(prueba.ok());
    }
 
    @Test
    public void shouldIslandLocation(){
        int[][] matrix = {{10,70}, {10,240}, {80,240}, {80,180}};
        i.addIsland("green", matrix);
        Assert.assertEquals(i.islandLocation("green"), matrix);
    }
    
    @Test
    public void shouldNotIslandLocation(){
        int[][] matrix = {{10,70}, {10,240}, {80,240}, {80,180}};
        i.addIsland("green", matrix);
        Assert.assertEquals(i.islandLocation("green"), matrix);
    }

    @Test
    public void shouldFligthLocation(){
        int[] from = {70,70,80};
        int[] to = {130,130,40};
        int[][] locationCorrect = {{70,70,80},{130,130,40}};
        i.addFligth("green", from, to);
        Assert.assertEquals(i.islandLocation("green"), locationCorrect);
    }
    
    @Test
    public void shouldIslands(){
        String[] islasCorrectas = {"red", "green", "blue"};
        Assert.assertEquals(islasCorrectas, i.islands());
    }
    
    @Test
    public void shouldNotIslands(){ 
        Assert.assertEquals(i.islands().length, 3);
    }

    @Test
    public void shouldFlights(){
        Assert.assertEquals(i.fligths().length, 2);
    }
    
    @Test
    public void shouldNotFlights(){
        Assert.assertEquals(i.fligths().length, 2);
    }
    
    */
    /*Lesmes*/
@BeforeEach
    public void setUp() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500);
    }
    
    //AddFligthLAZY
    @Test
    public void accordingLPShouldAddFligthTypeLazy() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("Lazy","#EA3333", from, to);
        assertTrue(iceepeecee.ok());
    }
    @Test
    public void accordingLPNotShouldAddFligthTypeLazy() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("LazyFligth1","#EA3333", from, to);
        assertFalse(iceepeecee.ok());
    }
    
    @Test
    public void accordingLPShouldTakeOnlyAPhotoLAZY1() throws java.lang.reflect.InvocationTargetException{
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("Lazy","#EA3333", from, to);
        iceepeecee.photograph(30.0f);
        iceepeecee.photograph(55.4f);
        assertEquals(30.0f, iceepeecee.fligthCamera("#EA3333"));
    }
    
    //AddFligthFIXED
    @Test
    public void accordingLPShouldAddFligthTypeFixed() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("Fixed","#EA3333", from, to);
        assertTrue(iceepeecee.ok());
    }
    @Test
    public void accordingLPNotShouldAddFligthTypeFixed() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("FixedFligth7","#EA3333", from, to);
        assertFalse(iceepeecee.ok());
    }
    @Test
    public void accordindLPShouldNotBeDeletedFIXED() throws java.lang.reflect.InvocationTargetException{
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("Fixed","#EA3333", from, to);
        iceepeecee.delFligth("#EA3333");
        assertEquals(1, iceepeecee.fligths().length);
    }
    
    //AddFligthFLAT
    @Test
    public void accordingLPShouldAddFligthTypeFlat() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("Flat","#EA3333", from, to);
        assertTrue(iceepeecee.ok());
    }
    @Test
    public void accordingLPShouldBeTheSameAltitudeFlat() throws java.lang.reflect.InvocationTargetException {
        int[] from = {0,30,20};
        int[] to = {78,70,5};        
        iceepeecee.addFligth("Flat","#EA3333", from, to);
        int[][]location = iceepeecee.fligthLocation("#EA3333");
        assertTrue(location[0][location[0].length-1] == location[1][location[0].length - 1 ]);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------
    //AddIslandFixed
    @Test
    public void accordingLPShouldAddIslandTypeFixed() throws java.lang.reflect.InvocationTargetException {
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("Fixed","#EA3333", polygon);
        assertTrue(iceepeecee.ok());
    }
    @Test
    public void accordingLPNotShouldAddIslandTypeFixed() throws java.lang.reflect.InvocationTargetException {
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("FixedIsland9","#EA3333", polygon);
        assertFalse(iceepeecee.ok());
    }
    @Test
    public void accordindLPShouldNotBeDeletedIslandFIXED() throws java.lang.reflect.InvocationTargetException{
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("Fixed","#EA3333", polygon);
        iceepeecee.delIsland("#EA3333");
        assertEquals(1, iceepeecee.islands().length);
    }
    
    //AddIslandSurprising
    @Test
    public void accordingLPShouldAddIslandTypeSurprising() throws java.lang.reflect.InvocationTargetException {
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("Surprising","#EA3333", polygon);
        assertTrue(iceepeecee.ok());
    }
    @Test
    public void accordingLPNotShouldAddIslandTypeSurprising() throws java.lang.reflect.InvocationTargetException {
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("SurprisingIsland0","#EA3333", polygon);
        assertFalse(iceepeecee.ok());
    }
    @Test
    public void accordindLPShouldBeLessPointsSurprising() throws java.lang.reflect.InvocationTargetException{
        int[][] polygon = {{20,30},{50,50},{10,50},{40,30}};
        iceepeecee.addIsland("Surprising","#EA3333", polygon);
        assertEquals(3, iceepeecee.islandLocation("#EA3333").length);
    }
    @Test
    public void accordindLPShouldBeLessPointsSurprising1() throws java.lang.reflect.InvocationTargetException{
        int[][] polygon = {{20,30},{50,50},{10,50}};
        iceepeecee.addIsland("Surprising","#EA3333", polygon);
        assertEquals(3, iceepeecee.islandLocation("#EA3333").length);
    }
    
    @Test
        public void accordingFMShouldAddNormalIslandThatHaveNormalLocationAndCanBeDeleted() {
            int [][] location = {{0,0},{50,50},{100,50}};
            manage.addIsland("normal","Red",location);
            assertTrue(manage.ok());
            int [][] newLocation = manage.islandLocation("Red");
            for (int i = 0 ; i < location.length ;i++){
                assertEquals(location[i][0],newLocation[i][0]);
                assertEquals(location[i][1],newLocation[i][1]);
            }
            assertTrue(manage.ok());
            manage.delIsland("Red");
            assertTrue(manage.ok());
        }
    
    @Test
    public void accordingFMShouldAddFixedIslandThatCantBeDeleted() {
        manage.addIsland("fixed","Red",new int[][]{{0,0},{50,50},{100,50}});
        assertTrue(manage.ok());
        manage.delIsland("Red");
        assertFalse(manage.ok());
    }
    
    @Test
    public void accordingFMShouldAddSurprisingThatModifyTheLocation() {
        int [][] location = {{0,0},{50,0},{50,50},{25,60},{0,50}};
        manage.addIsland("surprising","Red",location);
        assertTrue(manage.ok());
        assertTrue(manage.ok());
        manage.islandLocation("Red");
        manage.islandLocation("Red");
    }
    @Test
    public void accordingFMShouldAddNormalFligthPassingTheTypeThatCanMakeManyPhotos() {
        int[] from = {0,0,20};
        int[] to = {20,20,40};
        manage.addFligth("normal","Red",from,to);
        assertTrue(manage.ok());
        manage.photograph("Red",45);
        assertTrue(manage.ok());
        manage.photograph("Red",70);
        assertTrue(manage.ok());
        manage.photograph("Red",15);
        assertTrue(manage.ok());
    }
    
    @Test
    public void accordingFMShouldNotAddFlatFligthPassingTheTypeThatGainOrLoseHeight() {
        int[] from = {0,0,20};
        int[] to = {20,20,30};
        manage.addFligth("flat","Red",from,to);
        assertFalse(manage.ok());
        to = new int[]{20,20,10};
        manage.addFligth("flat","Red",from,to);
        assertFalse(manage.ok());
    }
    
    @Test
    public void accordingFMShouldAddLazyFligthPassingTheTypeThatOnlyCantTakeOnePhoto() {
        int[] from = {0,0,20};
        int[] to = {20,20,40};
        manage.addFligth("lazy","Red",from,to);
        assertTrue(manage.ok());
        manage.photograph("Red",45);
        assertTrue(manage.ok());
        manage.photograph("Red",70);
        assertFalse(manage.ok());
        manage.photograph("Red",15);
        assertFalse(manage.ok());
    }


//CASALLAS-MURCIA
//CICLO 4

@Test
    public void accordingCMShouldSurprisingIslandLessPoints(){
        int[][] polygon = {{20,30},{50,50},{10,50},{40,30}};
        iceepeecee.addIsland("SurprisingIsland","green", polygon);
        assertEquals(3, iceepeecee.islandLocation("green").length);
    }

@Test
    public void accordingCMShouldNotAddSurprisingIslandDuplicateColor() {
        int[][] polygon1 = {{10, 10}, {20, 10}, {20, 20}, {10, 20}};
        int[][] polygon2 = {{30, 30}, {40, 30}, {40, 40}, {30, 40}};
        
        iceepeecee.addIsland("SurprisingIsland","white", polygon1);
        iceepeecee.addIsland("SurprisingIsland","white", polygon2);
        assertFalse(iceepeecee.ok());
    }

@Test
    public void accordingCMShouldFlatFligthSameAltitude2(){
        int[] from = {0,30,20};
        int[] to = {78,70,5};
        iceepeecee.addFligth("FlatFligth","#CD5C5C",from,to);
        int altitude = iceepeecee.fligthLocation("#CD5C5C")[1][2];
        assertTrue(from[2]==altitude);
    }
@Test
    public void accordingCMShouldNotAddFlatFligthWithLessThanThreeCoordinates(){
        int[] from1 = {100,100};
        int[] to1 = {700,780};
        iceepeecee.addFligth("FlatFligth","#FF0000",from1,to1);
        assertFalse(iceepeecee.ok());
    }    
//Chicuazuque-Sierra
@Test
    public void agregarIslasPorTipoCorrectamenteChicuazuqueSierra()throws Exception{
         Iceepeecee input1 = new Iceepeecee(100, 100);
        input1.addIsland("Normal","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
        assertTrue(input1.ok());
        input1.addIsland("Surprising","green", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
        assertTrue(input1.ok());
        input1.addIsland("Fixed","red", new int[][]{{45, 60}, {55, 55}, {60, 60}, {55, 65}});
        assertTrue(input1.ok());
        input1.makeVisible();
        
    }
    

    @Test
    public void agregarIslasPorTipoIncorrectamenteChicuazuqueSierra() throws Exception {
        Iceepeecee input1 = new Iceepeecee(100, 100);
        input1.addIsland("noexiste","blue", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
        assertFalse(input1.ok());
    }
    
   
    
    @Test
    public void ConsultarDosVecesUnaIslaSurprisingChicuazuqueSierra() throws Exception{
       Iceepeecee input1 = new Iceepeecee(100, 100);
        input1.addIsland("Surprising","green", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
        input1.islandLocation("green");
        input1.makeVisible();
    }
    
   

@Test
    public void testAddIslandwithType() {
           iceepeecee.addIsland("Surprising","62B2AB", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
           assertEquals(true,iceepeecee.ok());
           iceepeecee.addIsland("Fixed","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
           assertEquals(true,iceepeecee.ok());
           iceepeecee.addIsland("NormalIsland","991700", new int[][]{{100, 30}, {200, 50}, {80, 50}});
           assertEquals(true,iceepeecee.ok());
        
        
    }
    @Test
    public void testAddIslandwithTypeUnkown() {
           iceepeecee.addIsland("Surprising","62B2AB", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
           assertEquals(true,iceepeecee.ok());
           iceepeecee.addIsland("Fixed","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
           assertEquals(true,iceepeecee.ok());
           iceepeecee.addIsland("Surprising","991700", new int[][]{{100, 30}, {200, 50}, {80, 50}});
           assertEquals(true,iceepeecee.ok());
           iceepeecee.addIsland("Isla","magenta", new int[][]{{45, 60}, {55, 55}, {60, 60},{55, 65}});
           assertEquals(false,iceepeecee.ok());
    }
    @Test
    public void testAddFligthwithType() {
           iceepeecee.addFligth("Lazy","7DF032", new int[]{0,30,20},new int[]{78,70,5});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,10},new int[]{15,5,10});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("NormalFligth","magenta", new int[]{55,0,20},new int[]{70,60,10}); 
           assertTrue(iceepeecee.ok());
        
        
    }
    @Test
    public void testAddFligthwithTypeUnkown() {
        
           iceepeecee.addFligth("Lazy","7DF032", new int[]{0,30,20},new int[]{78,70,5});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,10},new int[]{15,5,10});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("NormalFligth","magenta", new int[]{55,0,20},new int[]{70,60,10}); 
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Avion","blue", new int[]{4,70,20},new int[]{15,30,5});
           assertEquals(false,iceepeecee.ok());
        
    }
    @Test
    public void testAddFlatwithDiferentAltitude() {
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,6},new int[]{15,5,10}); 
           assertEquals(false,iceepeecee.ok());
    }
@Test
    public void testAddIslandwithType1() {
           iceepeecee.addIsland("Surprising","62B2AB", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
           assertTrue(iceepeecee.ok());
           iceepeecee.addIsland("Fixed","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
           assertTrue(iceepeecee.ok());
           iceepeecee.addIsland("Lazy","991700", new int[][]{{100, 30}, {200, 50}, {80, 50}});
           assertTrue(iceepeecee.ok());
        
        
    }
    @Test
    public void testAddIslandwithTypeUnkown1() {
           iceepeecee.addIsland("Surprising","62B2AB", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
           assertTrue(iceepeecee.ok());
           iceepeecee.addIsland("Fixed","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
           assertTrue(iceepeecee.ok());
           iceepeecee.addIsland("Lazy","991700", new int[][]{{100, 30}, {200, 50}, {80, 50}});
           assertTrue(iceepeecee.ok());
           iceepeecee.addIsland("Isla","magenta", new int[][]{{45, 60}, {55, 55}, {60, 60},{55, 65}});
        
    }
    @Test
    public void testAddFligthwithType2() {
           iceepeecee.addFligth("Lazy","7DF032", new int[]{0,30,20},new int[]{78,70,5});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,10},new int[]{15,5,10});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("NormalFligth","magenta", new int[]{55,0,20},new int[]{70,60,10}); 
           assertTrue(iceepeecee.ok());
        
        
    }
    @Test
    public void testAddFligthwithTypeUnkown2() {
        
           iceepeecee.addFligth("Lazy","7DF032", new int[]{0,30,20},new int[]{78,70,5});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,10},new int[]{15,5,10});
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("NormalFligth","magenta", new int[]{55,0,20},new int[]{70,60,10}); 
           assertTrue(iceepeecee.ok());
           iceepeecee.addFligth("Avion","blue", new int[]{4,70,20},new int[]{15,30,5});
           assertEquals(false,iceepeecee.ok());
        
    }
    @Test
    public void testAddFlatwithDiferentAltitude3() {
           iceepeecee.addFligth("Flat","991700", new int[]{5,5,6},new int[]{15,5,10}); 
           assertEquals(false,iceepeecee.ok());
    }
//Silva-Suarez: 
    @Test
    public void shouldNewAddIsland() {
        iceepeecee = new Iceepeecee(100, 100);
        String color = "Blue";
        int[][] polygons = {{1, 1}, {2, 2}, {3, 3}};

        iceepeecee.addIsland("NormalIsland", color, polygons);
        assertTrue(iceepeecee.ok());

        iceepeecee.addIsland("FixedIsland", color, polygons);
        assertFalse(iceepeecee.ok());

        iceepeecee.addIsland("SurprisingIsland", color, polygons);
        assertFalse(iceepeecee.ok());
    }
    
     @Test
    public void shouldNotAddIslandWithExistingColor() {
        iceepeecee = new Iceepeecee(100, 100);
        String color = "Green";
        int[][] polygons = {{1, 1}, {2, 2}, {3, 3}};
    
        iceepeecee.addIsland("Normal", color, polygons);
        assertTrue(iceepeecee.ok());

        iceepeecee.addIsland("Fixed", color, polygons);
        assertFalse(iceepeecee.ok()); 
    }
    
    @Test
    public void shouldAddNewFligth() {
        iceepeecee = new Iceepeecee(100, 100);
        String color1 = "Red";
        String color2 = "Blue";
        String color3 = "Green";
        int[] from = {10, 10, 10};
        int[] to = {20, 20, 20};

        iceepeecee.addFligth("FlatFligth", color1, from, to);
        assertTrue(iceepeecee.ok());

        iceepeecee.addFligth("LazyFligth", color2, from, to);
        assertTrue(iceepeecee.ok());

        iceepeecee.addFligth("NormalFligth", color3, from, to);
        assertTrue(iceepeecee.ok());
    }

    @Test
    public void shouldNotAddFligthWithExistingColor() {
        iceepeecee = new Iceepeecee(100, 100);
        String color = "red";
        int[] from1 = {10, 10, 10};
        int[] to1 = {20, 20, 20};
        int[] from2 = {60, 10, 10};
        int[] to2 = {50, 20, 20};

        iceepeecee.addFligth("FlatFligth", color, from1, to1);
        iceepeecee.addFligth("LazyFligth", color, from2, to2);
        assertFalse(iceepeecee.ok()); 
    }

//MILTON ANDRES GUTIERREZ - JHON SEBASTIAN SOSA
/**
 * The test class IceeepeeceeC4Test.
 *
 * @author  Milton Gutierrez - Jhon Sosa
 * @version 20/10/23
 */
public class IceeepeeceeC4Test
{
    private Iceepeecee iceepeecee;


    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp(){
        iceepeecee = new Iceepeecee(300,300);
    }

    @Test
    public void accordingGSsholdAddEveryTypeOfNewIsland(){
        iceepeecee.addIsland("Normal", "#FFFFFF", new int[][]{{20,30},{50,50},{10,50}});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.islands().length, 1);
        iceepeecee.addIsland("Fixed", "#FFFF00", new int[][]{{40,20},{60,10},{75,20},{60,30}});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.islands().length, 2);
        iceepeecee.addIsland("Surprising", "#FF0000", new int[][]{{45,60},{55,55},{60,60},{55,65}});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.islands().length, 3);
    }
    
    @Test
    public void accordingGSsholdAddEveryTypeOfFligth(){
        iceepeecee.addFligth("Normal", "#FFFFFF", new int[]{55,0,20}, new int[]{70,60,10});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.fligths().length, 1);
        iceepeecee.addFligth("Flat", "#FFFF00", new int[]{100,130,20}, new int[]{178,170,5});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.fligths().length, 2);
        iceepeecee.addFligth("Lazy", "#08FF00", new int[]{5,5,10}, new int[]{15,5,10});
        assertTrue(iceepeecee.ok());
        assertEquals(iceepeecee.fligths().length, 3);
    }
    
    @Test
    public void accordingGSflatFligthShouldBeFlat(){
        iceepeecee.addFligth("Flat", "#FFFFFF", new int[]{55,0,20}, new int[]{70,60,9});
        assertEquals(iceepeecee.fligthLocation("#FFFFFF")[0][2], iceepeecee.fligthLocation("#FFFFFF")[1][2]);
    }
    
    @Test
    public void accordingGSlazyFligthShouldTakeAphoto(){
        iceepeecee.addFligth("Lazy", "#08FF00", new int[]{5,5,10}, new int[]{15,5,10});
        iceepeecee.photograph("#08FF00", 30);
        assertTrue(iceepeecee.ok());
        iceepeecee.makeInvisible();
    }
    
    @Test
    public void accordingGSlazylazyFligthShouldnotTakeMoreThanOnePhoto(){
        iceepeecee.addFligth("Lazy", "#08FF00", new int[]{5,5,10}, new int[]{15,5,10});
        iceepeecee.photograph("#08FF00", 30);
        assertTrue(iceepeecee.ok());
        assertEquals(30, iceepeecee.fligthCamera("#08FF00"));
        iceepeecee.photograph("#08FF00", 40);
        assertEquals(30, iceepeecee.fligthCamera("#08FF00"));
        iceepeecee.makeInvisible();
    }
    
    @Test
    public void accordingGSfixedIslandShouldBeFixed(){
        iceepeecee.addIsland("Fixed", "#FFFF00", new int[][]{{40,20},{60,10},{75,20},{60,30}});
        iceepeecee.delIsland("#FFFF00");
        assertFalse(iceepeecee.ok());
    }
    
    @Test
    public void accordingGSsurprisingIslandShouldBeSurprising(){
        iceepeecee.addIsland("Surprising", "#FF0000", new int[][]{{45,60},{55,55},{60,60},{55,65},{55,70},{60,75},{65,60}});
        assertEquals(iceepeecee.islandLocation("#FF0000").length, 6); //Se elimina un vertice. 
        assertTrue(iceepeecee.ok()); // se considera que la accion se pudo realizar
        assertEquals(iceepeecee.islandLocation("#FF0000").length, 5); //Se elimina un vertice. 
        assertTrue(iceepeecee.ok()); // se considera que la accion se pudo realizar
        assertEquals(iceepeecee.islandLocation("#FF0000").length, 4); //Se elimina un vertice. 
        assertTrue(iceepeecee.ok()); // se considera que la accion se pudo realizar
        assertEquals(iceepeecee.islandLocation("#FF0000").length, 3); //Se elimina un vertice. 
        assertTrue(iceepeecee.ok()); // se considera que la accion se pudo realizar
        assertEquals(iceepeecee.islandLocation("#FF0000").length, 3); //Llega al limite de vertices eliminados
        assertTrue(iceepeecee.ok()); // se considera que la accion se pudo realizar
    }

//Mendivelso-Rpdriguez




//Alvarez-Morales


@Test
public void shouldNotAddFligthWithInsufficientCoordinates() {
    int[] from = {0, 30};
    int[] to = {78,70};
    iceepeecee.addFligth("IncompleteFligth", "#00FFFF", from, to);
   assertFalse(iceepeecee.ok());
}

@Test
public void shouldNotAddDuplicateIslandWithSameColor(){
    int[][] polygon1 = {{10, 10}, {20, 10}, {20, 20}, {10, 20}};
    int[][] polygon2 = {{30, 30}, {40, 30}, {40, 40}, {30, 40}};
    iceepeecee.addIsland("SurprisingIsland1", "#0000FF", polygon1);
    iceepeecee.addIsland("SurprisingIsland2", "#0000FF", polygon2);
    assertFalse(iceepeecee.ok());
}


@Test
public void flatFligthShouldMaintainSameAltitude() {
    int[] from = {0, 30, 20};
   int[] to = {78, 70, 5};
   iceepeecee.addFligth("FlatFligth1", "#FFFF00", from, to);
   int initialAltitude = iceepeecee.fligthLocation("#FFFF00") [0][2];
   iceepeecee.addFligth("FlatFligth2", "#FF00FF", from, to);
   int newAltitude = iceepeecee.fligthLocation("#FF00FF") [0][2];
   assertEquals(initialAltitude, newAltitude);
}


@Test
public void normalFligthCanTakeMultiplePhotos(){
    int[] from = {0, 0, 20};
    int[] to = {20, 20, 40};
    iceepeecee.addFligth("NormalFligth2", "#00FF00", from, to);
    iceepeecee.photograph("NormalFligth2", 45);
    assertTrue(iceepeecee.ok());
    iceepeecee.photograph("NormalFligth2", 70);
    assertTrue(iceepeecee.ok());
   iceepeecee.photograph("NormalFligth2", 15);
   assertTrue(iceepeecee.ok());
}
//CASTILLO - SUAREZ
}

/**
 * The test class IceepeeceeC4test.
 */
public class IceepeeceeC4test1
{
    
    @Test
    public void testAddIslandShouldCreateIsland() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500); 

        // Prueba con un tipo válido y datos válidos
        String type = "Fixed";
        String color = "blue";
        int[][] polygon = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        iceepeecee.addIsland(type, color, polygon);
   

        // Verifica que se haya agregado una isla a la lista
        assertEquals(1, iceepeecee.islands().length);
    }
    
    @Test
    public void testAddIslandShouldDelIsland() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500);

        // Prueba con un tipo válido y datos válidos
        String type = "Fixed";
        String color = "blue";
        int[][] polygon = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        iceepeecee.addIsland(type, color, polygon);
        iceepeecee.delIsland("blue");

        // Verifica que se haya eliminado una isla de la lista
        assertEquals(0, iceepeecee.islands().length);
    }
    
      @Test
    public void ShouldAddDifferentIslands() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500); 

        // Prueba con un tipo válido y datos válidos
        String type = "FixedIsland";
        String color = "blue";
        int[][] polygon = {{10, 10}, {10, 20}, {20, 20}, {10, 20}};
        iceepeecee.addIsland(type, color, polygon);
        int [][] polygon2 = {{40,20},{60,10},{75,20},{60,30}};
        iceepeecee.addIsland("blue",polygon2);

        // Verifica que se haya agregado unicamente una isla sin importar que sean de distintos tipos
        assertEquals(1, iceepeecee.islands().length);
    }

    @Test
    public void testAddIslandShouldNotCreateIsland() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500); 

        // Prueba con un tipo inválido
        String type = "InvalidType";
        String color = "blue";
        int[][] polygon = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        iceepeecee.addIsland(type, color, polygon);

        // Verifica que no se haya agregado ninguna isla
        assertEquals(0, iceepeecee.islands().length);

        // Prueba con datos inválidos
        type = "SurprisingIsland";
        color = "blue";
        int[][] invalidPolygon = {{0, 0}, {0, 1}, {1, 1}}; // Polígono inválido
        iceepeecee.addIsland(type, color, invalidPolygon);

        // Verifica que no se haya agregado ninguna isla
        assertEquals(1, iceepeecee.islands().length);
    }

    @Test
    public void testAddFligthShouldCreateFligth() {
        Iceepeecee iceepeecee = new Iceepeecee(500,500);

        // Prueba con un tipo válido y datos válidos
        String type = "LazyFligth";
        String color = "black";
        int[] from = {0, 0};
        int[] to = {1, 1};
        int cameraAngle = 45;
        iceepeecee.addFligth(type, color, from, to);

        // Verifica que se haya agregado un vuelo a la lista
        assertEquals(1, iceepeecee.islands().length);
    }

    @Test
    public void testAddFligthShouldNotCreateFligth() {
        Iceepeecee iceepeecee = new Iceepeecee(500, 500); 
   // Prueba con un tipo inválido
        String type = "INVALIDO";
        String color = "red";
        int[] from = {0, 0};
        int[] to = {1, 1};
        int cameraAngle = 45;
        iceepeecee.addFligth(type, color, from, to);
        System.out.println(iceepeecee.fligths());
        // Verifica que no se haya agregado ningún vuelo
        assertEquals(0, iceepeecee.fligths().length);
    }
 
    //No se puede usar esa prueba porque no existe ese metodo loadIsland, ni tampoco getPolygon
    @Test
    public void testGetPolygonWhenVerticesAreLost() {
        Iceepeecee iceepeecee = new Iceepeecee(500, 500); 
    
        // Crea una isla del tipo SurprisingIsland
        String type = "SurprisingIsland";
        String color = "red";
        
        int[][] initialPolygon = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
        iceepeecee.addIsland(type, color, initialPolygon);

        // Carga la isla y comprueba si perdió uno de sus vertices al llamar el metodo getPolygon
        //Island island = iceepeecee.loadIsland("red");
        //int[][] updatedPolygon = island.getPolygon();
    
        //assertEquals(initialPolygon.length - 1, updatedPolygon.length);
    }
    
    //No se puede usar esa prueba porque no existe ese metodo loadIsland, ni tampoco getPolygon
     @Test
    public void testGetPolygonWhenVerticesAreNotLost() {
        Iceepeecee iceepeecee = new Iceepeecee(500, 500); 
    
        // Crea una isla del tipo SurprisingIsland
        String type = "SurprisingIsland";
        String color = "red";
        
        int[][] initialPolygon = { {0, 0}, {1, 0}, {1, 1} };
        iceepeecee.addIsland(type, color, initialPolygon);
    
        // Llama getPolygon para comprobar que la isla no perdió el vertice
        //Island island = iceepeecee.loadIsland("red");
        //int[][] updatedPolygon = island.getPolygon();
        
        assertArrayEquals(initialPolygon, iceepeecee.islandLocation("red"));
    }

    @Test
    public void testPhotographFirstCapture() {
        Iceepeecee iceepeecee = new Iceepeecee(500, 500);
        int[] from = {0, 0};
        int[] to = {1, 1};
        
        //crea la primera fotografía
        iceepeecee.addFligth("Lazy", "green", from, to);
        
        //Fligth fligth = iceepeecee.loadFligth("green");
        
        //intenta crear la segunda fotografía
        iceepeecee.photograph("green",45);
        
        assertTrue(iceepeecee.ok());
        
    }
}

// Montero Villamizar
 @Test
    public void testFixedIslandCannotBeDeleted() {
        // Prueba que no se puede eliminar una isla fija
        int[][]island =  {{0, 0}, {0, 10}, {10, 10}};
        
        iceepeecee.addIsland("fixed","red",island);
        iceepeecee.delIsland("red");
        assertFalse(iceepeecee.ok());
    }


//**BERNAL - HERNANDEZ **//
@Test
    public void accordingBHshouldAddIslandwithType() {
        Iceepeecee map = new Iceepeecee(600,600);
        map.addIsland("Surprising","red", new int[][]{{40, 20}, {60, 10}, {75, 20}, {60, 30}});
        assertTrue(map.ok());
        map.addIsland("Fixed","blue", new int[][]{{20, 30}, {50, 50}, {10, 50}});
        assertTrue(map.ok());
        map.addIsland("Normal","green", new int[][]{{20, 30}, {50, 50}, {10, 50}});
        assertTrue(map.ok());
    }
    
    @Test
    public void accordingBHshouldAddFligthwithType() {
        Iceepeecee map = new Iceepeecee(600,600);
        map.addFligth("Lazy","red", new int[]{0,30,20},new int[]{78,70,5});
        assertTrue(map.ok());
        map.addFligth("Flat","black", new int[]{5,5,10},new int[]{15,5,10});
        assertTrue(map.ok());
        map.addFligth("Normal","magenta", new int[]{55,0,20},new int[]{70,60,10}); 
        assertTrue(map.ok());
    }
    
    @Test
    public void accordingBHShouldRemovePointsFromSurprisingIsland(){
        Iceepeecee map = new Iceepeecee(600,600);
        int[][] polygon = {{70,30},{50,50},{80,100},{40,300}};
        map.addIsland("Surprising","red", polygon);
        assertEquals(3, map.islandLocation("red").length);
        map.makeInvisible();
    }
    
    @Test
    public void accordingBHshouldNotAddFlatFligthWithDifferentAltitude(){
        Iceepeecee map = new Iceepeecee(600,600);
        map.addFligth("Flat","red", new int[]{5,5,6},new int[]{15,5,10}); 
        assertEquals(0, map.fligths().length);
    }
    
    @Test
    public void accordingBHShouldNotTakeMoreThanOnePhotoLazyFligth(){
        Iceepeecee map = new Iceepeecee(600,600);
        map.addFligth("Lazy", "red", new int[]{50,50,10}, new int[]{150,50,10});
        map.photograph("red", 20);
        assertTrue(map.ok());
        map.photograph("red", 80);
        assertNotEquals(map.fligthCamera("red"), 80); // Verificamos que la camara no cambie su angulo
        assertEquals(map.fligthCamera("red"), 20);  // Verificamos que la camara no cambie su angulo
    }
    
    @Test
    public void accordingBHShouldNotDeleteFixedIsland(){
        Iceepeecee map = new Iceepeecee(600,600);
        map.addIsland("Fixed", "blue", new int[][]{{40,20},{60,10},{75,20},{60,30}});
        map.delIsland("blue");
        assertFalse(map.ok());
        assertTrue(map.islands() != null);
    }
 //  ACHURI-GIL[EDITAR]
    
       
    
    @Test
    public void ShouldFunctiontestAddFligthAchuri_Gil() {
        Iceepeecee iceepeecee = new Iceepeecee(100,100);
        iceepeecee.addFligth("normal", "red", new int[]{0, 0, 0}, new int[]{100, 100, 100});
        assertTrue(iceepeecee.ok());
        assertEquals(1, iceepeecee.fligths().length);
    }
    
     @Test
    public void ShouldFunctionTakeMoreThanOnePhotographLazyFligthAchuri_Gil() {
        Iceepeecee iceepeecee = new Iceepeecee(100,100);
        iceepeecee.addFligth("Lazy", "red", new int[]{0, 0, 50}, new int[]{100, 100, 100});
        iceepeecee.photograph(30);
        assertTrue(iceepeecee.ok());
        iceepeecee.photograph(50);
        assertEquals(30, iceepeecee.fligthCamera("red"));
    }



    
}