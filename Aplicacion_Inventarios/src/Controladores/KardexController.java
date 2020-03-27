package Controladores;

import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class KardexController {
	
	private Kardex reference;
	
	public KardexController(Kardex reference) {
		this.reference = reference;
	}
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
