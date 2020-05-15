package Vista;

import java.net.URL;

import Controladores.AgregarArticuloController;
import Controladores.MenuController;
import Modelo.SistemaInventario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Agregar_Articulo extends Application{
	
	private Stage referenceStage;
	private static SistemaInventario app;
	
	public Stage getReferenceStage() {
		return referenceStage;
	}
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	referenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	AgregarArticuloController ref = new AgregarArticuloController(this,app);
    	loader.setController(ref);
    	URL xmlUrl = getClass().getResource("Agregar_Articulo.fxml");
    	loader.setLocation(xmlUrl);
    	Pane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	ref.setup();
    }

	public void setApp(SistemaInventario app) {
		this.app = app;
	}
}
