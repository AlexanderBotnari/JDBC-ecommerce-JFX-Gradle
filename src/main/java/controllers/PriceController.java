package controllers;

import java.sql.SQLException;
import dao.PriceRepository;
import domain.Price;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.Aplication;

public class PriceController {
	
    private PriceRepository pr = PriceRepository.getInstance();
	
	@FXML
	private Label message;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField amount;

	@SuppressWarnings("deprecation")
	public void createPrice() throws SQLException {
		
		pr.create(new Price(new Integer(id.getText()), new Double(amount.getText())));
		message.setText("Price is added on Data Base !");
	}
	
	@SuppressWarnings("deprecation")
	public void findByIdPrice() throws SQLException {
		Price p = null;
		p = pr.findById(new Integer(id.getText()));
		message.setText(p.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void updatePrice() throws SQLException {
		pr.update(new Price(new Integer(id.getText()),new Double(amount.getText())));
		message.setText("Price is updated on Data Base!");
	}
	
	@SuppressWarnings("deprecation")
	public void deletePrice() throws SQLException {
	    pr.delete(new Integer(id.getText()));
		message.setText("The price is deleted succesfully!");
	}

	
	public void logout() {
		Aplication.switchScene(Aplication.mainMenu);
	}

}
