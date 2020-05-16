package Controladores;

import Modelo.Articulo;
import Modelo.Categoria;
import Modelo.Proveedor;
import Modelo.SistemaInventario;
import Vista.Agregar_Proveedor;
import Vista.Entrada_Producto;
import Vista.Menu;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

public class AgregarProveedorController {
	Agregar_Proveedor reference;
	private static SistemaInventario app;
	

	public AgregarProveedorController(Agregar_Proveedor reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	
	@FXML
    private TextField nameText;

    @FXML
    private TextField direccionText;

    @FXML
    private TextField telefonoText;
    
    @FXML
    private TextField ccText;
    
    @FXML
    private ListView<String> categoriaList;
    
    @FXML
    private ComboBox<String> proveedorChoice;

	
    @FXML
    void agregarProveedor(ActionEvent event) {
    	ObservableList<Integer> val = categoriaList.getSelectionModel().getSelectedIndices();
    	
		if(nameText.getText().equals("") || ccText.getText().equals("") || direccionText.getText().equals("") || telefonoText.getText().equals("") || val.size() == 0){
			createAlert("Alguno de los campos no ha sido escrito ó selecionado apropiadamente");
		}else {
			long cant = -1;
			try {
				
				cant = Integer.parseInt(telefonoText.getText());
				
				try {
					cant = Long.parseLong(ccText.getText());
					Proveedor ref = new Proveedor(nameText.getText(),direccionText.getText(),telefonoText.getText(),ccText.getText());
					for (Integer it : val) {
						ref.getCategoriasDistribuidor().add(app.searchCategoria(it));
					}
					if(changeIndx == -1) {
						app.getProveedores().add(ref);
						createAlert("Proveedor registrado exitosamente!");
					}else {
						app.getProveedores().set(changeIndx, ref);
						createAlert("Proveedor actualizado exitosamente!");
					}
					
					
					setup();
					
				} catch (Exception e) {
					
					createAlert("El campo de cedula solo debería contener caracteres numericos");
				}
				
			 }catch (Exception e) {
				 createAlert("El campo de telefono solo debería contener caracteres numericos");
			}
			
			
		}
    }
    
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
    	Menu ventana = new Menu();
    	ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
	int changeIndx;
	@FXML
    void modificar(ActionEvent event) {
		changeIndx = proveedorChoice.getSelectionModel().getSelectedIndex();
    	
    	if(changeIndx != -1) {
    		Proveedor ref = app.getProveedores().get(changeIndx);
    		nameText.setText(ref.getNombre());
    		ccText.setText(ref.getCedula());
    		ccText.setEditable(false);
    		direccionText.setText(ref.getDireccion());
    		telefonoText.setText(ref.getTelefono());
    		for(Categoria it : ref.getCategoriasDistribuidor()) {
    			categoriaList.getSelectionModel().selectNext();
    		}
    	}else {
    		createAlert("Selecciona un proveedor!");
    	}
    }
	
	public void setup() {
		changeIndx = -1;
		ccText.setEditable(true);
		nameText.clear();
		ccText.clear();
		direccionText.clear();
		telefonoText.clear();
		categoriaList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		categoriaList.getItems().clear();
		for (Categoria it : app.getCategorias()) {
			categoriaList.getItems().add("Nombre : "+it.getNombre());
		}
		proveedorChoice.getItems().clear();
		for (Proveedor it : app.getProveedores()) {
			proveedorChoice.getItems().add("Nombre: "+it.getNombre()+" cc: "+it.getCedula());
		}
	}
    
	void createAlert(String message) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(AlertType.INFORMATION);
	   	 a.show();
	}

}