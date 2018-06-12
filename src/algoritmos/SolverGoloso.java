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
		
		for (Posicion p : Posicion.values())
			posicionesClone.add(p);

		while (!posicionesClone.isEmpty()) {
			Posicion posicionActual = posicionesClone.get(guess(posicionesClone.size()));

			List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
			ordenados.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
			for (Jugador j : jugPorPosicion) {
				if (puedeSerIncluido(j, ret)) {
					agregarJugador(j, posicionActual, ret);
					break;
				}
				posicionesClone.remove(posicionActual);
			}

		}
		return ret;
	}

	private boolean puedeSerIncluido(Jugador j, Conjunto ret) {
		if (ret.contiene(j)) {
			return false;
		}
		if (j.getCantTarjetas() > 0 && ret.esLimiteAmarilla()) {
			System.out.println(j.getNombre() + " Limite de tarjetas");
			return false;
		}
		if (j.getGoles() == 0 && ret.esLimiteSinGoles()) {
			System.out.println(j.getNombre() + " Limite sin goles");
			return false;
		}
		if (ret.esLimitePorPais(j.getNacionalidad().getId())) {
			System.out.println(j.getNombre() + " Limite por pais");
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
