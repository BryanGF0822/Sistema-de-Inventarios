package Controladores;

import java.util.ArrayList;

import Modelo.Articulo;
import Modelo.ItemArticulo;
import Modelo.SistemaInventario;
import Vista.Agregar_Proveedor;
import Vista.Historial_Inventario;
import Vista.Menu;
import Vista.Metodo_PP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class Historial_InventarioController {
	
	private Historial_Inventario reference;
	private static SistemaInventario app;
	
	public Historial_InventarioController(Historial_Inventario reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	
	@FXML
	private ComboBox<String> orderChoice;

    @FXML
    private ListView<String> inList;

    @FXML
    private ListView<String> outList;

    @FXML
    private ComboBox<String> productChoice;

	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
    	ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
	
	@FXML
    void order(ActionEvent event) {
		
    }

    @FXML
    void search(ActionEvent event) {
    	Integer indx = productChoice.getSelectionModel().getSelectedIndex();
    	
    	if(indx != -1) {
    		Articulo ref = app.getArticulos().get(indx);
    		
    	}else {
    		createAlert("Selecciona un articulo!",AlertType.WARNING);
    	}
    }
    
	public void setup() {
		productChoice.getItems().clear();
		for (Articulo it : app.getArticulos()) {
			productChoice.getItems().add(it.getNombre()+" "+it.getCantidadMedida()+" "+it.getTipoMedida());
		}
		orderChoice.getItems().clear();
		orderChoice.getItems().add("Fecha");
		orderChoice.getItems().add("Orden alfabetico");
		orderChoice.getItems().add("Cantidad de unidades adquiridas");
		orderChoice.getItems().add("Cantidad de unidades vendidas");
	}
	
	void createAlert(String message,AlertType mtype) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(mtype);
	   	 a.show();
	}
}
