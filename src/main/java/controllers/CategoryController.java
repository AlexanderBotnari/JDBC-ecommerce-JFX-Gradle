package controllers;

import java.sql.SQLException;

import dao.CategoryRepository;
import domain.Category;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.Aplication;

public class CategoryController {

    private CategoryRepository cr = CategoryRepository.getInstance();
	
	@FXML
	private Label message;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField name;

	public void createCategory() throws SQLException {
		cr.create(new Category(id.getText(),name.getText()));
		message.setText("Category is added on Data Base !");
	}
	
	public void findByIdCategory() throws SQLException {
		Category c = null;
		c = cr.findById(id.getText());
		message.setText(c.toString());
	}
	
	public void updateCategory() throws SQLException {
		cr.update(new Category(id.getText(),name.getText()));
		message.setText("Category is updated on Data Base!");
	}
	
	public void deleteCategory() throws SQLException {
	    cr.delete(id.getText());
		message.setText("The category is deleted succesfully!");
	}
	
	public void logout() {
		Aplication.switchScene(Aplication.mainMenu);
	}
}
