package enums;

public enum Posicion {
	ARQUERO				(1, "Arquero"),
	PRIMER_CENTRAL		(2,"Primer central"),
	SEGUNDO_CENTRAL		(6,"Segundo central"),
	LATERAL_IZQUIERDO	(3,"Lateral Izquierdo"),
	LATERAL_DERECHO		(4,"Lateral Derecho"),
	VOLANTE_IZQUIERDO	(7,"Volante Izquierdo"),
	VOLANTE_CENTRAL		(5,"Volante central"),
	VOLANTE_DERECHO		(8,"Volante Derecho"),
	PUNTERO_IZQUIERDO	(11,"Puntero izquierdo"),
	CENTRO_DELANTERO	(9,"Centro delantero"),
	PUNTERO_DERECHO		(10,"Puntero Derecho");

	private String posicion;
	private int id;

	Posicion(int id, String posicion){
		this.setPosicion(posicion);
		this.setId(id);
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return id + "-" + posicion;
	}

	public static Posicion valueOf(Posicion posicion) {
		for(Posicion p : values()){
			if(p.getId() == posicion.getId()) return p;
		}
		return null;
	}
}
