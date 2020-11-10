package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Category;
public class CategoryRepository {
	
	private final String URL = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=felicia&ssl=false";
	private Connection conn;
	
	public CategoryRepository() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Category findById(String id) throws SQLException {
		Category category = null;
		String select_table_query = "SELECT * FROM categories WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(select_table_query);
	    
	    if(res.next()) {
	    	category = new Category(res.getString("id"),res.getString("name"));
	    };
		return category;
	}
	
	public void create (Category category) throws SQLException {
		String insert_table_query = "INSERT INTO categories (id,name) "
				+ "VALUES ('"+category.getId()+"','"+category.getName()+"')";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	
	public void delete(String id) throws SQLException {
		String select_table_query = "DELETE FROM categories WHERE id='"+id+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(select_table_query);
	
	}
	
	public void update (Category category) throws SQLException {
		String insert_table_query = "UPDATE categories SET name='"+category.getName()+"' "
				+ "WHERE id='"+category.getId()+"'";
		Statement stm = conn.createStatement();
	    stm.executeUpdate(insert_table_query);
	}
	private static class SingletonHolder {
        private static final CategoryRepository INSTANCE = new CategoryRepository();
    }

    public static CategoryRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
