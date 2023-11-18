public class Box{
	private Jewel gema;
	private int[][] positon;

	public Box(){
		gema = new Jewel();
	}

	public boolean play(){

		return gema.play();
	}



}