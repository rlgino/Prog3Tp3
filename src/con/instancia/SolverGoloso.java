package con.instancia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import enums.Posicion;
import modelo.Jugador;

public class SolverGoloso {

	private Instancia instancia;

	public SolverGoloso(Instancia instancia) {
		this.instancia = instancia;
	}

	public Conjunto resolver() {
		Conjunto ret = new Conjunto();
		List<Jugador> ordenados = ordenarJugadores();

		for (Posicion posicionActual : Posicion.values()) {
			List<Jugador> jugPorPosicion = new ArrayList<Jugador>();
			ordenados.stream().filter(j -> j.juegaDe(posicionActual)).forEach(j -> jugPorPosicion.add(j));
			for(Jugador j : jugPorPosicion){
				if(verificarEquipo(j, ret)){
					agregarJugador(j, ret);
					break;
				}
			}

		}
		return ret;
	}

	private boolean verificarEquipo(Jugador j, Conjunto ret) {
		if(ret.contiene(j)) return false;
		if(ret.esLimiteAmarilla()){
			System.out.println("Limite de amarillas");
//			return false;
		}
		if(ret.esCantSinGoles()){
			System.out.println("Limite de sin goles");
//			return false;
		}
		if(ret.esLimitePorPais(j.getNacionalidad().getId())) {
			System.out.println("Limite por pais");
//			return false;
		}
		return true;
	}

	private void agregarJugador(Jugador j, Conjunto ret) {
		ret.agregar(j);	
	}

	private List<Jugador> ordenarJugadores() {
		ArrayList<Jugador> ret = instancia.getJugadores();
		Collections.sort(ret);
		return ret;
	}
}
