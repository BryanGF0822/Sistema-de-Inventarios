package Controladores;

import Modelo.SistemaInventario;
import Vista.Menu;
import Vista.Metodo_PEPS;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Metodo_PEPSController {
	private Metodo_PEPS reference;
	private static SistemaInventario app;
	
	public Metodo_PEPSController(Metodo_PEPS reference, SistemaInventario app) {
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
