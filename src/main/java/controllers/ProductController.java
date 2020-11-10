package controllers;

import java.sql.SQLException;

import dao.ProductRepository;
import domain.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.Aplication;

public class ProductController {
	
	private ProductRepository pr = ProductRepository.getInstance();
	
	@FXML
	private Label message;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField name;

	public void createProduct() throws SQLException {
		pr.create(new Product(id.getText(),name.getText()));
		message.setText("Product is added on Data Base !");
	}
	
	public void findByIdProduct() throws SQLException {
		Product p = null;
		p = pr.findById(id.getText());
		message.setText(p.toString());
	}
	
	public void updateProduct() throws SQLException {
		pr.update(new Product(id.getText(),name.getText()));
		message.setText("Product is updated on Data Base!");
	}
	
	public void deleteProduct() throws SQLException {
		pr.delete(id.getText());
		message.setText("The product is deleted succesfully!");
	}
	
	public void logout() {
		Aplication.switchScene(Aplication.mainMenu);
	}
}
