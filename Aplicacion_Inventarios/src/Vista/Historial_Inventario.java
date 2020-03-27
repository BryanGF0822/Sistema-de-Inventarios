package Vista;

import java.net.URL;

import Controladores.Entrada_ProductoController;
import Controladores.Historial_InventarioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Historial_Inventario extends Application{
	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new Historial_InventarioController());
    	URL xmlUrl = getClass().getResource("Historial_Inventario.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }	
}
