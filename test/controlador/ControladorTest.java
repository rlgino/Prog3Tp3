package controlador;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algoritmos.Conjunto;
import enums.Pais;
import enums.Posicion;
import modelo.Jugador;

public class ControladorTest {

	private static final String PATH_TEST = "./src/datos1.txt";
	private Controlador controlador;
	private Posicion[] posiciones;
	
	@Before
	public void setup(){
		//Setup
		Controlador.PATH = PATH_TEST;
		controlador = new Controlador();
		posiciones = Posicion.values();
	}

	@Test
	public void controladorBasicoTest() {
		//Exercise
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(x);
			jugador.setCantTarjetas(x);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			controlador.agregarJugador(jugador);
		}

		//Verify
		Conjunto resultado = controlador.seleccionarEquipo();
		assertTrue(controlador.obtenerJugadores().length == 11);
		assertTrue(resultado.esLimiteAmarilla());
	}

	@After
	public void despuesDelTest() {
		File fichero = new File(PATH_TEST);
		if (!fichero.delete()) throw new RuntimeException("El fichero no puede ser borrado");
	}
}
