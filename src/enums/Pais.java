package enums;

public enum Pais {
	
	ARGENTINA(0, "Argentina"), 
	BRASIL(1, "Brasil"), 
	ALEMANIA(2, "Alemania"), 
	ESPANA(3, "Espana"), 
	FRANCIA(4, "Francia"), 
	COLOMBIA(5, "Colombia"), 
	HOLANDA(6, "Holanda"),
	PORTUGAL(7, "Portugal"), 
	URUGUAY(8, "URUGUAY"), 
	SUIZA(9, "Suiza"), 
	BELGICA(10, "Belgica"), 
	INGLATERRA(11, "Iglaterra"), 
	CHILE(12, "Chila"), 
	NIGERIA(13, "Nigeria");
	
	private int id;
	private String nombre;
	
	Pais(int id, String nombre){
		this.setId(id);
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
