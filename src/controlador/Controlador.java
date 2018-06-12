package controlador;

import java.util.ArrayList;
import java.util.List;

import algoritmos.Conjunto;
import algoritmos.Instancia;
import algoritmos.SolverGoloso;
import generadores.GeneradorAleatorio;
import modelo.Jugador;

public class Controlador {
	//----------------Variables------------------
	private List<Jugador> jugadores;
	//----------------Constantes-----------------
	static String PATH = "./src/datos.txt";
	
	//----------------Contructores---------------
	public Controlador(){
		Jugadores archivo = new Jugadores();
		this.jugadores = archivo.levantarDatos();
	}

	//----------------Getters--------------------
	public Jugador[] obtenerJugadores(){
		Jugador[] ret = new Jugador[jugadores.size()];
		int x = 0;
		for(Jugador j : jugadores){
			ret[x] = j;
			x++;
		}

		return ret;
	}

	private void guardarJugadores() {
		Jugadores j = new Jugadores();
		j.persistirDatos(jugadores);		
	}
	
	//----------------Setters------------------
	public void agregarJugador(Jugador j){
		if(jugadores.contains(j))jugadores.remove(j);
		jugadores.add(j);
		guardarJugadores();
	}

	public Conjunto seleccionarEquipo() {
		SolverGoloso solver = new SolverGoloso(new Instancia((ArrayList<Jugador>) jugadores), new GeneradorAleatorio());
		Conjunto sol = solver.resolver();
		return sol;
	}

	public Jugador obtenerJugador(String nombre) {
		for(Jugador j : jugadores)
			if(j.getNombre().equals(nombre))
				return j;
		return null;
	}

}
