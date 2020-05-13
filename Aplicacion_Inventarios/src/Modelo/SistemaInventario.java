package Modelo;

import java.util.ArrayList;

public class SistemaInventario {
	private ArrayList<Factura> facturasDeVenta;
	private ArrayList<Factura> facturasDeCompra;
	private ArrayList<HistorialItem> historiales;
	private ArrayList<Proveedor> proveedores;
	
	public SistemaInventario() {
		facturasDeVenta = new ArrayList<Factura>();
		facturasDeCompra = new ArrayList<Factura>();
		historiales = new ArrayList<HistorialItem>();
		proveedores = new ArrayList<Proveedor>();
	}
	
	public ArrayList<Factura> getFacturasDeVenta() {
		return facturasDeVenta;
	}
	public void setFacturasDeVenta(ArrayList<Factura> facturasDeVenta) {
		this.facturasDeVenta = facturasDeVenta;
	}
	public ArrayList<Factura> getFacturasDeCompra() {
		return facturasDeCompra;
	}
	public void setFacturasDeCompra(ArrayList<Factura> facturasDeCompra) {
		this.facturasDeCompra = facturasDeCompra;
	}
	
	public ArrayList<HistorialItem> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(ArrayList<HistorialItem> historiales) {
		this.historiales = historiales;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	
}
