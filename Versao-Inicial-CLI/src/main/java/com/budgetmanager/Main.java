package main.java.com.budgetmanager;

import java.util.Scanner;
import java.util.InputMismatchException;
import main.java.com.budgetmanager.model.CategoryType;
import main.java.com.budgetmanager.service.TransactionService;

public class Main {

    // Instanciando o serviço que contém a lógica de negócios
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
            System.out.println("9. Sair...");
			System.out.println("Escolha uma opção: ");

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
                    case 7: manageCategories(); break;
                    case 8: listCategoriesPerType(); break;
                    case 9: running = false; break;
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
            System.out.print("Descrição da despesa: ");
            String description = scanner.nextLine();

            System.out.print("Valor: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer

            System.out.print("Nome da Categoria (ex: Alimentação, Transporte): ");
            String categoryName = scanner.nextLine();

            // A classe Main apenas coleta os dados e os envia para o serviço
            transactionService.createExpense(description, amount, categoryName);
            System.out.println("✅ Despesa adicionada com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: O valor deve ser um número.");
            scanner.nextLine(); // Limpa o buffer
        } catch (Exception e) {
            System.out.println("Erro ao adicionar despesa: " + e.getMessage());
        }
    }

    private static void listExpenses() {
        System.out.println("\n--- Lista de Todas as Despesas ---");
        List<Transaction> expenses = transactionService.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("Nenhuma despesa registrada ainda.");
        } else {
            // O método toString() na classe Transaction será usado aqui
            expenses.forEach(System.out::println);
        }
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
