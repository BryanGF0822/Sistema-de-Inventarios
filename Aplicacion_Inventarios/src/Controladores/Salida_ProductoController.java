package Controladores;

import java.time.LocalDate;
import java.util.HashMap;

import Modelo.Articulo;
import Modelo.Categoria;
import Modelo.ItemArticulo;
import Modelo.SistemaInventario;
import Vista.Menu;
import Vista.Salida_Producto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Salida_ProductoController {
	private Salida_Producto reference;
	private static SistemaInventario app;
	private int idArticulo[];
	
	public Salida_ProductoController(Salida_Producto reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
		idArticulo = new int[app.getArticulos().size()+2];
	}
	
	@FXML
    private DatePicker salidaDate;

    @FXML
    private TextField cantidadText;

    @FXML
    private ListView<String> productsList;

    @FXML
    private ChoiceBox<String> tipoChoice;
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }

    @FXML
    void registrarSalidaInventario(ActionEvent event) {
    	String tipo = (String) tipoChoice.getValue();
    	Integer val = productsList.getSelectionModel().getSelectedIndex();
    	LocalDate date = salidaDate.getValue();
    	
		System.out.println(val);
		if(cantidadText.getText().equals("") || tipo == null || val == -1 || date == null){
			createAlert("Alguno de los campos no ha sido escrito ó selecionado apropiadamente",AlertType.WARNING);
		}else {
			int cant = -1;
			try {
				 cant = Integer.parseInt(cantidadText.getText());
			 }catch (Exception e) {
				 createAlert("El campo de cantidad no tiene un valor numerico valido",AlertType.WARNING);
			}
			int itemDisp = app.getArticulos().get(idArticulo[val]).getCantidadDisponible();
			if(cant<=itemDisp) {		
				createAlert("Se registro la salida de productos exitosamente!",AlertType.INFORMATION);
				app.getArticulos().get(idArticulo[val]).setAgregarU(-cant,date);
				app.getArticulos().get(idArticulo[val]).getItems().add(new ItemArticulo(0, cant, date, tipo, false,app.getId_item()));
				setup();
			}else {
				createAlert("El campo de cantidad tiene un valor que supera las unidades disponibles",AlertType.WARNING);
			}
			
		}
    }
    
    public void setup() {
		tipoChoice.getItems().add(Articulo.VENDIDO);
		tipoChoice.getItems().add(Articulo.DAÑADO);
		tipoChoice.getItems().add(Articulo.PROMO);
		productsList.getItems().clear();
		int pos = 0;
		for (Articulo it : app.getArticulos()) {
			if(it.getItems().size() > 0 && it.getCantidadDisponible() > 0){
				String articuloN = it.toString();
				int numArt = it.getCantidadDisponible();
				idArticulo[pos] = it.getId()-1;
				productsList.getItems().add(articuloN+" , unidades disponibles = "+numArt);
				pos++;
			}
		}
	}
    
    void createAlert(String message,AlertType mtype) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(mtype);
	   	 a.show();
	}
}
