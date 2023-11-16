public class Vintage{
	private int[][] size;
	private Board board;

	public Vintage(	int row, int column){
		board = new Board();
	
	}

	public boolean play(int rowI, int columI, int rowF, int columnF) {
		
		return board.play();	
	}

	public char[][] board(){

		return null;
	}

	public int[] jewels(){
		return 0;
		
	}

}