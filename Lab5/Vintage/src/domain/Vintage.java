public class Vintage{
	private int width;
	private int length;
	private Board board;

	public Vintage(	int row, int column){
		width = row;
		length = column;
		board = new Board();
	
	}

	public boolean play(int rowI, int columI, int rowF, int columnF) {
		
		return board.play(rowI,columI,rowF,columnF);	
	}

	public char[][] board(){

		return null;
	}

	public int[] jewels(){
		
		return board.getJewels();
		
	}

	public int getPuntuation(){

		return board.getPuntuation();

	}

}