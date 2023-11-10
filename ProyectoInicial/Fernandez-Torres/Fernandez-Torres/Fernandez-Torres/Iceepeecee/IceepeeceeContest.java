/**
 * Write a description of class IceepeeceeContest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IceepeeceeContest
{   
    private Iceepeecee i;
    
    public IceepeeceeContest(){
        
    }
    
    public float solve(int[][][] islands, int[][][] fligths) {
        boolean antes = false;
        boolean actual = false;
        int ant = -1;
        Iceepeecee i = new Iceepeecee(islands, fligths);
        int contador = 0;
    
        while (contador <= 180 && !antes && !actual) {
            i.photograph(contador);
            if (i.observedIsland().length == islands.length) {
                actual = true;
                antes = false;
                ant = contador - 1;
            }
            contador++;
        }
    
        float actu = ant + 0.1f;
        float ante = ant;
        float cont1 = ant + 0.1f;
        antes = false;
        actual = false;

        while (cont1 <= ant + 0.9 && !antes && !actual) {
            i.photograph(cont1);
            if (i.observedIsland().length == islands.length) {
                actual = true;
                antes = false;
                actu = cont1;
                ante = cont1 - 0.1f;
            }
            cont1 += 0.1f;
        }

        return actu;
    }
    
    
    public void simulate(int[][][] islands, int[][][] fligths){
        i = new Iceepeecee (islands,fligths);
        i.makeVisible();
    }
}