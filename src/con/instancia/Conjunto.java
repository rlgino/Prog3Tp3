package con.instancia;

import java.util.ArrayList;
import java.util.List;

import enums.Pais;
import modelo.Jugador;

public class Conjunto {
	// --------------Constantes-----------
	private final int LIMITE_SIN_GOLES = 5;
	private final int LIMITE_AMARILLAS = 5;
	private final int LIMITE_PAIS = 4;

	private List<Jugador> jugadores;
	private int[] contPais;
	private int cantAmarilla = 0;
	private int cantSinGoles = 0;

	public Conjunto() {
		contPais = new int[Pais.values().length];
		jugadores = new ArrayList<Jugador>();
	}

	// --------------Verificadores----------
	public boolean esLimiteAmarilla() {
		return cantAmarilla == LIMITE_AMARILLAS;
	}

	public boolean esCantSinGoles() {
		return cantSinGoles == LIMITE_SIN_GOLES;
	}

	public int getCantidadEnPais(int i) {
		return contPais[i];
	}
	
	//---------------Juadores

	public void agregar(Jugador actual) {
		if(actual.getGoles() == 0) cantSinGoles++;
		if(actual.getCantTarjetas() > 0) cantAmarilla++;
		contPais[actual.getNacionalidad().getId()]++;
		jugadores.add(actual);
		System.out.println(actual.getNombre());
	}

	public void eliminar(Jugador actual) {
		jugadores.remove(actual);
	}

	public boolean contiene(Jugador objeto) {
		return jugadores.contains(objeto);
	}

	public Conjunto clonar() {
		// Deep copy
		Conjunto ret = new Conjunto();
		for (Jugador objeto : jugadores)
			ret.agregar(objeto);

		return ret;
	}

	public int tamano() {
		return jugadores.size();
	}

	public boolean esLimitePorPais(int id) {
		return contPais[id] == LIMITE_PAIS;
	}

	public String[] getNombreDeJugadores() {
		String[] nombre = new String[jugadores.size()];
		for(int x = 0; x < jugadores.size() ; x++)
			nombre[x] = jugadores.get(x).getNombre();
		return nombre;
	}
}
