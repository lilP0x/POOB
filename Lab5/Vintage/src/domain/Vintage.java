package domain;


public class Vintage{

    private Board board;

    public Vintage(int row, int column){
        int width = row;
        int length = column;
        board = new Board(column,row,"g");
    
    }

    public boolean play(int rowI, int columI, int rowF, int columnF) {
        
        return board.play(rowI,columI,rowF,columnF);    
    }

    public char[][] board(){

        return board.getBoard();
    }

    public int[] jewels(){

        return null;
    }

    public int getPuntuation(){

        return board.getPuntuation();

    }
    public void printBoard() {
        char[][] matrix = board();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}