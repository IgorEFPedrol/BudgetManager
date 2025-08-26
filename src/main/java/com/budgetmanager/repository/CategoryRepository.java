package main.java.com.budgetmanager.repository;

import main.java.com.budgetmanager.model.Category;
import main.java.com.budgetmanager.model.CategoryType;

import java.util.ArrayList;
import java.util.List;


public class CategoryRepository {

	private List<Category> categories = new ArrayList<Category>();
	private Long nextId = 1L;
	
	//Inicializar com algumas categorias padrão
	public CategoryRepository() {
		//Criando algumas despesas padrão
		save(new Category("Alimentação", "Gastos com alimentação", CategoryType.EXPENSE));
		save(new Category("Transporte", "Gastos com trasporte", CategoryType.EXPENSE));
		save(new Category("Moradia", "Gastos com moradia", CategoryType.EXPENSE));
		save(new Category("Saúde", "Gastos com saúde", CategoryType.EXPENSE));
		
		//Criando algumas receitas padrão
		save(new Category("Salário", "Renda do salário mensal", CategoryType.INCOME));
		save(new Category("Investimentos", "Rendimentos de investimento", CategoryType.INCOME));
	}
	
	
	public Category save(Category category) {
		if (category.getId() == null) {
			category.setId(nextId++);
			categories.add(category);
		} else {
			//Atualizar categoria existente
			categories.removeIf(c -> c.getId().equals(category.getId()));
			categories.add(category);
		}
		return category;
	}
	
	
}
