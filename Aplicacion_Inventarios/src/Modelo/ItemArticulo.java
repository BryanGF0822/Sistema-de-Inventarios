package Modelo;

import java.time.LocalDate;
import java.util.Date;

public class ItemArticulo {
	private double precioUnidad;
	private int cantidad;
	private LocalDate fechaEntrada;
	private boolean disponible;
	private String tipoOperacion;
	private long id;
	
	public ItemArticulo(double precioUnidad, int cantidad, LocalDate date, String tipoOperacion, boolean disponible) {
		super();
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
		this.fechaEntrada = date;
		this.disponible = disponible;
		this.tipoOperacion = tipoOperacion;
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
	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	
}
