package Controladores;

import Modelo.SistemaInventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PP;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Metodo_PPController {
	
	private Metodo_PP reference;
	private static SistemaInventario app;
	
	public Metodo_PPController(Metodo_PP reference, SistemaInventario app) {
		this.reference = reference;
		this.app=app;
	}
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Kardex ventana = new Kardex();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
}
