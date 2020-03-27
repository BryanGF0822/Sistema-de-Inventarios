package Vista;

import java.net.URL;

import Controladores.LoginController;
import Controladores.Metodo_PPController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Metodo_PP extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new Metodo_PPController());
    	URL xmlUrl = getClass().getResource("Metodo_PP.fxml");
    	loader.setLocation(xmlUrl);
    	AnchorPane root = loader.load();

    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }
}
