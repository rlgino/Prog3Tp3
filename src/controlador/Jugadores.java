package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Jugador;

public class Jugadores {
	private List<Jugador> jugadores;

	public List<Jugador> levantarDatos() {
		Gson json = new Gson();
		Jugadores ret = new Jugadores();

		try {
			BufferedReader br = new BufferedReader(new FileReader(Controlador.PATH));
			ret = (Jugadores) json.fromJson(br, this.getClass());
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro archivo");
			return new ArrayList<Jugador>();
		}
		return ret.jugadores;
	}

	public void persistirDatos(List<Jugador> j) {
		this.jugadores = j;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		try {
			FileWriter file = new FileWriter(Controlador.PATH);
			file.write(json);
			file.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public int size() {
		return jugadores.size();
	}

}
