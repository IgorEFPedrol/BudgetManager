package main.java.com.budgetmanager.model;

import java.time.LocalDate;

public class Transaction {

	private Long id;
	private String description;
	private double value;
	private LocalDate date;
	private Category category;
	private CategoryType type;
	
	public Transaction() {}
	
	public Transaction(Long id, String description, double value, LocalDate date, Category category,
                       CategoryType type) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.date = date;
		this.category = category;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryType getType() { return type; }

	public void setType(CategoryType type) {
		this.type = type;
	}

}
