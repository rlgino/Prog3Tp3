package con.instancia;

import java.util.HashMap;

import enums.Pais;
import enums.Posicion;
import modelo.Jugador;

public class Conjunto {
	// --------------Constantes-----------
	private final int LIMITE_SIN_GOLES = 5;
	private final int LIMITE_AMARILLAS = 5;
	private final int LIMITE_PAIS = 4;

	private HashMap<Posicion, Jugador> jugadoresPorPosicion;
	private int[] contPais;
	private int cantAmarilla = 0;
	private int cantSinGoles = 0;

	public Conjunto() {
		contPais = new int[Pais.values().length];
		jugadoresPorPosicion = new HashMap<Posicion, Jugador>();
	}

	// --------------Verificadores----------
	public boolean esLimiteAmarilla() {
		return cantAmarilla == LIMITE_AMARILLAS;
	}

	public boolean esLimiteSinGoles() {
		return cantSinGoles == LIMITE_SIN_GOLES;
	}

	public int getCantidadEnPais(int i) {
		return contPais[i];
	}

	// ---------------Juadores

	public void agregar(Jugador jugador, Posicion posicion) {
		if (jugador.getGoles() == 0)
			cantSinGoles++;
		if (jugador.getCantTarjetas() > 0)
			cantAmarilla++;
		contPais[jugador.getNacionalidad().getId()]++;
		jugadoresPorPosicion.put(posicion, jugador);
	}

	public void eliminar(Posicion posicion) {
		jugadoresPorPosicion.remove(posicion);
	}

	public boolean contiene(Jugador objeto) {
		return jugadoresPorPosicion.containsValue(objeto);
	}

	public Conjunto clonar() {
		// Deep copy
		Conjunto ret = new Conjunto();
		for (Jugador objeto : jugadoresPorPosicion.values())
			ret.agregar(objeto, Posicion.ARQUERO);

		return ret;
	}

	public int tamano() {
		return jugadoresPorPosicion.size();
	}

	public boolean esLimitePorPais(int id) {
		return contPais[id] == LIMITE_PAIS;
	}

	@SuppressWarnings("unchecked")
	public HashMap<Posicion, Jugador> obtenerJugadores() {
		return (HashMap<Posicion, Jugador>) jugadoresPorPosicion.clone();
	}

	public Jugador obtenerJugador(Posicion p) {
		return jugadoresPorPosicion.get(p);
	}

	public boolean estaCompleto() {
		return jugadoresPorPosicion.size() == 11;
	}
}
