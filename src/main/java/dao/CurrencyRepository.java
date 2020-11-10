package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Currency;
public class CurrencyRepository {

	private final String URL = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=felicia&ssl=false";
	private Connection conn;
	
	public CurrencyRepository() {
			try {
				conn = DriverManager.getConnection(URL);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public Currency findById(String id) throws SQLException {
		Currency currency = null;
		String select_table_query = "SELECT * FROM currency WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(select_table_query);
	    
	    if(res.next()) {
	    	currency = new Currency(res.getString("id"),res.getString("code"),res.getDouble("rate"));
	    };
		return currency;
	}

	public void create (Currency currency) throws SQLException {
	String insert_table_query = "INSERT INTO currency (id,rate,code) "
			+ "VALUES ('"+currency.getId()+"',"+currency.getRate()+",'"+currency.getCode()+"')";
	Statement stm = conn.createStatement();
    stm.executeUpdate(insert_table_query);
}
	
	public void delete(String id) throws SQLException {
		String select_table_query = "DELETE FROM currency WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(select_table_query);
	
	}
	
	public void update (Currency currency) throws SQLException {
		String insert_table_query = "UPDATE currency SET rate="+currency.getRate()
				+ "WHERE id='"+currency.getId()+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	private static class SingletonHolder {
         private static final CurrencyRepository INSTANCE = new CurrencyRepository();
    }

    public static CurrencyRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

