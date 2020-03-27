package Controladores;

import Vista.Agregar_Proveedor;
import Vista.Entrada_Producto;
import Vista.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AgregarProveedorController {
	Agregar_Proveedor reference;
	
	public AgregarProveedorController(Agregar_Proveedor reference) {
		this.reference = reference;
	}
    @FXML
    void agregarProveedor(ActionEvent event) {

    }

    @FXML
    void irAlMenu(ActionEvent event) throws Exception {
    	Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }

}