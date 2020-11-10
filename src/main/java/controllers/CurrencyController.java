package controllers;

import java.sql.SQLException;

import dao.CurrencyRepository;
import domain.Currency;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.Aplication;

public class CurrencyController {

    private CurrencyRepository cr = CurrencyRepository.getInstance();
	
	@FXML
	private Label message;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField code;
	
	@FXML
	private TextField rate;

	@SuppressWarnings("deprecation")
	public void createCurrency() throws SQLException {
		cr.create(new Currency(id.getText(),code.getText(),new Double(rate.getText())));
		message.setText("Currency is added on Data Base !");
	}
	
	public void findByIdCurrency() throws SQLException {
		Currency c = null;
		c = cr.findById(id.getText());
		message.setText(c.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void updateCurrency() throws SQLException {
		cr.update(new Currency(id.getText(),code.getText(),new Double(rate.getText())));
		message.setText("Currency is updated on Data Base!");
	}
	
	public void deleteCurrency() throws SQLException {
	    cr.delete(id.getText());
		message.setText("The currency is deleted succesfully!");
	}

	
	public void logout() {
		Aplication.switchScene(Aplication.mainMenu);
	}
}
