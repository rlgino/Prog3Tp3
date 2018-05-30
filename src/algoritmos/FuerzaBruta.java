package algoritmos;

import java.util.ArrayList;
import java.util.List;

import enums.Posicion;
import modelo.Jugador;

public class FuerzaBruta {
	
	public List<Jugador> equipoIdeal(List<Jugador> jugadores){
		
		List<Jugador> equipoIdeal = new ArrayList<Jugador>();
		
		for(Posicion posicionActual : Posicion.values())
		{
			Jugador jugadorMax = new Jugador();
			jugadorMax.setNombre("Default");
			boolean primerPasada = true;
			for(Jugador jugador : jugadores) if(jugador.juegaDe(posicionActual)){
				if(primerPasada || jugador.getCoeficiente() < jugadorMax.getCoeficiente()){
					jugadorMax = jugador;
				}
			}
			equipoIdeal.add(jugadorMax);
		}
		return equipoIdeal;
	}
	
}
