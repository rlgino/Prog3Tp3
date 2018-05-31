package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Posicion;
import modelo.Jugador;

public class FuerzaBruta {
	
	public static List<Jugador> resolver(List<Jugador> jugadores) {
		
		List<Jugador> equipoIdeal = new ArrayList<Jugador>();
				
		Collections.sort(jugadores);
		
		for(Posicion posicionActual : Posicion.values())
		{
			List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
			jugadores.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
			System.out.println(jugPorPosicion.get(0).getNombre());
		}
		return equipoIdeal;		
	}
	
}
