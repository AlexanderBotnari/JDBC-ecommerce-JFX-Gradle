package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	
	private String  id;
	private String   name;
	private Category category;
	
    public Product(String id, String name) {
		this.id = id;
		this.name = name;
	}
    
	public Product(String id, String name, Category category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product ["+ id + ", " + name + " , " + category + "]";
	}

}
