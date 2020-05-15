package Controladores;

import Modelo.SistemaInventario;
import Vista.Agregar_Proveedor;
import Vista.Historial_Inventario;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Historial_InventarioController {
	
	private Historial_Inventario reference;
	private static SistemaInventario app;
	
	public Historial_InventarioController(Historial_Inventario reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
    	ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
}
