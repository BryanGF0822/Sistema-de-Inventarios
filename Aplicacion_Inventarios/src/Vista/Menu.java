package Vista;

import java.net.URL;

import Controladores.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class  Menu extends Application{
	
	private Stage referenceStage;
	
	public Stage getReferenceStage() {
		return referenceStage;
	}
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	referenceStage = primaryStage;
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new MenuController(this));
    	URL xmlUrl = getClass().getResource("Menu.fxml");
    	loader.setLocation(xmlUrl);
    	Pane root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	primaryStage.show();
    }

	
}

