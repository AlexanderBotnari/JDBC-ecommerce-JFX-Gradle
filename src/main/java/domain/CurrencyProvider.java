package domain;

import java.util.HashMap;
import java.util.Map;

public class CurrencyProvider {

	@SuppressWarnings("serial")
	private Map<String, Currency> currencies = new HashMap<>() {{
        put("EUR", Currency.baseCurrency);
        put("USD", new Currency("USD", 15.74));
        put("MDL", new Currency("MDL", 1.00));
        put("RUB", new Currency("RUB", 0.35));
	}};

    public Currency getCurrency(String code) {
        return currencies.get(code);
    }


    private static class SingletonHolder {
        private static final CurrencyProvider INSTANCE = new CurrencyProvider();
    }

    public static CurrencyProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
