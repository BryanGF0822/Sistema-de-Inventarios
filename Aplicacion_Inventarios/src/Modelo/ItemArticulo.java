package Modelo;

import java.util.Date;

public class ItemArticulo {
	private double precioUnidad;
	private int cantidad;
	private Date fechaEntrada;
	private boolean disponible;
	
	
	public ItemArticulo(double precioUnidad, int cantidad, Date fechaEntrada, boolean disponible) {
		super();
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
		this.fechaEntrada = fechaEntrada;
		this.disponible = disponible;
	}
	
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}
