package Modelo;

import java.util.ArrayList;

public class Proveedor {
	private String nombre;
	private String direccion;
	private String telefono;
	private String tipoProducto;
	private ArrayList<Categoria> categoriasDistribuidor;
	
	
	public Proveedor(String nombre, String direccion, String telefono, String tipoProducto) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoProducto = tipoProducto;
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
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public ArrayList<Categoria> getCategoriasDistribuidor() {
		return categoriasDistribuidor;
	}
	public void setCategoriasDistribuidor(ArrayList<Categoria> categoriasDistribuidor) {
		this.categoriasDistribuidor = categoriasDistribuidor;
	}
	
	
}
