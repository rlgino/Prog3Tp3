package controlador;

import java.util.ArrayList;
import java.util.List;

import con.instancia.Conjunto;
import con.instancia.Instancia;
import con.instancia.SolverGoloso;
import modelo.Jugador;

public class Controlador {
	private List<Jugador> jugadores;
	final static String PATH = "./src/datos.txt";
	
	public Controlador(){
		Jugadores j = new Jugadores();
		jugadores = j.levantarDatos();
	}

	public String[] getNombresDeJugadores(){
		String[] ret = new String[jugadores.size()];
		int x = 0;
		for(Jugador j : jugadores){
			ret[x] = j.getPosicionPrincipal().getId() + "-" + j.getNombre();
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

	public String[] seleccionarEquipo() {
		SolverGoloso solver = new SolverGoloso(new Instancia((ArrayList<Jugador>) jugadores));
		Conjunto sol = solver.resolver();
		return sol.getNombreDeJugadores();
	}

}
