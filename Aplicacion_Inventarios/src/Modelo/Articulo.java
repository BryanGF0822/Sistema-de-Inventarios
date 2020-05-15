package Modelo;

import java.util.ArrayList;

public class Articulo {
	private int id;
	private String nombre;
	private String tipoMedida;
	private double cantidadMedida;
	private ArrayList<Categoria> categorias;
	private ArrayList<ItemArticulo> items;
	private int cantidadDisponible;
	private int cantidadVendida;
	
	
	
	public Articulo(String nombre, String tipoMedida, double cantidadMedida,int id) {
		super();
		this.nombre = nombre;
		this.tipoMedida = tipoMedida;
		this.cantidadMedida = cantidadMedida;
		this.id = id;
		categorias = new ArrayList<Categoria>();
		items = new ArrayList<ItemArticulo>();
		cantidadDisponible = 0;
		cantidadVendida = 0;
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

	public ArrayList<ItemArticulo> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemArticulo> itemsComprados) {
		this.items = itemsComprados;
	}
	
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	@Override
	public String toString() {
		return nombre +" " + cantidadMedida +" "+ tipoMedida;
	}
	
	public String toString2() {
		return null;
	}
	
	public void setAgregarU(int cant) {
		cantidadDisponible += cant; 
	}
}
