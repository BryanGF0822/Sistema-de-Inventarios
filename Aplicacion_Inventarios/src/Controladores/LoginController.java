package Controladores;

import Vista.Login;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {
	
private Login reference;
	
	public LoginController(Login reference) {
		this.reference = reference;
	}
	
	@FXML
    void verifyUser(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.start(reference.getReferenceStage());
    }
}
