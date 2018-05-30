package modelo;

import java.util.ArrayList;
import java.util.List;

import enums.Pais;
import enums.Posicion;

public class Jugador {
	private List<Posicion> posiciones;
	private int goles;
	private String nombre;
	private int cantFaltas;
	private int cantTarjetas;
	private Pais nacionalidad;
	private double promedio;
	private int posicionPrincipal = 0;
	
	public Jugador(){
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
		return posiciones.get(0).getId() + "-" + nombre;
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

	public void setPosicionPrincipal(int pos) {
		posicionPrincipal = pos;
	}

	public Posicion getPosicionPrincipal() {
		return posiciones.get(posicionPrincipal);
	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
