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
	
	@Test
	public void equipoCompletoTest() {
		//Exercise
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(0);
			jugador.setCantTarjetas(0);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			controlador.agregarJugador(jugador);
		}

		//Verify
		Conjunto resultado = controlador.seleccionarEquipo();
		assertTrue(controlador.obtenerJugadores().length == 11);
		assertFalse(resultado.esLimiteAmarilla());
		assertFalse(resultado.esLimiteSinGoles());
	}

	
	@Test
	public void equipoLimiteAmarillaTest() {
		//Exercise
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(0);
			jugador.setCantTarjetas(1);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			controlador.agregarJugador(jugador);
		}

		//Verify
		Conjunto resultado = controlador.seleccionarEquipo();
		assertEquals(resultado.obtenerJugadores().size(), Conjunto.LIMITE_AMARILLAS );
	}

	@Test
	public void equipoLimiteSinGolesTest() {
		//Exercise
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(0);
			jugador.setCantFaltas(0);
			jugador.setCantTarjetas(1);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			controlador.agregarJugador(jugador);
		}

		//Verify
		Conjunto resultado = controlador.seleccionarEquipo();
		assertEquals(resultado.obtenerJugadores().size(), Conjunto.LIMITE_SIN_GOLES );
	}

	@After
	public void despuesDelTest() {
		File fichero = new File(PATH_TEST);
		if (!fichero.delete()) throw new RuntimeException("El fichero no puede ser borrado");
	}
}
