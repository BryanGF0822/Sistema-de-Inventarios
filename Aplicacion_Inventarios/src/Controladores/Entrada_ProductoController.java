package Controladores;

import java.time.LocalDate;
import java.util.Date;

import com.sun.javafx.webkit.ThemeClientImpl;

import Modelo.Articulo;
import Modelo.Factura;
import Modelo.ItemArticulo;
import Modelo.Proveedor;
import Modelo.SistemaInventario;
import Vista.Agregar_Articulo;
import Vista.Entrada_Producto;
import Vista.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class Entrada_ProductoController {
	
	Entrada_Producto reference;
	private static SistemaInventario app;
	Factura tempFactura;
	
	@FXML
    private TextField priceText;

    @FXML
    private TextField cantidadText;

    @FXML
    private ChoiceBox<String> tipoEntradaPicker;

    @FXML
    private DatePicker fechaPicker;

    @FXML
    private ChoiceBox<String> proveedorPicker;

    @FXML
    private ChoiceBox<String> articuloPicker;

    @FXML
    private Label numArticulos;

    @FXML
    private Label valorArticulos;
	
	public Entrada_ProductoController(Entrada_Producto reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
	}
	
	
	
	@FXML
    void agregarProducto(ActionEvent event) {
		Integer artiInteger = articuloPicker.getSelectionModel().getSelectedIndex();
		String categoria = (String) tipoEntradaPicker.getValue();
		Integer proveedor = proveedorPicker.getSelectionModel().getSelectedIndex();
		LocalDate date = fechaPicker.getValue();
		if(priceText.getText().equals("") || cantidadText.getText().equals("") || categoria == null || proveedor == null || date == null || artiInteger == null){
			createAlert("Alguno de los campos no ha sido escrito ó selecionado apropiadamente");
			 
		}else {
			int cant = -1;
			try {
				 cant = Integer.parseInt(cantidadText.getText());
			 }catch (Exception e) {
				 createAlert("El campo de cantida no tiene un valor numerico valido");
			}
			double valor = -1;
			try {
				 valor = Double.parseDouble(priceText.getText());
			 }catch (Exception e) {
				 createAlert("El campo de  no tiene un valor numerico valido");
			}
			if(cant>0 && valor>0) {
				tempFactura.setFechaRealizacion(date);
				
				tempFactura.setProveedor(app.searchProveedor(proveedor));
				ItemArticulo item = new ItemArticulo(valor,cant, date, categoria, true);
				
				app.getArticulos().get(artiInteger).getItemsComprados().add(item);
				tempFactura.getItemsFactura().add(item);
				
				createAlert("Producto registrado correctamente");
				
				String replace[] = numArticulos.getText().split(": ");
				numArticulos.setText(replace[0]+": "+(Integer.parseInt(replace[1])+1));
				replace = valorArticulos.getText().split(": ");
				valorArticulos.setText(replace[0]+": "+(Double.parseDouble(replace[1])+(valor*cant)));
				
			}
			
		}
    }

    @FXML
    void irAlMenu(ActionEvent event) throws Exception {
    	Menu ventana = new Menu();
    	ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
		if(tempFactura.getItemsFactura().size()>0) {
			SistemaInventario pop = app;
			app.getFacturasDeCompra().add(tempFactura);			
		}
    }
    
    @FXML
    void crearNuevoArticulo(ActionEvent event) throws Exception {
    	Agregar_Articulo ventana = new Agregar_Articulo();
    	ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
    
    void createAlert(String message) {
    	 Alert a = new Alert(AlertType.NONE);
		 a.setContentText(message);
		 a.setAlertType(AlertType.INFORMATION);
		 a.show();
    }



	public void setUp() {
		
		for (Articulo it : app.getArticulos()) {
			articuloPicker.getItems().add(it.getNombre()+" "+it.getCantidadMedida()+" "+it.getTipoMedida());
		}
		
		for (Proveedor it : app.getProveedores()) {
			proveedorPicker.getItems().add("Nombre: "+it.getNombre()+" cc: "+it.getCedula());
		}
		
		tipoEntradaPicker.getItems().add("Devolucion");
		tipoEntradaPicker.getItems().add("Regalo");
		tipoEntradaPicker.getItems().add("Compra");
		
		
		tempFactura = new Factura(app.getId_facturas_compra(), null, null);
	}

}
