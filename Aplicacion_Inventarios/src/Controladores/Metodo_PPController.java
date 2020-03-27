package Controladores;

import Vista.Menu;
import Vista.Metodo_PP;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Metodo_PPController {
	
	private Metodo_PP reference;
	
	public Metodo_PPController(Metodo_PP reference) {
		this.reference = reference;
	}
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
