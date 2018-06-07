package con.instancia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import enums.Posicion;
import modelo.Jugador;

public class SolverGoloso {

	private Instancia instancia;
	private Random _random;

	public SolverGoloso(Instancia instancia) {
		this.instancia = instancia;
		_random = new Random();
	}

	public Conjunto resolver() {
		Conjunto ret = new Conjunto();
		List<Jugador> ordenados = ordenarJugadores();

		List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
		ordenados.stream().forEach(j -> jugPorPosicion.add(j));
		while (ret.tamano() < 11 && !jugPorPosicion.isEmpty()) {
			Jugador jugadorActual = jugPorPosicion.get(guess(jugPorPosicion.size()));
			for (Posicion posicionActual : jugadorActual.getPosiciones()) {
				if (ret.obtenerJugador(posicionActual) == null && puedeSerIncluido(jugadorActual, ret)) {
					agregarJugador(jugadorActual, posicionActual, ret);
					break;
				}
			}
			jugPorPosicion.remove(jugadorActual);
		}

		return ret;
	}

	private int guess(int t) {
		int i = _random.nextInt(t < 1 ? 1 : t);
		return i;
	}

	public Conjunto resolverPorJugador() {
		Conjunto ret = new Conjunto();
		List<Jugador> ordenados = ordenarJugadores();

		// Poner Jugadores en posiciones que solo hay un solo jugador
		for (Posicion posicionActual : Posicion.values()) {
			List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
			ordenados.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
			if (jugPorPosicion.size() == 1) {
				agregarJugador(jugPorPosicion.get(0), posicionActual, ret);
			}
		}

		// Poner Jugadores que juegan en solo una posicion

		List<Jugador> jugUnicaPosicion = new ArrayList<Jugador>();
		ordenados.stream().filter(j -> j.getPosiciones().size() == 1).forEach(j -> jugUnicaPosicion.add(j));
		for (Jugador j : jugUnicaPosicion) {
			if (puedeSerIncluido(j, ret)) {
				agregarJugador(j, j.getPosiciones().get(0), ret);
				break;
			}
		}

		// Lo que falta
		for (Posicion posicionActual : Posicion.values())
			if (ret.obtenerJugador(posicionActual) == null) {
				List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
				ordenados.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
				for (Jugador j : jugPorPosicion) {
					if (puedeSerIncluido(j, ret)) {
						agregarJugador(j, posicionActual, ret);
						break;
					}
				}

			}

		return ret;
	}

	private boolean puedeSerIncluido(Jugador j, Conjunto ret) {
		if (ret.contiene(j) || ret.esLimiteAmarilla() || ret.esLimiteSinGoles()) {
			return false;
		}
		if (ret.esLimitePorPais(j.getNacionalidad().getId())) {
			return false;
		}
		return true;
	}

	private void agregarJugador(Jugador j, Posicion p, Conjunto ret) {
		ret.agregar(j, p);
	}

	private List<Jugador> ordenarJugadores() {
		ArrayList<Jugador> ret = instancia.getJugadores();
		Collections.sort(ret);
		return ret;
	}
}
