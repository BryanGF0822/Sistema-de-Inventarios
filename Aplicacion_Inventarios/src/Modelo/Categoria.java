package Modelo;

public class Categoria {
	private String nombre;
	private int identificador;
	
	public Categoria(String nombre, int identificador) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	
	
}
