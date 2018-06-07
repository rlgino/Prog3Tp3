package controlador;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import enums.Posicion;
import modelo.Jugador;

public class ControladorTest {

	private static final String PATH_TEST = "./src/datos1.txt";

	@Test
	public void primerTestControlador() {
		Controlador.PATH = PATH_TEST;
		Controlador controlador = new Controlador();

		for (int x = 0; x < 11; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(x);
			jugador.setCantTarjetas(x);
			jugador.setPromedio(x);
			jugador.agregarPosicion(Posicion.values()[x]);
			controlador.agregarJugador(jugador);
		}

		//Verify
		for (int x = 0; x < 11; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			controlador.obtenerJugadores()[x].equals(jugador);
		}
		assertTrue(controlador.obtenerJugadores().length == 11);
	}

	@After
	public void despuesDelTest() {
		File fichero = new File(PATH_TEST);
		if (fichero.delete())
			System.out.println("El fichero ha sido borrado satisfactoriamente");
		else
			System.out.println("El fichero no puede ser borrado");
	}
}
