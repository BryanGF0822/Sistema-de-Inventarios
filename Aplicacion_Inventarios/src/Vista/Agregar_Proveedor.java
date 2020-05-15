package Vista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

import Controladores.AgregarProveedorController;
import Modelo.SistemaInventario;

public class Agregar_Proveedor extends Application{
	
	private static SistemaInventario app;
	private Stage ReferenceStage;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	this.ReferenceStage = primaryStage; 
    	FXMLLoader loader = new FXMLLoader();
    	AgregarProveedorController ref = new AgregarProveedorController(this,app);
    	loader.setController(ref);
    	URL xmlUrl = getClass().getResource("Agregar_Proveedor.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	ref.setup();
    	primaryStage.show();
    }

	public void setApp(SistemaInventario app) {
		this.app = app;
	}

	
}
