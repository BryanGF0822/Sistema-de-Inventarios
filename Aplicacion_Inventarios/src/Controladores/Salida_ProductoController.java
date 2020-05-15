package Controladores;

import java.util.HashMap;

import Modelo.Articulo;
import Modelo.Categoria;
import Modelo.ItemArticulo;
import Modelo.SistemaInventario;
import Vista.Menu;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class Salida_ProductoController {
	private Salida_Producto reference;
	private static SistemaInventario app;
	private int idArticulo[][];
	
	public Salida_ProductoController(Salida_Producto reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
		idArticulo = new int[app.getArticulos().size()+2][2];
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
    	
    }
    
    public void setup() {
		tipoChoice.getItems().add("Vendido");
		tipoChoice.getItems().add("Producto dañado");
		tipoChoice.getItems().add("Promocion");
		int pos = 0;
		for (Articulo it : app.getArticulos()) {
			if(it.getItemsComprados().size() > 0){
				String articuloN = it.toString();
				it.getId();
				int numArt = 0; 
				for (ItemArticulo item : it.getItemsComprados()) {
					if(item.isDisponible()) {
						numArt += item.getCantidad();
					}
				}
				idArticulo[pos][0] = it.getId();
				idArticulo[pos][1] = numArt;
				productsList.getItems().add(articuloN+" , unidades disponibles = "+numArt);
				pos++;
			}
		}
	}
}
