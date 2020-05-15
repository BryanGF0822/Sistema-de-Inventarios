package Controladores;

import Modelo.SistemaInventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PEPS;
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
    void createPEPS(ActionEvent event) throws Exception {
    	Metodo_PEPS ventana = new Metodo_PEPS();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void createPP(ActionEvent event) throws Exception {
    	Metodo_PP ventana = new Metodo_PP();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }
   
    
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
}
