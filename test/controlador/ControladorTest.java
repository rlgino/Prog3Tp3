package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.Posicion;
import modelo.Jugador;

public class ControladorTest {

	@Test
	public void primerTestControlador() {
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
		
		assertTrue(controlador.getNombresDeJugadores().length == 11);
	}
}
