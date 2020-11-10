package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import domain.Currency;
import domain.Price;

public class PriceRepository {

	private final String URL = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=felicia&ssl=false";
	private Connection conn;
	
	public PriceRepository()  {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Price findById(Integer id) throws SQLException {
		Price price = null;
		String select_table_query = "SELECT * FROM prices WHERE id="+id;
		Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(select_table_query);
	    
	    if(res.next()) {
	    	 
	    	CurrencyRepository cr = CurrencyRepository.getInstance();
	    	Currency c = cr.findById(res.getString("currency_id"));
	    	price = new Price(res.getInt("id"),res.getDouble("amount"));
            price.setCurrency(c);
	    };
		return price;
	}
	
	public void create (Price price) throws SQLException {
		String insert_table_query = "INSERT INTO prices (id,amount) "
				+ "VALUES ("+price.getId()+","+price.getAmount()+")";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	public void delete(Integer id) throws SQLException {
		String select_table_query = "DELETE FROM prices WHERE id="+id;
		Statement stm = conn.createStatement();
	    stm.executeUpdate(select_table_query);
	
	}
	
	public void update (Price price) throws SQLException {
		String insert_table_query = "UPDATE prices SET amount="+price.getAmount()
				+ "WHERE id="+price.getId();
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	private static class SingletonHolder {
        private static final PriceRepository INSTANCE = new PriceRepository();
    }

    public static PriceRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
