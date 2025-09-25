package main.java.com.budgetmanager;

import java.util.Scanner;

import main.java.com.budgetmanager.model.CategoryType;
import main.java.com.budgetmanager.service.TransactionService;

public class Main {
	
	private static TransactionService transactionService = new TransactionService();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			System.out.println("\n=== Sistema de Gerenciamento de Gastos ===");
			System.out.println("1. Adicionar despesa");
			System.out.println("2. Listar todas as despesas");
			System.out.println("3. Calcular total dos gastos");
			System.out.println("4. Adicionar renda");
			System.out.println("5. Listar todas as rendas");
			System.out.println("6. Calcular total das rendas");
			System.out.println("7. Gerenciar categorias");
			System.out.println("8. Listar categorias por tipo");
			System.out.println("Escolha uma opção: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1: {
					createCategory();
					break;
				}	
				case 2: {
					manageCategories();
					break;
					
				}
				case 3: {
					listCategoriesPerType();
					break;
					
				}
				case 4: {
					calculateTotalExpenses();
					break;
				}
				case 5: {
					addIncome();
					break;
				}
				case 6: {
					listIncomes();
					break;
				}
				case 7: {
					addExpense();
					break;
				}
				case 8: {
					listExpenses();
					break;
				}
				case 9: {
					running = false;
					break;
				}
				default:
					System.out.println("Opção Inválida!");
			}
		}
		
		System.out.println("Sistema encerrado.");
	}
	
	private static void createCategory() {
		
	}
	
	private static void addExpense() {
		System.out.println("Descrição: ");
		String description = scanner.nextLine();
		
		System.out.println("Valor: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Categoria: ");
		String categoryName = scanner.nextLine();
		
		CategoryType type = CategoryType.EXPENSE;
		
		
	}
	
	private static void listExpenses() {
		
	}
	private static void calculateTotalExpenses() {
		
	}
	private static void addIncome() {
		
	}
	private static void listIncomes() {
		
	}
	private static void calculateTotalIncomes() {
		
	}
	private static void manageCategories() {
		
	}
	private static void listCategoriesPerType() {
		
	}
}
