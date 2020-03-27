package Controladores;

import Vista.Menu;
import Vista.Metodo_PEPS;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Metodo_PEPSController {
	private Metodo_PEPS reference;
	
	public Metodo_PEPSController(Metodo_PEPS reference) {
		this.reference = reference;
	}
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
