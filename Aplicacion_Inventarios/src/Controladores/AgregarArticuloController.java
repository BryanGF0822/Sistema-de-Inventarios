package Controladores;

import java.time.LocalDate;

import Modelo.Articulo;
import Modelo.Categoria;
import Modelo.ItemArticulo;
import Modelo.Proveedor;
import Modelo.SistemaInventario;
import Vista.Agregar_Articulo;
import Vista.Entrada_Producto;
import Vista.Menu;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AgregarArticuloController {
	private static SistemaInventario app;
	private Agregar_Articulo reference;
	
	@FXML
    private TextField nameText;

    @FXML
    private TextField cantidadText;

    @FXML
    private ListView<String> categoriasList;

    @FXML
    private ChoiceBox<String> typeChoice;

    @FXML
    void agregarArticulo(ActionEvent event){
    	String tipo = (String) typeChoice.getValue();
    	ObservableList<Integer> val = categoriasList.getSelectionModel().getSelectedIndices();
    	
    	
		
		if(cantidadText.getText().equals("") || nameText.getText().equals("") || tipo == null || val.size() == 0){
			createAlert("Alguno de los campos no ha sido escrito ó selecionado apropiadamente");
		}else {
			int cant = -1;
			try {
				 cant = Integer.parseInt(cantidadText.getText());
			 }catch (Exception e) {
				 createAlert("El campo de cantida no tiene un valor numerico valido");
			}
			if(cant>0) {
				Articulo ref = new Articulo(nameText.getText(), tipo, cant,app.getId_Articulo());
				for (Integer it : val) {
					ref.getCategorias().add(app.searchCategoria(it));
				}
				app.getArticulos().add(ref);
				createAlert("Referencia registrada exitosamente!");
			}
			
		}
    }

	@FXML
    void regresar(ActionEvent event) throws Exception {
    	Entrada_Producto ventana = new Entrada_Producto();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }
	
	public  AgregarArticuloController(Agregar_Articulo reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	
	public void setup() {
		categoriasList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		typeChoice.getItems().add("mL");
		typeChoice.getItems().add("L");
		typeChoice.getItems().add("cm3");
		typeChoice.getItems().add("cl");
		typeChoice.getItems().add("gr");
		typeChoice.getItems().add(" X unidades");
		
		for (Categoria it : app.getCategorias()) {
			categoriasList.getItems().add("nombre : "+it.getNombre());
		}
	}
	
	void createAlert(String message) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(AlertType.INFORMATION);
	   	 a.show();
	}
}
