package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Category;
import domain.Product;

public class ProductRepository {
	
	private final String URL = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=felicia&ssl=false";
	private Connection conn;

	public ProductRepository() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product findById(String id) throws SQLException {
		Product product = null;
		String select_table_query = "SELECT * FROM products WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(select_table_query);
	    
	    if(res.next()) {
	    	 
	    	CategoryRepository cr = CategoryRepository.getInstance();
	    	Category cat = cr.findById(res.getString("category_id"));
	    	product = new Product(res.getString("id"),res.getString("name"));
            product.setCategory(cat);
	    };
		return product;
	}

	public void create (Product product) throws SQLException {
		String insert_table_query = "INSERT INTO products (id,name) "
				+ "VALUES ('"+product.getId()+"','"+product.getName()+"')";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	public void delete(String id) throws SQLException {
		String select_table_query = "DELETE FROM products WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(select_table_query);
	
	}
	
	public void update (Product product) throws SQLException {
		String insert_table_query = "UPDATE products SET name='"+product.getName()+"' "
				+ "WHERE id='"+product.getId()+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	private static class SingletonHolder {
        private static final ProductRepository INSTANCE = new ProductRepository();
    }

    public static ProductRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
