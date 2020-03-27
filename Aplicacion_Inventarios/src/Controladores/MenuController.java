package Controladores;

import Vista.Agregar_Proveedor;
import Vista.Entrada_Producto;
import Vista.Historial_Inventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PEPS;
import Vista.Metodo_PP;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {
	Menu reference;
	
	public MenuController(Menu reference) {
		this.reference = reference;
	}
	
	@FXML
    void agregarProveedor(ActionEvent event) throws Exception {
		Agregar_Proveedor ventana = new Agregar_Proveedor();
		ventana.start(reference.getReferenceStage());
    }

    @FXML
    void historialInventario(ActionEvent event) throws Exception {
    	Historial_Inventario ventana = new Historial_Inventario();
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void ingresarProducto(ActionEvent event) throws Exception {
    	Entrada_Producto ventana = new Entrada_Producto();
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void liberarProducto(ActionEvent event) throws Exception {
    	Salida_Producto ventana = new Salida_Producto();
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void metodoPEPS(ActionEvent event) throws Exception {
    	Metodo_PEPS ventana = new Metodo_PEPS();
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void metodoPP(ActionEvent event) throws Exception {
    	Metodo_PP ventana = new Metodo_PP();
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void tablaKardex(ActionEvent event) throws Exception {
    	Kardex ventana = new Kardex();
    	ventana.start(reference.getReferenceStage());
    }
}
