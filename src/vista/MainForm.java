package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import enums.Posicion;
import modelo.Jugador;

import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		JList<String> list = new JList<String>();
		list.setBounds(543, 31, 230, 500);
		list.setListData(controlador.getNombreDeJugadores());
		frame.getContentPane().add(list);

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

		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setBounds(283, 155, 61, 16);
		frame.getContentPane().add(lblPosicion);

		JComboBox<Posicion> posicionCmb = new JComboBox<Posicion>();
		posicionCmb.setBounds(350, 151, 130, 26);
		for (int x = 0; x < Posicion.values().length; x++)
			posicionCmb.addItem(Posicion.values()[x]);
		frame.getContentPane().add(posicionCmb);

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
				Posicion posicion = (Posicion) posicionCmb.getSelectedItem();

				nombreTxt.setText("");
				golesTxt.setText("");
				tarjetasTxt.setText("");
				faltasTxt.setText("");
				puntajeTxt.setText("");
				posicionCmb.setSelectedItem(Posicion.ARQUERO);

				jugador.setNombre(nombre);
				jugador.setGoles(goles);
				jugador.setCantFaltas(faltas);
				jugador.setCantTarjetas(tarjetas);
				jugador.setPromedio(puntaje);
				jugador.setPosicion(posicion);

				controlador.agregarJugador(jugador);

				list.setListData(controlador.getNombreDeJugadores());
			}
		});
		btnAgregar.setBounds(130, 217, 117, 29);
		frame.getContentPane().add(btnAgregar);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(803, 26, 117, 29);
		frame.getContentPane().add(btnCalcular);
	}
}
