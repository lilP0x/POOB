import java.util.ArrayList;

public class Board {
    private Player jugador;
    private int width, length;
    private Box[][] tablero;

    public Board(int width, int length, String name) {
        this.width = width;
        this.length = length;
        tablero = new Box[width][length];
        jugador = new Player(name);
    }

    public Player getPlayer() {
        return jugador;
    }

    public boolean play(int rowI, int columnI, int rowF, int columnF) {
        Box b = tablero[rowI][columnI];
        Box o = tablero[rowF][columnF];
        if (o != null && tablero[rowF][columnF].play()) {
            tablero[rowI][columnI] = o;
            tablero[rowF][columnF] = b;
        }
        return tablero[rowF][columnF].play();
    }

    public Box[][] getJewels() {
        Box[][] gemas = new Box[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (tablero[i][j] != null)
                    gemas[i][j] = tablero[i][j];
            }
        }
        return gemas;
    }

    private void initialBoxes() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (tablero[i][j] == null)
                    tablero[i][j] = new Box();
            }
        }
    }

    public int getPuntuation() {
        return jugador.getPuntuation();
    }
}