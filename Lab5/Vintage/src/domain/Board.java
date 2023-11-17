import java.util.ArrayList;

public class Board{
	private Player jugador;
	private int width, int length;
	private Box[][] tablero;	

	public Board(int width,int length ,String name){
		this.width = width;
		this.length = length;
		tablero = new Box[width][length];
		jugador = new juagdor(name);
	}

	public Player getplayer(){
		return jugador;
	}

	public boolean play(int rowI, int columnI, int rowF, int columnF){
		Box b = tablero[rowI][columnI];
		Box o = tablero[rowF][columnF];
		if(o != null && tablero[rowF][columnF].play()){
			tablero[rowI][columnI] = o;
			tablero[rowF][columnF] = b;
		}
		return tablero[rowF][columnF].play();
	}

	public int[] getJewels(){
		int [] gemas = new int[size];
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tablero[i][j] != null)
                    gemas[i] = tablero[i][j];
            }
        }
	}
	
	private void initialBoxes(){

		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tablero[i][j] == null)
                    tablero[i][j] = new Box();
            }
        }

	}

	public int getPuntuation(){

		return player.getPuntuation();
	}

}