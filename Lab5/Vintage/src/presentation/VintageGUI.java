import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class VintageGUI extends JFrame{
	public VintageGUI(){
		prepareElements();
		prepareActions();
	}
	public static void main(String [] args){
		VintageGUI vintage = new VintageGUI(); 
		vintage.setVisible(true);
	}
	private void prepareElements(){
		setTitle("Vintage");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(dimension.width / 2, dimension.height / 2));
		setLocationRelativeTo(null);
		prepareElementsMenu();
	}
	private void prepareElementsMenu(){
		JButton nuevaPartida = new JButton("Nueva partida");
		JButton continuar = new JButton("Continuar");
		setLayout(new BorderLayout());
		//BufferedImage logo = ImageIO.read(new File("/resursos/colorful-candy-background-vector.jpg"));
        //JLabel label = new JLabel(new ImageIcon(logo));
		//add(label);
		add(nuevaPartida,BorderLayout.NORTH);
		add(continuar,BorderLayout.SOUTH);
	}

	private void prepareActions(){


		WindowAdapter oyenteDeSalidaW;
        oyenteDeSalidaW = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitWindow();
            }
        };
		this.addWindowListener(oyenteDeSalidaW);		
	}

	private void exitApp(){
		int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir?", "confirmacion", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
		System.out.println("adios");
		setVisible(false);
		dispose();
		} else if (option == JOptionPane.NO_OPTION) {

		}
	}

	private void exitWindow(){
		int result = JOptionPane.showConfirmDialog(this, "Seguro que quiere salir", "¿Salir?", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_NO_OPTION) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (result == JOptionPane.NO_OPTION) {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
	}
}