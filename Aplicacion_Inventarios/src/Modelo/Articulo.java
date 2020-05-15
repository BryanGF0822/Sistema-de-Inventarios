package Modelo;

import java.util.ArrayList;

public class Articulo {
	private int id;
	private String nombre;
	private String tipoMedida;
	private double cantidadMedida;
	private ArrayList<Categoria> categorias;
	private ArrayList<ItemArticulo> itemsComprados;
	
	
	
	public Articulo(String nombre, String tipoMedida, double cantidadMedida,int id) {
		super();
		this.nombre = nombre;
		this.tipoMedida = tipoMedida;
		this.cantidadMedida = cantidadMedida;
		this.id = id;
		categorias = new ArrayList<Categoria>();
		itemsComprados = new ArrayList<ItemArticulo>();
		
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

	public ArrayList<ItemArticulo> getItemsComprados() {
		return itemsComprados;
	}

	public void setItemsComprados(ArrayList<ItemArticulo> itemsComprados) {
		this.itemsComprados = itemsComprados;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return nombre +" " + cantidadMedida +" "+ tipoMedida;
	}
}
