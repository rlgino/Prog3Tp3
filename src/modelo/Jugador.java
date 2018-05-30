package modelo;

import enums.Posicion;

public class Jugador {
	private Posicion posicion;
	private int goles;
	private String nombre;
	private int cantFaltas;
	private int cantTarjetas;
	private double promedio;

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
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
		return posicion.getId() + "-" + nombre;
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

}
