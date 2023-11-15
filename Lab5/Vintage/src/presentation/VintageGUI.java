import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VintageGUI extends JFrame{

	JMenuItem salir,salvar,abrir;
	JMenu opciones;
	JMenuBar menu;
	JFileChooser fileChooser;
	JPanel[][] board;
	JPanel padre;
	JPanel padre2;
	JButton cambiarBoton, continuar, nuevaPartida;
	

	public VintageGUI(){
		prepareElements();
		prepareActions();
	}
	public static void main(String [] args){
		VintageGUI vintage = new VintageGUI(); 
		vintage.setVisible(true);
	}
	private void prepareElements(){
		padre = new JPanel();
		padre2 = new JPanel();
		setTitle("Vintage");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(dimension.width / 2, dimension.height / 2));
		setLocationRelativeTo(null);
		nuevaPartida = new JButton("Nueva partida");
		continuar = new JButton("Continuar");
		cambiarBoton = new JButton("Cambiar Pantalla");
		setLayout(new BorderLayout());
		padre.setLayout(new GridLayout(3,3));
		padre.add(nuevaPartida);
		padre.add(continuar);
		padre.add(cambiarBoton);
		add(padre,BorderLayout.CENTER);
		add(padre2,BorderLayout.CENTER);
		prepareElementsMenu();
		prepareElementsBoard();

	}
	private void prepareElementsMenu(){
		
		menu = new JMenuBar();
		opciones = new JMenu("opciones");
		abrir= new JMenuItem("abrir");
		salvar = new JMenuItem("salvar");
		salir = new JMenuItem("salir");
		fileChooser = new JFileChooser();
		opciones.add(abrir);
		opciones.add(salvar);
		opciones.add(salir);
		menu.add(opciones);
		setJMenuBar(menu);
		prepareActionsMenu();
		//BufferedImage logo = ImageIO.read(new File("/resursos/colorful-candy-background-vector.jpg"));
        //JLabel label = new JLabel(new ImageIcon(logo));
		//add(label);
		
	}

	private void prepareElementsBoard(){
		board = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new JPanel(); 
                padre.add(board[i][j]);
            }
        }

	}

	private void refresh(){


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

	private void prepareActionsMenu(){

		ActionListener oyenteDeSalidaApp;
		oyenteDeSalidaApp = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                exitApp();
            }
		};		
		salir.addActionListener(oyenteDeSalidaApp);

		ActionListener oyenteDeAbrir;
		oyenteDeAbrir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                fileChoiceAbrir();
            }
		};		
		abrir.addActionListener(oyenteDeAbrir);

		ActionListener oyenteDeSalvar;
		oyenteDeSalvar = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                fileChoiceSalvar();
            }
		};		
		salvar.addActionListener(oyenteDeSalvar);

		cambiarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				cambioDePanel();
            }
        });

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

	private void cambioDePanel(){		
        // Cambiar entre los paneles al hacer clic en el botón
		if (getContentPane().getComponent(0) == padre) {
			getContentPane().remove(padre);
			getContentPane().add(padre);
		} else {
			getContentPane().remove(padre2);
			getContentPane().add(padre2, BorderLayout.CENTER);
		}

		// Actualizar la interfaz
		revalidate();
		repaint();

	}

	private void fileChoiceAbrir(){

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "La funcion esta en desarrollo","Abrir archivo",JOptionPane.INFORMATION_MESSAGE);
        }

	}

	private void fileChoiceSalvar(){

		int result = fileChooser.showSaveDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "La funcion esta en desarrollo", "Guardar Archivo", JOptionPane.INFORMATION_MESSAGE);
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