package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Currency {
	
	public static Currency baseCurrency = new Currency (
	        "EUR",
	         17.24         
	    );
	
	private String id;
    private String code;       
    private Double rate;
    
	public Currency(String code, Double rate) {
		this.code = code;
		this.rate = rate;
		
	}
	
	@Override
	public String toString() {
		return "Currency [" + id + ", " + code + ", " + rate + "]";
	}

    
}
