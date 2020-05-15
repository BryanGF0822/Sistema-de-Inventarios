package Controladores;

import java.util.ArrayList;

import Modelo.Articulo;
import Modelo.ItemArticulo;
import Modelo.SistemaInventario;
import Vista.Kardex;
import Vista.Menu;
import Vista.Metodo_PEPS;
import Vista.Metodo_PP;
import Vista.Salida_Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class KardexController {
	
	private Kardex reference;
	private static SistemaInventario app;
	
	public KardexController(Kardex reference, SistemaInventario app) {
		this.reference = reference;
		this.app=app;
	}
	
	@FXML
    private Label cstLabel;

    @FXML
    private ListView<String> infoTable;

    @FXML
    private ListView<String> outTable;

    @FXML
    private ComboBox<String> artChoice;
	

    @FXML
    void calcKardexPEPS(ActionEvent event) {
    	Integer indx = artChoice.getSelectionModel().getSelectedIndex();
    	setup();
    	double precioT = 0;
    	double precioU = 0;
    	int cant = 0;
    	ArrayList<Double>precioUH = new ArrayList<Double>();
    	ArrayList<Integer> cantH = new ArrayList<Integer>();
    	int pos = 0;
    	if(indx != -1) {
    		ArrayList<ItemArticulo> items = app.getItemsKardex(indx);
    		for(ItemArticulo it : items) {
    			if(it.isDisponible()) {
    				precioT += it.getPrecioUnidad()*it.getCantidad();
    				cant = it.getCantidad();
    				precioU = it.getPrecioUnidad();
    				precioUH.add(it.getPrecioUnidad());
    				cantH.add(it.getCantidad());
    				infoTable.getItems().add(it.toString());
    				outTable.getItems().add(String.format("|%10.10s| - |%10.2f| - |%12.2f|", String.valueOf(cant),precioU,precioT));
    			}else {
    				int c_vent = it.getCantidad();
    				int i = 0;
    				for (i = pos; i < cantH.size() && c_vent>0; i++) {
    					ItemArticulo ref;
    					if(c_vent - cantH.get(i)>=0) {
    						ref = new ItemArticulo(precioUH.get(i), cantH.get(i), it.getFechaEntrada(), it.getTipoOperacion(), it.isDisponible(), it.getId());
    						c_vent -= cantH.get(i);
    						precioT -= cantH.get(i)*precioUH.get(i);
    	    				cant -= cantH.get(i);
    	    				pos++;
    					}else {
    						ref = new ItemArticulo(precioUH.get(i), c_vent, it.getFechaEntrada(), it.getTipoOperacion(), it.isDisponible(), it.getId());
    						cantH.set(i, cantH.get(i)-c_vent);
    						precioT -= c_vent*precioUH.get(i);
    	    				cant -= c_vent;
    	    				c_vent = 0;
    					}
    					infoTable.getItems().add(ref.toString());
    					outTable.getItems().add("");
					}
    				outTable.getItems().remove(outTable.getItems().size()-1);
    				double tempVal = 0;
    				for (i = pos; i < cantH.size(); i++) {
    					if(i!=cantH.size()-1)infoTable.getItems().add("");
    					tempVal += cantH.get(i)*precioUH.get(i); 
    					outTable.getItems().add(String.format("|%10.10s| - |%10.2f| - |%12.2f|", String.valueOf(cantH.get(i)),precioUH.get(i),tempVal));
    				}
    				
    			}
    		}
    	}else {
    		createAlert("Selecciona un articulo!",AlertType.WARNING);
    	}
    }
    
    @FXML
    void calcKardexPP(ActionEvent event) {
    	Integer indx = artChoice.getSelectionModel().getSelectedIndex();
    	setup();
    	double precioT = 0;
    	double precioU = 0;
    	int cant = 0;
    	if(indx != -1) {
    		ArrayList<ItemArticulo> items = app.getItemsKardex(indx);
    		for(ItemArticulo it : items) {
    			if(it.isDisponible()) {
    				precioT += it.getPrecioUnidad()*it.getCantidad();
    				cant += it.getCantidad();
    				precioU = (precioT/(double)cant);
    				infoTable.getItems().add(it.toString());
    				outTable.getItems().add(String.format("|%10.10s| - |%10.2f| - |%12.2f|", String.valueOf(cant),precioU,precioT));
    			}else if(it.getTipoOperacion().equals(Articulo.VENDIDO)){
    				ItemArticulo ref = new ItemArticulo(precioU,it.getCantidad(),it.getFechaEntrada(),it.getTipoOperacion(),it.isDisponible(),it.getId());
					precioT -= ref.getPrecioUnidad()*ref.getCantidad();
					cant -= ref.getCantidad();
					precioU = (precioT/((double)cant));
					infoTable.getItems().add(ref.toString());
					outTable.getItems().add(String.format("|%10.10s| - |%10.2f| - |%12.2f|", String.valueOf(cant),precioU,precioT));
    			}
    		}
    	}else {
    		createAlert("Selecciona un articulo!",AlertType.WARNING);
    	}
    }
	
	@FXML
    void irAlMenu(ActionEvent event) throws Exception {
		Menu ventana = new Menu();
		ventana.setApp(app);
		ventana.start(reference.getReferenceStage());
    }
	
	
	public void setup() {
		artChoice.getItems().clear();
		for (Articulo it : app.getArticulos()) {
			artChoice.getItems().add(it.getNombre()+" "+it.getCantidadMedida()+" "+it.getTipoMedida());
		}
		infoTable.getItems().clear();
		outTable.getItems().clear();
		infoTable.getItems().add("|________________________________Entradas/Salidas_______________________________|");	
		infoTable.getItems().add("|___Fecha___|- |___Tipo___| - |Cantidad| - |___Precio Unt___| - |___Precio total___|");		
		outTable.getItems().add("|_____________________SALDO_______________________|");	
		outTable.getItems().add("|_Cantidad_| - |___Precio Unt___| - |___Precio total___|");		
		
	}
	
	void createAlert(String message,AlertType mtype) {
	   	 Alert a = new Alert(AlertType.NONE);
	   	 a.setContentText(message);
	   	 a.setAlertType(mtype);
	   	 a.show();
	}
}
