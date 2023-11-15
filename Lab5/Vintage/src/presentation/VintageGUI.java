import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;



public class VintageGUI extends JFrame{

	JMenuItem salir,salvar,abrir,nuevo;
	JMenu opciones;
	JMenuBar menu;
	JFileChooser fileChooser;
	JPanel[][] board;
	JButton cambiarBoton, continuar, nuevaPartida;
	JPanel padre, padre2;
	

	public VintageGUI(){
		prepareElements();
		prepareActions();
	}
	public static void main(String [] args){
		VintageGUI vintage = new VintageGUI(); 
		vintage.setVisible(true);
	}
	private void prepareElements() {
		setTitle("Vintage");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(dimension.width / 2, dimension.height / 2));
		setLocationRelativeTo(null);
	
		JPanel panelArriba = preparePanelArriba();
		JPanel panelAbajo = preparePanelAbajo();
	
	
		prepareElementsMenu();
		prepareElementsBoard();
	
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		// Configurar GridBagConstraints para el primer panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(panelArriba, gbc);
	
		// Configurar GridBagConstraints para el botón cambiarBoton
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(panelAbajo, gbc);

        
    }
	private void prepareElementsMenu(){
		
		menu = new JMenuBar();
		opciones = new JMenu("opciones");
		abrir= new JMenuItem("abrir");
		nuevo = new JMenuItem("nuevo");
		salvar = new JMenuItem("salvar");
		salir = new JMenuItem("salir");
		fileChooser = new JFileChooser();
		opciones.add(nuevo);
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
		JPanel padre = new JPanel();
		board = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new JPanel(); 
                padre.add(board[i][j]);
            }
        }

	}

	private JPanel preparePanelAbajo(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(1, 0, 1, 0); // Espacio vertical entre los componentes

        nuevaPartida = new JButton("Nuevo juego");
        nuevaPartida.setFont(new Font("Courier New", Font.PLAIN, 12));
        nuevaPartida.setBackground(new Color(150, 200, 100));
        nuevaPartida.setForeground(Color.WHITE);
        continuar = new JButton("Continuar");
        continuar.setFont(new Font("Courier New", Font.PLAIN, 12));
        continuar.setBackground(new Color(150, 200, 100));
        continuar.setForeground(Color.WHITE);

        panel.add(nuevaPartida, constraints);

        constraints.gridy = 1;
        panel.add(continuar, constraints);

		return panel;
	}

	private JPanel preparePanelArriba(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(1, 0, 1, 0); 

		JLabel titulo = new JLabel("Vintage");
		panel.add(titulo,constraints);

		return panel;
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

		ActionListener oyenteDeNuevo;
		oyenteDeNuevo = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		};
		nuevo.addActionListener(oyenteDeNuevo);
	
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