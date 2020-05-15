package Modelo;

import java.util.ArrayList;

public class Proveedor {
	private String nombre;
	private String direccion;
	private String cedula;
	private String telefono;
	private ArrayList<Categoria> categoriasDistribuidor;
	
	
	public Proveedor(String nombre, String direccion, String telefono,String cedula) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cedula = cedula;
		categoriasDistribuidor = new ArrayList<Categoria>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public ArrayList<Categoria> getCategoriasDistribuidor() {
		return categoriasDistribuidor;
	}
	public void setCategoriasDistribuidor(ArrayList<Categoria> categoriasDistribuidor) {
		this.categoriasDistribuidor = categoriasDistribuidor;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
