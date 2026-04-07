package main.java.com.budgetmanager;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import main.java.com.budgetmanager.model.Category;
import main.java.com.budgetmanager.model.CategoryType;

public class Main {

    // Instanciando o serviço que contém a lógica de negócios
	//private static TransactionService transactionService = new TransactionService();
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean running = true;

        //Criando algumas categorias de despesas padrão
        var alimentacao = new Category("Alimentação", "Gastos com alimentação", CategoryType.EXPENSE);
        var transporte = new Category("Transporte", "Gastos com transporte", CategoryType.EXPENSE);

        //Adicionando essas categorias em uma lista
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(alimentacao);
        categories.add(transporte);


        while (running) {
            System.out.println("""
                    
                    ===== Sistema de Gerenciamento de Gastos =====
                    
                    Escolha uma opção:
                    1 - Adicionar despesa
                    2 - Listar todas as despesas
                    3 - Calcular total dos gastos
                    
                    4 - Adicionar renda
                    5 - Listar todas as rendas
                    6 - Calcular total das rendas
                    
                    7 - Adicionar categorias
                    8 - Listar todas as categorias
                    9 - Listar categorias por despesas ou rendas
                    Aperte -1 para encerrar a execução
                    """);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                switch (choice) {
                    case 1: addExpense(); break;
                    case 2: listExpenses(); break;
                    case 3: calculateTotalExpenses(); break;
                    case 4: addIncome(); break;
                    case 5: listIncomes(); break;
                    case 6: calculateTotalIncomes(); break;
                    case 7: createCategories(); break;
                    case 8: listCategories(categories); break;
                    case 9: listCategoriesPerType(); break;
                    case -1: running = false; break;
                    default: System.out.println("Opção Inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
                scanner.nextLine(); // Limpa o buffer para evitar erros
            }
        }
        System.out.println("Sistema encerrado. Até logo! 👋");
        scanner.close();
    }

    private static void addExpense() {
        try {
            System.out.println("Para criar uma despesa insira:");
            System.out.print("Descrição da despesa: ");
            String description = scanner.nextLine();

            System.out.print("Valor: ");
            double value = scanner.nextDouble();
            scanner.nextLine(); // Limpando o buffer

            System.out.print("Nome da Categoria (ex: Alimentação, Transporte): ");
            String categoryName = scanner.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Erro: O valor deve ser um número.");
            scanner.nextLine(); // Limpa o buffer
        } catch (Exception e) {
            System.out.println("Erro ao adicionar despesa: " + e.getMessage());
        }
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

	private static void createCategories() {

	}

	private static void listCategories(ArrayList<Category> categories) {
        System.out.println(categories);
	}

    private static void listCategoriesPerType() {
        System.out.print("Listar categorias de qual tipo? (1 para DESPESA, 2 para RENDA): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        CategoryType type;

        if (typeChoice == 1) {
            type = CategoryType.EXPENSE;
            System.out.println("\n--- Categorias de Despesa ---");
        } else if (typeChoice == 2) {
            type = CategoryType.INCOME;
            System.out.println("\n--- Categorias de Renda ---");
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        /* Todo List<Category> categories = transactionService.getCategoriesByType(type);
        if (categories.isEmpty()) {
            System.out.println("Nenhuma categoria encontrada para este tipo.");
        } else {
            categories.forEach(category -> System.out.println("- " + category.getName()));
        }
        */
	}
}
