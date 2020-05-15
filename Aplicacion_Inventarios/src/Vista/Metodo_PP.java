package Vista;

import java.net.URL;

import Controladores.LoginController;
import Controladores.Metodo_PPController;
import Modelo.SistemaInventario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Metodo_PP extends Application{

	private Stage ReferenceStage;
	private static SistemaInventario app;
	
	public Stage getReferenceStage() {
		return ReferenceStage;
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
    	ReferenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new Metodo_PPController(this,app));
    	URL xmlUrl = getClass().getResource("Metodo_PP.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }

	public void setApp(SistemaInventario app) {
		this.app=app;
	}
}
