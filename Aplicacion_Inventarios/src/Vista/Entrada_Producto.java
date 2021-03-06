package Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

import Controladores.AgregarProveedorController;
import Controladores.Entrada_ProductoController;
import Modelo.SistemaInventario;

public class  Entrada_Producto  extends Application{

	private Stage ReferenceStage;
	private SistemaInventario app;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
    	ReferenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	Entrada_ProductoController ref = new Entrada_ProductoController(this,app);
    	loader.setController(ref);
    	URL xmlUrl = getClass().getResource("Entrada_Producto.fxml");
    	loader.setLocation(xmlUrl);
    	Pane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    	ref.setUp();
    }

	public void setApp(SistemaInventario app) {
		this.app = app;
		System.out.println(app);
	}
}

