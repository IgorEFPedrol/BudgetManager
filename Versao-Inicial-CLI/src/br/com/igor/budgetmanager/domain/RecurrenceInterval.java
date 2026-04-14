package br.com.igor.budgetmanager.domain;


/**
 * Define a regra de repetição para transações recorrentes.
 * Cada valor representa uma estratégia diferente de cálculo de intervalo
 * na geração de novas transações.
 */
public enum RecurrenceInterval {
    DAILY,
    WEEKDAYS,
    WEEKLY,
    MONTHLY
}

