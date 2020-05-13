package Modelo;

import java.util.ArrayList;

public class Articulo {
	private String nombre;
	private String tipoMedida;
	private double cantidadMedida;
	private ArrayList<Categoria> categorias;
	
	
	
	public Articulo(String nombre, String tipoMedida, double cantidadMedida) {
		super();
		this.nombre = nombre;
		this.tipoMedida = tipoMedida;
		this.cantidadMedida = cantidadMedida;
		categorias = new ArrayList<Categoria>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoMedida() {
		return tipoMedida;
	}
	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}
	public double getCantidadMedida() {
		return cantidadMedida;
	}
	public void setCantidadMedida(double cantidadMedida) {
		this.cantidadMedida = cantidadMedida;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
}
