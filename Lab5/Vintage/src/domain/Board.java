package domain;
import java.util.ArrayList;
import java.util.Random;


public class Board {
    private Player jugador;
    private int width, length;
    private Jewel[][] tablero;

    public Board(int width, int length, String name) {
        this.width = width;
        this.length = length;
        tablero = new Jewel[width][length];
		initialJewels();
        jugador = new Player(name);
    }

    public Player getPlayer() {
        return jugador;
    }

    public boolean play(int rowI, int columnI, int rowF, int columnF) {
    	Jewel b = tablero[rowI][columnI];
		Jewel o = tablero[rowF][columnF];
		boolean play = false;
        if (o != null && b != null){
			if((rowI == rowF && columnI+1 == columnF )||(rowI == rowF && columnI-1 == columnF )){
				tablero[rowI][columnI] = o;
				tablero[rowF][columnF] = b;
			}
			if((columnI == columnF && rowI+1 == rowF)||(columnI == columnF && rowI-1 == rowF)){
				tablero[rowI][columnI] = o;
				tablero[rowF][columnF] = b;
			}		
		}
		play = true;
        
        return play;
    }

    public char[][] getBoard(){
		char[][] gemas = new char[width][length];
			for (int i = 0; i < width; i++){
				for(int j = 0; j < length; j++){
					if(tablero[i][j] != null){
						gemas[i][j] = tablero[i][j].getType();
					}
				}

			}
        return gemas;
    }

    private void initialJewels() {
        Random random = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                int randomIndex = random.nextInt(7);

                if (randomIndex == 0) {
                    tablero[i][j] = new Red();
                } else if (randomIndex == 1) {
                    tablero[i][j] = new Magenta();
                } else if (randomIndex == 2) {
                    tablero[i][j] = new Purple();
                } else if (randomIndex == 3) {
                    tablero[i][j] = new Blue();
                } else if (randomIndex == 4) {
                    tablero[i][j] = new Green();
                } else if (randomIndex == 5) {
                    tablero[i][j] = new Yellow();
                } else if (randomIndex == 6) {
                    tablero[i][j] = new Orange();
                }
                
            }
        }
	}

    public int getPuntuation() {
        return jugador.getPuntuation();
	}
}