package main.java.com.budgetmanager.model;

import java.time.LocalDate;

public class Transaction {

	private Long id;
	private String description;
	private double amount;
	private LocalDate date;
	private Category category;
	private CategoryType type;
	
	public Transaction() {}
	
	public Transaction(Long id, String description, double amount, LocalDate date, Category category,
			CategoryType type) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}
	
	
}
