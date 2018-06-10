package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import con.instancia.Conjunto;
import enums.Posicion;
import modelo.Jugador;

public class EquipoIdealForm {

	private JFrame frame;
	HashMap<Posicion, Jugador> resultado ;


	/**
	 * Create the application.
	 */
	public EquipoIdealForm(Conjunto conjunto){
		this.resultado = conjunto.obtenerJugadores();
		initialize();
	}

	public EquipoIdealForm(HashMap<Posicion, Jugador> res) {
		this.resultado = res;
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public void cargar() {		
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoIdealForm window = new EquipoIdealForm(resultado);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 697, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton cerrarBtn = new JButton("Cerrar");
		cerrarBtn.setBounds(0, 0, 100, 29);
		cerrarBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
			
		});
		frame.getContentPane().add(cerrarBtn);
		
		JLabel lblArquero = new JLabel("Arquero");
		lblArquero.setBounds(174, 25, 100, 16);
		frame.getContentPane().add(lblArquero);
		
		JLabel lblLateral4 = new JLabel("Lateral");
		lblLateral4.setBounds(31, 80, 100, 16);
		frame.getContentPane().add(lblLateral4);
		
		JLabel lblCentral2 = new JLabel("Central");
		lblCentral2.setBounds(100, 51, 100, 16);
		frame.getContentPane().add(lblCentral2);
		
		JLabel lblCentral6 = new JLabel("Central");
		lblCentral6.setBounds(250, 51, 100, 16);
		frame.getContentPane().add(lblCentral6);
		
		JLabel lblLateral3 = new JLabel("Lateral");
		lblLateral3.setBounds(350, 80, 100, 16);
		frame.getContentPane().add(lblLateral3);
		
		JLabel lblVolante5 = new JLabel("Volante");
		lblVolante5.setBounds(174, 98, 100, 16);
		frame.getContentPane().add(lblVolante5);
		
		JLabel lblVolante8 = new JLabel("Volante");
		lblVolante8.setBounds(100, 147, 100, 16);
		frame.getContentPane().add(lblVolante8);
		
		JLabel lblVolante7 = new JLabel("Volante");
		lblVolante7.setBounds(250, 147, 100, 16);
		frame.getContentPane().add(lblVolante7);
		
		JLabel lblExtremo10 = new JLabel("Extremo");
		lblExtremo10.setBounds(31, 190, 100, 16);
		frame.getContentPane().add(lblExtremo10);
		
		JLabel lblExtremo11 = new JLabel("Extremo");
		lblExtremo11.setBounds(350, 190, 100, 16);
		frame.getContentPane().add(lblExtremo11);
		
		JLabel lblDelantero9 = new JLabel("Delantero");
		lblDelantero9.setBounds(174, 220, 100, 16);
		frame.getContentPane().add(lblDelantero9);
		
		JLabel amarillasLbl = new JLabel("Limite por pais alcanzado");
		amarillasLbl.setForeground(Color.RED);
		amarillasLbl.setBounds(450, 25, 201, 16);
		frame.getContentPane().add(amarillasLbl);
		
		JLabel paisesLbl = new JLabel("Limite de amarillas alcanzado");
		paisesLbl.setForeground(Color.RED);
		paisesLbl.setBounds(450, 80, 201, 16);
		frame.getContentPane().add(paisesLbl);
		
		JLabel sinGolesLbl = new JLabel("Limite sin goles alcanzado");
		sinGolesLbl.setForeground(Color.RED);
		sinGolesLbl.setBounds(450, 147, 201, 16);
		frame.getContentPane().add(sinGolesLbl);
		

		if(resultado.get(Posicion.ARQUERO) == null) lblArquero.setText("");
		else lblArquero.setText(resultado.get(Posicion.ARQUERO).getNombre());

		if(resultado.get(Posicion.PRIMER_CENTRAL) == null) lblCentral2.setText("");
		else lblCentral2.setText(resultado.get(Posicion.PRIMER_CENTRAL).getNombre());

		if(resultado.get(Posicion.SEGUNDO_CENTRAL) == null) lblCentral6.setText("");
		else lblCentral6.setText(resultado.get(Posicion.SEGUNDO_CENTRAL).getNombre());

		if(resultado.get(Posicion.LATERAL_DERECHO) == null) lblLateral4.setText("");
		else lblLateral4.setText(resultado.get(Posicion.LATERAL_DERECHO).getNombre());

		if(resultado.get(Posicion.LATERAL_IZQUIERDO) == null) lblLateral3.setText("");
		else lblLateral3.setText(resultado.get(Posicion.LATERAL_IZQUIERDO).getNombre());

		if(resultado.get(Posicion.VOLANTE_CENTRAL) == null) lblVolante5.setText("");
		else lblVolante5.setText(resultado.get(Posicion.VOLANTE_CENTRAL).getNombre());

		if(resultado.get(Posicion.VOLANTE_DERECHO) == null) lblVolante8.setText("");
		else lblVolante8.setText(resultado.get(Posicion.VOLANTE_DERECHO).getNombre());

		if(resultado.get(Posicion.VOLANTE_IZQUIERDO) == null) lblVolante7.setText("");
		else lblVolante7.setText(resultado.get(Posicion.VOLANTE_IZQUIERDO).getNombre());

		if(resultado.get(Posicion.PUNTERO_DERECHO) == null) lblExtremo10.setText("");
		else lblExtremo10.setText(resultado.get(Posicion.PUNTERO_DERECHO).getNombre());

		if(resultado.get(Posicion.PUNTERO_IZQUIERDO) == null) lblExtremo11.setText("");
		else lblExtremo11.setText(resultado.get(Posicion.PUNTERO_IZQUIERDO).getNombre());

		if(resultado.get(Posicion.CENTRO_DELANTERO) == null) lblDelantero9.setText("");
		else lblDelantero9.setText(resultado.get(Posicion.CENTRO_DELANTERO).getNombre());
	}
}
