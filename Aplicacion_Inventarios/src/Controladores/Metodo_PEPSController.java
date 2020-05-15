package Controladores;

import java.util.ArrayList;

import Modelo.Articulo;
import Modelo.ItemArticulo;
import Modelo.SistemaInventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PEPS;
import Vista.Metodo_PP;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.Alert.AlertType;

public class Metodo_PEPSController {
	private Metodo_PEPS reference;
	private static SistemaInventario app;
	@FXML
    private ListView<String> infoTable;

    @FXML
    private ChoiceBox<String> artChoice;

    @FXML
    private Label cstLabel;

    @FXML
    private Button calcButton;
	
	public Metodo_PEPSController(Metodo_PEPS reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	

    @FXML
    void calcKardex(ActionEvent event) {
    	Integer indx = artChoice.getSelectionModel().getSelectedIndex();
    	infoTable.getItems().clear();
    	if(indx != -1) {
    		ArrayList<ItemArticulo> items = app.getItemsKardex(indx);
    		for(ItemArticulo it : items) {
    			infoTable.getItems().add(it.toString());
    		}
    	}else {
    		createAlert("Selecciona un articulo!",AlertType.WARNING);
    	}
    }
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Kardex ventana = new Kardex();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
	
	public void setup() {
		for (Articulo it : app.getArticulos()) {
			artChoice.getItems().add(it.getNombre()+" "+it.getCantidadMedida()+" "+it.getTipoMedida());
		}
	}
	
	void createAlert(String message,AlertType mtype) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(mtype);
	   	 a.show();
	}
}
