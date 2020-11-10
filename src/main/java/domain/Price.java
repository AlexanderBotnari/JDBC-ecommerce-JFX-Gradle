package domain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
	
	private static CurrencyProvider currencyProvider = new CurrencyProvider();

	private Integer id;
	private Double amount;
	private Currency currency;
	
	public Price(Double amount) {
        this.amount = amount;
        this.currency = Currency.baseCurrency;
        
    }
	
	public Price(Integer id, Double amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public Price(String currency, Double amount) {
        this.currency = currencyProvider.getCurrency(currency);
        this.amount = amount;
    }
   
    public Price toCurrency(String code) {
    	Currency c = currencyProvider.getCurrency(code);

        if (currency.getCode().equals("EUR"))
            return new Price(c.getCode(), amount *  c.getRate());
        else
            return new Price(c.getCode(),amount  * c.getRate());
    }

	@Override
	public String toString() {
		return "Price [" + id + ", " + amount + ", " + currency + "]";
	}

    
	
}
