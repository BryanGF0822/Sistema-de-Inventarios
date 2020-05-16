package Modelo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

public class Articulo {
	private int id;
	private String nombre;
	private String tipoMedida;
	private double cantidadMedida;
	private ArrayList<Categoria> categorias;
	private ArrayList<ItemArticulo> items;
	private int cantidadDisponible;
	private int cantidadVendida;
	private LocalDate ultimaEntrada;
	private LocalDate ultimaSalida;
	public static final String COMPRA = "Compra"; 
	public static final String DEVOLUCION = "Devolucion"; 
	public static final String REGALO = "Regalo"; 
	public static final String VENDIDO = "Vendido"; 
	public static final String DAÑADO = "Producto Dañado"; 
	public static final String PROMO = "Promocion"; 
	
	
	
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
		ultimaEntrada = LocalDate.of(1800, Month.JANUARY, 1);
		ultimaSalida = LocalDate.of(1800, Month.JANUARY, 1);
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

	public LocalDate getUltimaEntrada() {
		return ultimaEntrada;
	}

	public void setUltimaEntrada(LocalDate ultimaEntrada) {
		this.ultimaEntrada = ultimaEntrada;
	}

	public LocalDate getUltimaSalida() {
		return ultimaSalida;
	}

	public void setUltimaSalida(LocalDate ultimaSalida) {
		this.ultimaSalida = ultimaSalida;
	}

	@Override
	public String toString() {
		return nombre +" " + cantidadMedida +" "+ tipoMedida;
	}
	
	public String toStringIn() {
		String out = String.format("|%10.20s| -|%-20.20s| - |%10.10s|",ultimaEntrada.toString() ,nombre, String.valueOf(cantidadDisponible));
		return out;
	}
	
	public String toStringOut() {
		String out = String.format("|%10.20s| -|%-20.20s| - |%10.10s|",ultimaSalida.toString(), nombre, String.valueOf(cantidadVendida));
		return out;
	}
	
	public void setAgregarU(int cant,LocalDate date) {
		cantidadDisponible += cant;
		if(cant<0) {
			ultimaSalida = date; 
			cantidadVendida += -cant;
		}else {
			ultimaEntrada = date;
		}
	}
	
	public static Comparator<Articulo> dateInComparator = new Comparator<Articulo>() {
		@Override
		public int compare(Articulo o1, Articulo o2) {
			return -(o1.getUltimaEntrada().compareTo(o2.getUltimaEntrada()));
		}
    };
    
    public static Comparator<Articulo> dateOutComparator = new Comparator<Articulo>() {
		@Override
		public int compare(Articulo o1, Articulo o2) {
			return -(o1.getUltimaSalida().compareTo(o2.getUltimaSalida()));
		}
    };
    
    public static Comparator<Articulo> alphaComparator = new Comparator<Articulo>() {
		@Override
		public int compare(Articulo o1, Articulo o2) {
			return o1.getNombre().compareTo(o2.getNombre());
		}
    };
    
    public static Comparator<Articulo> dispComparator = new Comparator<Articulo>() {
		@Override
		public int compare(Articulo o1, Articulo o2) {
			return -(o1.getCantidadDisponible() - o2.getCantidadDisponible());
		}
    };
    
    public static Comparator<Articulo> vendComparator = new Comparator<Articulo>() {
		@Override
		public int compare(Articulo o1, Articulo o2) {
			return -(o1.getCantidadVendida() - o2.getCantidadVendida());
		}
    };
    
}
