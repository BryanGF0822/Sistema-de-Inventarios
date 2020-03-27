package Controladores;

import Vista.Menu;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Salida_ProductoController {
	private Salida_Producto reference;
	
	public Salida_ProductoController(Salida_Producto reference) {
		this.reference = reference;
	}
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }

    @FXML
    void registrarSalidaInventario(ActionEvent event) {

    }
}
