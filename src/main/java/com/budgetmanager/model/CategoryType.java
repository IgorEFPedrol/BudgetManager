package main.java.com.budgetmanager.model;

public enum CategoryType {

	INCOME("Receita"),
	EXPENSE("Despesa");
	
	private final String displayName;
	
	CategoryType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
}
