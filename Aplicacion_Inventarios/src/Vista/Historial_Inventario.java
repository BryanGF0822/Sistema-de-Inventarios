package Vista;

import java.net.URL;

import Controladores.Entrada_ProductoController;
import Controladores.Historial_InventarioController;
import Modelo.SistemaInventario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Historial_Inventario extends Application{
	
	private Stage ReferenceStage;
	private static SistemaInventario app;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
    	ReferenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	Historial_InventarioController ref = new Historial_InventarioController(this,app);
    	loader.setController(ref);
    	URL xmlUrl = getClass().getResource("Historial_Inventario.fxml");
    	loader.setLocation(xmlUrl);
    	Pane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	ref.setup();
    	primaryStage.show();
    }

	public void setApp(SistemaInventario app) {
		this.app = app;
	}	
}
