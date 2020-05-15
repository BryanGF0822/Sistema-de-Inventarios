package Controladores;

import Modelo.SistemaInventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class KardexController {
	
	private Kardex reference;
	private static SistemaInventario app;
	
	
	public KardexController(Kardex reference, SistemaInventario app) {
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
