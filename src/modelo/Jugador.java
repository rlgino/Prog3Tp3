package modelo;

import java.util.ArrayList;
import java.util.List;

import enums.Pais;
import enums.Posicion;

public class Jugador implements Comparable<Jugador> {
	private List<Posicion> posiciones;
	private int goles;
	private String nombre;
	private int cantFaltas;
	private int cantTarjetas;
	private Pais nacionalidad;
	private double promedio;

	public Jugador() {
		posiciones = new ArrayList<Posicion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantFaltas() {
		return cantFaltas;
	}

	public void setCantFaltas(int cantFaltas) {
		this.cantFaltas = cantFaltas;
	}

	public int getCantTarjetas() {
		return cantTarjetas;
	}

	public void setCantTarjetas(int cantTarjetas) {
		this.cantTarjetas = cantTarjetas;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public String toString() {
		return nombre + " - " + getCoeficiente();
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public double getCoeficiente() {
		/*
		 * coeficiente = 2 × goles − faltas/10 − tarjetas + puntaje promedio.
		 */
		double ret = goles * 2;
		ret -= cantFaltas / 10;
		ret -= cantTarjetas;
		ret += promedio;
		return ret;
	}

	public void agregarPosicion(Posicion posicion) {
		posiciones.add(posicion);
	}

	public void borrarPosicion(Posicion posicion) {
		posiciones.remove(posicion);
	}

	public boolean juegaDe(Posicion posicionActual) {
		return posiciones.contains(posicionActual);
	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public int compareTo(Jugador otro) {
		if (this.getCoeficiente() < otro.getCoeficiente())
			return 1;
		if (this.getCoeficiente() > otro.getCoeficiente())
			return -1;

		return 0;
	}

	public List<Posicion> getPosiciones() {
		return 	posiciones;	
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Jugador)) return false;
		Jugador otro = (Jugador) o;
		if(otro.getNombre().equals(getNombre())) return true;
		return false;
	}

}
