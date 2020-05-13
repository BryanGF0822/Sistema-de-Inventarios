package Modelo;

import java.util.ArrayList;

public class HistorialItem {
	private int identificador;
	private double valoracionPEPS;
	private double valoricionPP;
	private double valorActual;
	private int cantTotalUnidades;
	private ArrayList<ItemArticulo> registros;
	
	public HistorialItem(int identificador, double valoracionPEPS, double valoricionPP, double valorActual,
			int cantTotalUnidades) {
		super();
		this.identificador = identificador;
		this.valoracionPEPS = valoracionPEPS;
		this.valoricionPP = valoricionPP;
		this.valorActual = valorActual;
		this.cantTotalUnidades = cantTotalUnidades;
		registros = new ArrayList<ItemArticulo>();
	}
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public double getValoracionPEPS() {
		return valoracionPEPS;
	}
	
	public void setValoracionPEPS(double valoracionPEPS) {
		this.valoracionPEPS = valoracionPEPS;
	}
	
	public double getValoricionPP() {
		return valoricionPP;
	}
	
	public void setValoricionPP(double valoricionPP) {
		this.valoricionPP = valoricionPP;
	}
	
	public double getValorActual() {
		return valorActual;
	}
	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
	}
	public int getCantTotalUnidades() {
		return cantTotalUnidades;
	}
	public void setCantTotalUnidades(int cantTotalUnidades) {
		this.cantTotalUnidades = cantTotalUnidades;
	}
	public ArrayList<ItemArticulo> getRegistros() {
		return registros;
	}
	public void setRegistros(ArrayList<ItemArticulo> registros) {
		this.registros = registros;
	}
	
	
	
}
