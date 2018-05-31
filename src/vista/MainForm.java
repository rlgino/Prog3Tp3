package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import enums.Pais;
import enums.Posicion;
import modelo.Jugador;

import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {

	private JFrame frame;
	private JTextField nombreTxt;
	private JLabel lblGoles;
	private JLabel lblFaltas;
	private JLabel lblTarjetas;
	private JLabel lblPuntaje;
	private JTextField golesTxt;
	private JTextField faltasTxt;
	private JTextField tarjetasTxt;
	private JTextField puntajeTxt;
	private static Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		controlador = new Controlador();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JList<String> jugadoresList = new JList<String>();
		jugadoresList.setBounds(543, 61, 230, 470);
		jugadoresList.setListData(controlador.getNombresDeJugadores());
		frame.getContentPane().add(jugadoresList);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 31, 61, 16);
		frame.getContentPane().add(lblNombre);

		lblGoles = new JLabel("Goles:");
		lblGoles.setBounds(40, 59, 61, 16);
		frame.getContentPane().add(lblGoles);

		lblFaltas = new JLabel("Faltas:");
		lblFaltas.setBounds(40, 89, 61, 16);
		frame.getContentPane().add(lblFaltas);

		lblTarjetas = new JLabel("Tarjetas:");
		lblTarjetas.setBounds(40, 122, 61, 16);
		frame.getContentPane().add(lblTarjetas);

		lblPuntaje = new JLabel("Puntaje promedio:");
		lblPuntaje.setBounds(6, 150, 114, 26);
		frame.getContentPane().add(lblPuntaje);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(259, 155, 100, 16);
		frame.getContentPane().add(lblNacionalidad);

		JLabel lblPosiciones = new JLabel("Posiciones:");
		lblPosiciones.setBounds(20, 209, 81, 16);
		frame.getContentPane().add(lblPosiciones);

		nombreTxt = new JTextField();
		nombreTxt.setBounds(117, 26, 130, 26);
		frame.getContentPane().add(nombreTxt);
		nombreTxt.setColumns(10);

		golesTxt = new JTextField();
		golesTxt.setBounds(117, 54, 130, 26);
		frame.getContentPane().add(golesTxt);
		golesTxt.setColumns(10);

		faltasTxt = new JTextField();
		faltasTxt.setBounds(117, 84, 130, 26);
		frame.getContentPane().add(faltasTxt);
		faltasTxt.setColumns(10);

		tarjetasTxt = new JTextField();
		tarjetasTxt.setBounds(117, 117, 130, 26);
		frame.getContentPane().add(tarjetasTxt);
		tarjetasTxt.setColumns(10);

		puntajeTxt = new JTextField();
		puntajeTxt.setBounds(117, 150, 130, 26);
		frame.getContentPane().add(puntajeTxt);
		puntajeTxt.setColumns(10);

		JComboBox<Pais> nacionalidadCmb = new JComboBox<Pais>();
		nacionalidadCmb.setBounds(350, 151, 130, 26);
		for (int x = 0; x < Pais.values().length; x++)
			nacionalidadCmb.addItem(Pais.values()[x]);
		frame.getContentPane().add(nacionalidadCmb);
				
		JList<Posicion> posicionesList = new JList<Posicion>();
		posicionesList.setListData(Posicion.values());
		posicionesList.setBounds(117, 204, 130, 245);
		frame.getContentPane().add(posicionesList);

		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(204, 0, 0));
		canvas.setBounds(350, 31, 100, 100);
		frame.getContentPane().add(canvas);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Jugador jugador = new Jugador();
				String nombre = nombreTxt.getText();
				int goles = Integer.parseInt(golesTxt.getText());
				int tarjetas = Integer.parseInt(tarjetasTxt.getText());
				int faltas = Integer.parseInt(faltasTxt.getText());
				double puntaje = Double.parseDouble(puntajeTxt.getText());
				Pais nacionalidad = (Pais) nacionalidadCmb.getSelectedItem();

				jugador.setNombre(nombre);
				jugador.setGoles(goles);
				jugador.setCantFaltas(faltas);
				jugador.setCantTarjetas(tarjetas);
				jugador.setPromedio(puntaje);
				jugador.setPosicionPrincipal(0);
				jugador.setNacionalidad(nacionalidad);
				for(Posicion p : posicionesList.getSelectedValuesList())
					jugador.agregarPosicion(p);

				
				nombreTxt.setText("");
				golesTxt.setText("");
				tarjetasTxt.setText("");
				faltasTxt.setText("");
				puntajeTxt.setText("");
				nacionalidadCmb.setSelectedItem(Pais.ARGENTINA);
				posicionesList.clearSelection();
				
				controlador.agregarJugador(jugador);

				jugadoresList.setListData(controlador.getNombresDeJugadores());
			}
		});
		btnAgregar.setBounds(363, 420, 117, 29);
		frame.getContentPane().add(btnAgregar);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.seleccionarEquipo();
			}
		});
		btnCalcular.setBounds(803, 26, 117, 29);
		frame.getContentPane().add(btnCalcular);

		JLabel lblJugadoresCargados = new JLabel("Jugadores cargados");
		lblJugadoresCargados.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblJugadoresCargados.setBounds(543, 26, 230, 23);
		frame.getContentPane().add(lblJugadoresCargados);
	}
}
