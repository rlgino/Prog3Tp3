package controlador;

import java.util.List;

import modelo.Jugador;

public class Controlador {
	private List<Jugador> jugadores;
	final static String PATH = "./src/datos.txt";
	
	public Controlador(){
		Jugadores j = new Jugadores();
		jugadores = j.levantarDatos();
	}

	public String[] getNombreDeJugadores(){
		String[] ret = new String[jugadores.size()];
		int x = 0;
		for(Jugador j : jugadores){
			ret[x] = j.getPosicion().getId() + "-" + j.getNombre();
			x++;
		}

		return ret;
	}

	public void agregarJugador(Jugador j){
		jugadores.add(j);
		guardarJugadores();
	}

	private void guardarJugadores() {
		Jugadores j = new Jugadores();
		j.persistirDatos(jugadores);		
	}

}
