package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import enums.Posicion;
import generadores.Generador;
import modelo.Jugador;

public class SolverGoloso {

	private Instancia instancia;
	private Generador _random;

	public SolverGoloso(Instancia instancia, Generador generador) {
		this.instancia = instancia;
		_random = generador;
	}

	private int guess(int t) {
		int i = _random.nextInt(t < 1 ? 1 : t);
		return i;
	}

	public Conjunto resolver() {
		Conjunto ret = new Conjunto();
		List<Jugador> ordenados = ordenarJugadores();
		List<Posicion> posicionesClone = new ArrayList<Posicion>();
		
		for (Posicion posicion : Posicion.values())
			posicionesClone.add(posicion);

		while (!posicionesClone.isEmpty()) {
			Posicion posicionActual = posicionesClone.get(guess(posicionesClone.size()));

			List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
			ordenados.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
			for (Jugador jugador : jugPorPosicion) {
				if (puedeSerIncluido(jugador, ret)) {
					ret.agregar(jugador, posicionActual);
					break;
				}
				posicionesClone.remove(posicionActual);
			}

		}
		return ret;
	}

	private boolean puedeSerIncluido(Jugador jugador, Conjunto conjunto) {
		if (conjunto.contiene(jugador)) {
			return false;
		}
		if (jugador.getCantTarjetas() > 0 && conjunto.esLimiteAmarilla()) {
			return false;
		}
		if (jugador.getGoles() == 0 && conjunto.esLimiteSinGoles()) {
			return false;
		}
		if (conjunto.esLimitePorPais(jugador.getNacionalidad().getId())) {
			return false;
		}
		return true;
	}

	private List<Jugador> ordenarJugadores() {
		ArrayList<Jugador> ret = instancia.getJugadores();
		Collections.sort(ret);
		return ret;
	}
}
