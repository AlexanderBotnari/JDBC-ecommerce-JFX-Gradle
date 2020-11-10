package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Category {

	public Category() {}
	private String  id;
	private String  name;
	@Override
	public String toString() {
		return "Category [" + id + ", " + name + "]";
	}
	
}
