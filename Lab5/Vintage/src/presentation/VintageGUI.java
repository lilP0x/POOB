import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.awt.FontFormatException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URL;

import java.awt.*;
import java.awt.event.*;
import java.io.File;



public class VintageGUI extends JFrame{

	private JMenuItem salir,salvar,abrir,nuevo,color;
	private JMenu opciones;
	private JMenuBar menu;
	private JFileChooser fileChooser;
	private JPanel[][] board;
	private JPanel[][] boardInicial;
	private JButton continuar, nuevaPartida,volver;
	private JPanel padre, padre2;
	private CardLayout cardLayout;
	private Color color1;

	

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
		color1 = new Color(25,25,25,25);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        padre = new JPanel();
        padre2 = new JPanel();

        prepareElementsMenu();
        prepareElementsBoard();

        padre.setLayout(new GridLayout(3, 1));
        padre.add(preparePanelArriba());
	padre.add(preparePanelMedio());
        padre.add(preparePanelAbajo());

		padre2.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0; 
    	constraints.weighty = 0.7;  
 

		padre2.add(prepareElementsBoard(),constraints);

        constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 0.3;

		padre2.add(prepareBoardInfo(),constraints);
		

        add(padre, "padre");
        add(padre2, "padre2");
    }
	private void prepareElementsMenu(){
		
		menu = new JMenuBar();
		opciones = new JMenu("opciones");
		abrir= new JMenuItem("abrir");
		nuevo = new JMenuItem("nuevo");
		salvar = new JMenuItem("salvar");
		salir = new JMenuItem("salir");
		color = new JMenuItem("color");
		fileChooser = new JFileChooser();
		opciones.add(nuevo);
		opciones.add(abrir);
		opciones.add(salvar);
		opciones.add(salir);
		opciones.add(color);
		menu.add(opciones);
		setJMenuBar(menu);
		prepareActionsMenu();
	}

	private JPanel prepareElementsBoard() {
		JPanel panel = new JPanel();
		board = new JPanel[8][8];
		panel.setLayout(new GridLayout(8,8,2,2));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new JPanel(); 
				board[i][j].setBackground(new Color(25,25,25,25));
				panel.add(board[i][j]);
			}
		}
		boardInicial = board;
		return panel;
	}
	

	private void updateBoardColor() {
		if (color1 != null) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					board[i][j].setBackground(color1);
				}
			}
		}
	}

	private JPanel prepareBoardInfo(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        	constraints.gridx = 0;
        	constraints.gridy = 5;
        	constraints.insets = new Insets(1, 30, 1, 30);

		volver = new JButton("volver");
		panel.add(volver, constraints);		
		JButton reiniciar = new JButton("reiniciar");
		constraints.gridx = 2;
		panel.add(reiniciar, constraints);
		panel.setBackground(new Color(255,128,0));
		return panel;
	}

	private JPanel preparePanelMedio(){
		JPanel panel = new JPanel(new BorderLayout());
        ImageIcon originalIcon = createImageIcon("feo.png");

        if (originalIcon != null) {
            int width = originalIcon.getIconWidth();
            int height = originalIcon.getIconHeight();

            int maxSize = 150;

            if (width > maxSize || height > maxSize) {
                if (width > height) {
                    height = maxSize * height / width;
                    width = maxSize;
                } else {
                    width = maxSize * width / height;
                    height = maxSize;
                }
            }

            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);

            panel.add(imageLabel, BorderLayout.CENTER);
          
        } 
	panel.setBackground(new Color(255,128,0));
	return panel;
}

	private JPanel preparePanelAbajo(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.insets = new Insets(1, 30, 1, 30); 

        nuevaPartida = new JButton("Nuevo juego");
        nuevaPartida.setFont(new Font("Courier New", Font.PLAIN, 12));
        nuevaPartida.setBackground(new Color(150, 200, 100));
        nuevaPartida.setForeground(Color.black);

        continuar = new JButton("Continuar");
        continuar.setFont(new Font("Courier New", Font.PLAIN, 12));
        continuar.setBackground(new Color(255, 250, 205));
        continuar.setForeground(Color.black);

        panel.add(nuevaPartida, constraints);

        constraints.gridx = 1;
	constraints.gridy = 5;
        panel.add(continuar, constraints);
	panel.setBackground(new Color(255,128,0));

		return panel;
	}

	private JPanel preparePanelArriba() {
    	Font customFont = null;

   	 try {
        	customFont = Font.createFont(Font.TRUETYPE_FONT, new File("tommy.ttf")).deriveFont(60f);

    	} catch (IOException | FontFormatException e) {
        	customFont = new Font("Courier New", Font.PLAIN, 60);
    	}

    	JPanel panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints constraints = new GridBagConstraints();
    	constraints.gridx = 0;
   	constraints.gridy = 0;
    	constraints.insets = new Insets(10, 0, 10, 0);

    	JLabel titulo = new JLabel("Vintage");
    	if (customFont != null) {
        	titulo.setFont(customFont);
    	}
    	panel.add(titulo, constraints);
	panel.setBackground(new Color(255,128,0));

    return panel;
}


	private void refresh(){
		board = boardInicial;
	}

	private void prepareActions(){


		WindowAdapter oyenteDeSalidaW;
        oyenteDeSalidaW = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitWindow();
            }
        };
		this.addWindowListener(oyenteDeSalidaW);

		ActionListener oyenteDeInicio;
		oyenteDeInicio = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				cambio();
			}
		};
		nuevaPartida.addActionListener(oyenteDeInicio);

		ActionListener oyenteDeVolver;
		oyenteDeVolver = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				cambio();
			}
		};	
		volver.addActionListener(oyenteDeVolver);
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

		ActionListener oyenteDeColor;
		oyenteDeColor = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				cambioColor();
			}
		};
		color.addActionListener(oyenteDeColor);
	
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

	private void cambio(){		
        cardLayout.next(getContentPane());

    
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

	private void cambioColor(){

		color1 = JColorChooser.showDialog(this, "Choose a Color", color1);
		updateBoardColor();
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
	protected ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
}