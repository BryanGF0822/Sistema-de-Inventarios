package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private int identificador;
	private LocalDate fechaRealizacion;
	private ArrayList<ItemArticulo> itemsFactura;
	private Proveedor proveedor;
	
	
	public Factura(int identificador, LocalDate date, Proveedor proveedor) {
		super();
		this.identificador = identificador;
		this.fechaRealizacion = date;
		this.proveedor = proveedor;
		itemsFactura = new ArrayList<ItemArticulo>();
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public LocalDate getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(LocalDate fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public ArrayList<ItemArticulo> getItemsFactura() {
		return itemsFactura;
	}
	public void setItemsFactura(ArrayList<ItemArticulo> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
}
