package Vista;

import java.net.URL;

import Controladores.Historial_InventarioController;
import Controladores.KardexController;
import Modelo.SistemaInventario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Kardex extends Application{
	
	private Stage ReferenceStage;
	
	private static SistemaInventario app;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
    	ReferenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new KardexController(this,app));
    	URL xmlUrl = getClass().getResource("Kardex.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }

	public void setApp(SistemaInventario app) {
		this.app=app;
	}	
}

