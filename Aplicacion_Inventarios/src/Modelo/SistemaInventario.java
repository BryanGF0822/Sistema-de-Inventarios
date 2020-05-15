package Modelo;

import java.util.ArrayList;
import java.util.Collections;

public class SistemaInventario {
	private ArrayList<Factura> facturasDeVenta;
	private ArrayList<Factura> facturasDeCompra;
	private ArrayList<HistorialItem> historiales;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Articulo> articulos;
	private ArrayList<Categoria> categorias;
	private int id_facturas_venta;
	private int id_facturas_compra;
	private long id_item;
	private int id_Articulo;
	
	public SistemaInventario() {
		facturasDeVenta = new ArrayList<Factura>();
		facturasDeCompra = new ArrayList<Factura>();
		historiales = new ArrayList<HistorialItem>();
		proveedores = new ArrayList<Proveedor>();
		articulos = new ArrayList<Articulo>();
		categorias = new ArrayList<Categoria>();
		id_facturas_compra = 0;
		id_facturas_venta = 0;
		id_item = 0;
		id_Articulo = 0;
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

	public int getId_facturas_venta() {
		id_facturas_venta++;
		return id_facturas_venta;
	}

	public void setId_facturas_venta(int id_facturas_venta) {
		this.id_facturas_venta = id_facturas_venta;
	}

	public int getId_facturas_compra() {
		id_facturas_compra++;
		return id_facturas_compra;
	}

	public void setId_facturas_compra(int id_facturas_compra) {
		this.id_facturas_compra = id_facturas_compra;
	}

	public long getId_item() {
		id_item++;
		return id_item;
	}

	public void setId_item(long id_item) {
		this.id_item = id_item;
	}
	

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Proveedor searchProveedor(String proveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Categoria searchCategoria(Integer categoria) {
		return categorias.get(categoria);
	}

	public Proveedor searchProveedor(Integer proveedor) {
		return proveedores.get(proveedor);
	}

	public int getId_Articulo() {
		id_Articulo++;
		return id_Articulo;
	}

	public void setId_Articulo(int id_Articulo) {
		this.id_Articulo = id_Articulo;
	}
	
	public int getId_Item() {
		id_item++;
		return id_Articulo;
	}

	public void setId_Item(long id_item) {
		this.id_Articulo = id_Articulo;
	}

	public ArrayList<ItemArticulo> getItemsKardex(Integer indx) {
		ArrayList<ItemArticulo> ref = new ArrayList<ItemArticulo>();
		for(ItemArticulo it : articulos.get(indx).getItems()) {
			ref.add(it);
		}
		Collections.sort(ref, ItemArticulo.dateComparator);
		return ref;
	}
	
	
	
	
	
	
}
