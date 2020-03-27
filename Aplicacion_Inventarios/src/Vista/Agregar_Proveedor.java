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

public class Agregar_Proveedor extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new AgregarProveedorController());
    	URL xmlUrl = getClass().getResource("Agregar_Proveedor.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }
}
