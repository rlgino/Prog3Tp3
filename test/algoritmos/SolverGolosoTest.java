package algoritmos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import enums.Pais;
import enums.Posicion;
import generadores.Generador;
import generadores.GeneradorAleatorio;
import modelo.Jugador;

public class SolverGolosoTest {
	SolverGoloso solver;
	Instancia instancia;
	private Posicion[] posiciones;
	
	@Before
	public void setup(){
		posiciones = Posicion.values();
	}
	
	@Test
	public void equipoCompletoTest() {
		//Setup
		Generador generador = new GeneradorAleatorio();
		this.instancia = new Instancia();
		
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(0);
			jugador.setCantTarjetas(0);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			instancia.agregarJugador(jugador);
		}
		
		//Exercise
		solver = new SolverGoloso(instancia, generador);
		Conjunto resultado = solver.resolver();

		//Verify
		assertEquals(resultado.obtenerJugadores().size(),11);
		for(Jugador jugador : instancia.getJugadores())
			assertTrue(resultado.contiene(jugador));
	}
	
	@Test
	public void equipoLimiteAmarillaTest() {
		Generador generador = new GeneradorAleatorio();
		this.instancia = new Instancia();
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(0);
			jugador.setCantTarjetas(1);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[x]);
			jugador.agregarPosicion(posiciones[x]);
			instancia.agregarJugador(jugador);
		}
		
		//Exercise
		solver = new SolverGoloso(instancia, generador);
		Conjunto resultado = solver.resolver();

		//Verify
		assertEquals(resultado.obtenerJugadores().size(),Conjunto.LIMITE_AMARILLAS);	
	}

	@Test
	public void equipoLimiteSinGolesTest() {
		Generador generador = new GeneradorAleatorio();
		this.instancia = new Instancia();
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
			instancia.agregarJugador(jugador);
		}
		
		//Exercise
		solver = new SolverGoloso(instancia, generador);
		Conjunto resultado = solver.resolver();

		//Verify
		assertEquals(resultado.obtenerJugadores().size(),Conjunto.LIMITE_SIN_GOLES);
	}
	
	@Test
	public void equipoMismoPaisTest() {
		//Setup
		Generador generador = new GeneradorAleatorio();
		this.instancia = new Instancia();
		
		for (int x = 0; x < posiciones.length; x++) {
			Jugador jugador = new Jugador();
			jugador.setNombre("jugador" + x);
			jugador.setGoles(x);
			jugador.setCantFaltas(x);
			jugador.setCantTarjetas(0);
			jugador.setPromedio(x);
			jugador.setNacionalidad(Pais.values()[0]);
			jugador.agregarPosicion(posiciones[x]);
			instancia.agregarJugador(jugador);
		}
		
		//Exercise
		solver = new SolverGoloso(instancia, generador);
		Conjunto resultado = solver.resolver();

		//Verify
		assertEquals(resultado.obtenerJugadores().size(),Conjunto.LIMITE_PAIS);
		for(Jugador jugador : instancia.getJugadores())
			assertTrue(jugador.getNacionalidad().equals(Pais.values()[0]));
	}
}
