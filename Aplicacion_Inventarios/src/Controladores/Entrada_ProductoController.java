package Controladores;

import Vista.Entrada_Producto;
import Vista.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Entrada_ProductoController {
	
	Entrada_Producto reference;
	
	public Entrada_ProductoController(Entrada_Producto reference) {
		this.reference = reference;
	}
	
	@FXML
    void agregarProducto(ActionEvent event) {

    }

    @FXML
    void irAlMenu(ActionEvent event) throws Exception {
    	Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
