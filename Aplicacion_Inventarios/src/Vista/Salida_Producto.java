package Vista;

import java.net.URL;

import Controladores.LoginController;
import Controladores.Salida_ProductoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Salida_Producto extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new  Salida_ProductoController());
    	URL xmlUrl = getClass().getResource("Salida_Producto.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }
}

