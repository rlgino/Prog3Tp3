package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EquipoIdealForm {

	private JFrame frame;
	String[] resultado ;


	/**
	 * Create the application.
	 */
	public EquipoIdealForm(String[] resultado){
		this.resultado = resultado;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblArquero = new JLabel("Arquero");
		lblArquero.setBounds(174, 25, 100, 16);
		lblArquero.setText(resultado[0]);
		frame.getContentPane().add(lblArquero);
		
		JLabel lblLateral4 = new JLabel("Lateral");
		lblLateral4.setBounds(31, 80, 100, 16);
		lblLateral4.setText(resultado[4]);
		frame.getContentPane().add(lblLateral4);
		
		JLabel lblCentral2 = new JLabel("Central");
		lblCentral2.setBounds(100, 51, 100, 16);
		lblCentral2.setText(resultado[1]);
		frame.getContentPane().add(lblCentral2);
		
		JLabel lblCentral6 = new JLabel("Central");
		lblCentral6.setBounds(250, 51, 100, 16);
		lblCentral6.setText(resultado[2]);
		frame.getContentPane().add(lblCentral6);
		
		JLabel lblLateral3 = new JLabel("Lateral");
		lblLateral3.setBounds(350, 80, 100, 16);
		lblLateral3.setText(resultado[3]);
		frame.getContentPane().add(lblLateral3);
		
		JLabel lblVolante5 = new JLabel("Volante");
		lblVolante5.setBounds(174, 98, 100, 16);
		lblVolante5.setText(resultado[5]);
		frame.getContentPane().add(lblVolante5);
		
		JLabel lblVolante8 = new JLabel("Volante");
		lblVolante8.setBounds(100, 147, 100, 16);
		lblVolante8.setText(resultado[7]);
		frame.getContentPane().add(lblVolante8);
		
		JLabel lblVolante7 = new JLabel("Volante");
		lblVolante7.setBounds(250, 147, 100, 16);
		lblVolante7.setText(resultado[6]);
		frame.getContentPane().add(lblVolante7);
		
		JLabel lblExtremo10 = new JLabel("Extremo");
		lblExtremo10.setBounds(31, 190, 100, 16);
		lblExtremo10.setText(resultado[9]);
		frame.getContentPane().add(lblExtremo10);
		
		JLabel lblExtremo11 = new JLabel("Extremo");
		lblExtremo11.setBounds(350, 190, 100, 16);
		lblExtremo11.setText(resultado[10]);
		frame.getContentPane().add(lblExtremo11);
		
		JLabel lblDelantero9 = new JLabel("Delantero");
		lblDelantero9.setBounds(174, 220, 100, 16);
		lblDelantero9.setText(resultado[8]);
		frame.getContentPane().add(lblDelantero9);
	}
}
