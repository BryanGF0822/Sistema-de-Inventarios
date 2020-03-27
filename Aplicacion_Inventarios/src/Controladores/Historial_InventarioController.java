package Controladores;

import Vista.Agregar_Proveedor;
import Vista.Historial_Inventario;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Historial_InventarioController {
	
	private Historial_Inventario reference;
	
	public Historial_InventarioController(Historial_Inventario reference) {
		this.reference = reference;
	}
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
