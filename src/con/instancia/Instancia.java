package con.instancia;

import java.util.ArrayList;

import modelo.Jugador;

public class Instancia {

	// ---------------Variables------------
	private ArrayList<Jugador> jugadores;

	// --------------Constructores---------
	public Instancia() {
		jugadores = new ArrayList<Jugador>();
	}

	public Instancia(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void agregar(Jugador jugador) {
		jugadores.add(jugador);
	}

	public int tamano() {
		return jugadores.size();
	}

	// Acceso O(1) a un objeto
	public Jugador getJuador(int i) {
		if (i < 0 || i >= tamano())
			throw new IllegalArgumentException("Se consulto un objeto inexistente! i = " + i);

		return jugadores.get(i);
	}

	// Acceso O(n) a la lista (copiada) de objetos
	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> getJugadores() {
		return (ArrayList<Jugador>) jugadores.clone();
	}
}
