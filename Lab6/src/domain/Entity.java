package domain;
import java.awt.Color;

/*No olviden adicionar la documentacion*/
public interface Entity{
  int ROUND = 1;
  int SQUARE = 2;
  int INSECT = 3;

   
  void act();
  
  int getColumn();
  
  int getRow();
  
  char getSoy();
  
  default int shape(){
      return SQUARE;
  }
  
  default Color getColor(){
      if (this instanceof Flower) {
            return Color.red; 
        } else if (this instanceof Food) {
            return Color.orange; 
        } else {
            return Color.red; 
        }
    };
  
  default boolean is(){
      return true;
  }
  
}
