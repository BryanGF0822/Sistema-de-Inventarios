package Modelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

public class ItemArticulo {
	private double precioUnidad;
	private int cantidad;
	private LocalDate fechaEntrada;
	private boolean disponible;
	private String tipoOperacion;
	private long id;
	
	public ItemArticulo(double precioUnidad, int cantidad, LocalDate date, String tipoOperacion, boolean disponible,long id) {
		super();
		this.precioUnidad = precioUnidad;
		this.cantidad = cantidad;
		this.fechaEntrada = date;
		this.disponible = disponible;
		this.tipoOperacion = tipoOperacion;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String out = String.format("|%10.10s| -|%-10.10s| - |%10.10s| - |%10.2f| - |%12.2f|", fechaEntrada.toString(), tipoOperacion, String.valueOf(cantidad), precioUnidad, cantidad*precioUnidad);
		return out;
	}
	
	public static Comparator<ItemArticulo> dateComparator = new Comparator<ItemArticulo>() {

		@Override
		public int compare(ItemArticulo o1, ItemArticulo o2) {
			if(o1.getFechaEntrada().equals(o1.getFechaEntrada())) return (int) (o1.id-o2.id);
			return o1.getFechaEntrada().compareTo(o2.getFechaEntrada());
		}
    };
	
	
}
