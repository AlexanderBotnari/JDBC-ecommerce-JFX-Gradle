package controllers;

import interfaces.MainMenuInterface;
import ui.Aplication;

public class MainMenuController implements MainMenuInterface{

	@Override
	public void createProductButton() {
		Aplication.switchScene(Aplication.enterProduct);
	}
	
	@Override
	public void findByIdButton() {
		Aplication.switchScene(Aplication.findProduct);
	}
	
	@Override
	public void updateProductButton() {
		Aplication.switchScene(Aplication.updateProduct);
	}
	
	@Override
	public void deleteProductButton() {
		Aplication.switchScene(Aplication.deleteProduct);
	}

	@Override
	public void createCategoryButton() {
		Aplication.switchScene(Aplication.enterCategory);
		
	}

	@Override
	public void updateCategoryButton() {
		Aplication.switchScene(Aplication.updateCategory);
	}

	@Override
	public void findByIdCategoryButton() {
		Aplication.switchScene(Aplication.findCategory);
		
	}

	@Override
	public void deleteCategoryButton() {
		Aplication.switchScene(Aplication.deleteCategory);
		
	}

	@Override
	public void createPriceButton() {
		Aplication.switchScene(Aplication.enterPrice);
		
	}

	@Override
	public void updatePriceButton() {
		Aplication.switchScene(Aplication.updatePrice);
		
	}

	@Override
	public void findByIdPriceButton() {
		Aplication.switchScene(Aplication.findPrice);
		
	}

	@Override
	public void deletePriceButton() {
		Aplication.switchScene(Aplication.deletePrice);
		
	}

	@Override
	public void createCurrencyButton() {
		Aplication.switchScene(Aplication.enterCurrency);
		
	}

	@Override
	public void updateCurrencyButton() {
		Aplication.switchScene(Aplication.updateCurrency);
		
	}

	@Override
	public void findByIdCurrencyButton() {
		Aplication.switchScene(Aplication.findCurrency);
		
	}

	@Override
	public void deleteCurrencyButton() {
		Aplication.switchScene(Aplication.deleteCurrency);
		
	}

}
