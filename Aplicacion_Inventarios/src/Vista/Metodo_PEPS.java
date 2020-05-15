package Vista;

import java.net.URL;

import Controladores.LoginController;
import Controladores.Metodo_PEPSController;
import Modelo.SistemaInventario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Metodo_PEPS extends Application{

	private Stage ReferenceStage;
	private static SistemaInventario app;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
    	ReferenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	Metodo_PEPSController ref = new Metodo_PEPSController(this,app);
    	loader.setController(ref);
    	URL xmlUrl = getClass().getResource("Metodo_PEPS.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	ref.setup();
    	primaryStage.show();
    }

	public void setApp(SistemaInventario app) {
		this.app=app;
	}
}

