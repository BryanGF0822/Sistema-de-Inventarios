package Controladores;

import Modelo.SistemaInventario;
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
	private static SistemaInventario app;
	private Menu reference;
	
	public MenuController(Menu reference, SistemaInventario app) {
		this.reference = reference;
		this.app = app;
		/*for (int i = 0; i < app.getFacturasDeCompra().size(); i++) {
			System.out.println(app.getFacturasDeCompra().get(i).getItemsFactura().size()+" lol");
		}*/
	}
	
	@FXML
    void agregarProveedor(ActionEvent event) throws Exception {
		Agregar_Proveedor ventana = new Agregar_Proveedor();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }

    @FXML
    void historialInventario(ActionEvent event) throws Exception {
    	Historial_Inventario ventana = new Historial_Inventario();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void ingresarProducto(ActionEvent event) throws Exception {
    	Entrada_Producto ventana = new Entrada_Producto();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void liberarProducto(ActionEvent event) throws Exception {
    	Salida_Producto ventana = new Salida_Producto();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }

    @FXML
    void tablaKardex(ActionEvent event) throws Exception {
    	Kardex ventana = new Kardex();
    	ventana.setApp(app);
    	ventana.start(reference.getReferenceStage());
    }
}
