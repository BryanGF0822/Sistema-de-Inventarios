package application;
	
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Modelo.Articulo;
import Modelo.Categoria;
import Modelo.ItemArticulo;
import Modelo.Proveedor;
import Modelo.SistemaInventario;
import Vista.Menu;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static SistemaInventario app;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Menu menu = new Menu();
			menu.setApp(app);
			menu.start(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		app = new SistemaInventario();
		
		app.getProveedores().add(new Proveedor("Reyes", "Yumbo, avn 3°", "3331111", "1111111111"));
		app.getProveedores().add(new Proveedor("Bryan", "Cl. 13a #58 -93", "3131111","2222222222"));
		app.getProveedores().add(new Proveedor("Camilo", "Cra 57#13c-24", "3151111", "3333333333"));
		
		app.getCategorias().add(new Categoria("Bebidas alcoholicas", 1));
		app.getCategorias().add(new Categoria("Dulces", 2));
		app.getCategorias().add(new Categoria("Snacks", 3));
		app.getCategorias().add(new Categoria("Bebidas no alcoholicas", 4));
		app.getCategorias().add(new Categoria("Cigarrillos", 5));
		app.getCategorias().add(new Categoria("Otros", 6));
		
		Articulo ref = new Articulo("Jugo hit", "ml", 600,app.getId_Articulo());
		ref.getCategorias().add(app.getCategorias().get(3));
		
		ItemArticulo itemR = new ItemArticulo(2000, 20, LocalDate.now(), "Compra", true,app.getId_item());
		ref.getItems().add(itemR);
		itemR = new ItemArticulo(2200, 20, LocalDate.now(), "Compra", true,app.getId_item());
		ref.getItems().add(itemR);
		itemR = new ItemArticulo(2100, 30, LocalDate.now(), "Compra", true,app.getId_item());
		ref.getItems().add(itemR);
		ref.setAgregarU(70,LocalDate.now());
		app.getArticulos().add(ref);
		
		ref = new Articulo("Cerveza corona", "ml", 500, app.getId_Articulo());
		ref.getCategorias().add(app.getCategorias().get(0));
		
		itemR = new ItemArticulo(3200, 50, LocalDate.now(), "Compra", true,app.getId_item());
		ref.getItems().add(itemR);
		itemR = new ItemArticulo(4000, 20, LocalDate.now(), "Compra", true,app.getId_item());
		ref.getItems().add(itemR);
		ref.setAgregarU(70,LocalDate.now());
		app.getArticulos().add(ref);
		
		launch(args);
	}
}
