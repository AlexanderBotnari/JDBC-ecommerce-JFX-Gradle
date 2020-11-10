package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplication extends Application{

	private static Stage primaryStage;
	
    public static Scene mainMenu;
    
    public static Scene enterProduct;
    public static Scene findProduct;
    public static Scene updateProduct;
    public static Scene deleteProduct;
    
    public static Scene enterCategory;
    public static Scene findCategory;
    public static Scene updateCategory;
    public static Scene deleteCategory;
    
    public static Scene enterPrice;
    public static Scene findPrice;
    public static Scene updatePrice;
    public static Scene deletePrice;
    
    public static Scene enterCurrency;
    public static Scene findCurrency;
    public static Scene updateCurrency;
    public static Scene deleteCurrency;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Aplication.primaryStage = primaryStage;
		
			mainMenu = new Scene(FXMLLoader.load(getClass().getResource("/FDB.fxml")));
			
			enterProduct = new Scene (FXMLLoader.load(getClass().getResource("/enterProduct.fxml")));
            findProduct = new Scene (FXMLLoader.load(getClass().getResource("/findProduct.fxml")));
			updateProduct = new Scene(FXMLLoader.load(getClass().getResource("/updateProduct.fxml")));
			deleteProduct = new Scene(FXMLLoader.load(getClass().getResource("/deleteProduct.fxml")));
			
			enterCategory = new Scene(FXMLLoader.load(getClass().getResource("/enterCategory.fxml")));
			findCategory = new Scene (FXMLLoader.load(getClass().getResource("/findCategory.fxml")));
			updateCategory = new Scene(FXMLLoader.load(getClass().getResource("/updateCategory.fxml")));
			deleteCategory = new Scene(FXMLLoader.load(getClass().getResource("/deleteCategory.fxml")));
			
			enterPrice = new Scene(FXMLLoader.load(getClass().getResource("/createPrice.fxml")));
			findPrice = new Scene(FXMLLoader.load(getClass().getResource("/findPrice.fxml")));
			updatePrice = new Scene(FXMLLoader.load(getClass().getResource("/updatePrice.fxml")));
			deletePrice = new Scene(FXMLLoader.load(getClass().getResource("/deletePrice.fxml")));
			
			enterCurrency = new Scene(FXMLLoader.load(getClass().getResource("/enterCurrency.fxml")));
			findCurrency = new Scene(FXMLLoader.load(getClass().getResource("/findCurrency.fxml")));
			updateCurrency = new Scene(FXMLLoader.load(getClass().getResource("/updateCurrency.fxml")));
			deleteCurrency = new Scene(FXMLLoader.load(getClass().getResource("/deleteCurrency.fxml")));
			
		    switchScene(mainMenu);
	        primaryStage.show();
	}
	
	public static void switchScene(Scene scene) {
		  primaryStage.setScene(scene);
	}

}
