package main.java.com.budgetmanager.model;

public class Category {

	private Long id;
	private String name;
	private String description;
	private CategoryType type;
	
	public Category() {}

	public Category(String name, String description, CategoryType type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public Long getId() { return id; }
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() { return description; }

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryType getType() {	return type; }

	public void setType(CategoryType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
