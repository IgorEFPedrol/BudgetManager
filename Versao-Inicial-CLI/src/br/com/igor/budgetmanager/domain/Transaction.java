package br.com.igor.budgetmanager.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Representa um fato financeiro pontual e imutável no tempo.
 * <p>
 * Uma transação é o registro de uma entrada ou saída de valor que já ocorreu
 * ou está programada para uma data específica.
 */
public class Transaction {

    private Long id;
    private String description;

    /**
     * Valor monetário da transação.
     * Utiliza-se BigDecimal, conforme a documentação oficial do Java, para
     * evitar as imprecisões de arredondamento do padrão IEEE 754 presentes
     * nos tipos primitivos double e float.
     */
    private BigDecimal amount;

    private LocalDate date;
    private Category category;

    /**
     * Construtor completo. Uma transação não deve existir sem esses dados básicos.
     */
    public Transaction(String description, BigDecimal amount, LocalDate date, Category category) {
        // Validações básicas de consistência conhecidas como Fail-Fast
        Objects.requireNonNull(amount, "O valor da transação não pode ser nulo.");
        Objects.requireNonNull(date, "A data da transação não pode ser nula.");
        Objects.requireNonNull(category, "A categoria não pode ser nula.");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }

        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    /**
     * Método de conveniência para descobrir rapidamente se a transação é
     * de entrada ou saída, delegando a responsabilidade para a categoria associada.
     */
    public TransactionType getTransactionType() {
        return this.category.getType();
    }

    // Getters essenciais
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public Category getCategory() { return category; }

    public void setId(Long id) { this.id = id; }
}