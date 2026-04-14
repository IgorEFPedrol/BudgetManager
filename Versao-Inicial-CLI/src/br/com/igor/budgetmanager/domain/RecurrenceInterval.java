package br.com.igor.budgetmanager.domain;


/**
 * Define a regra de repetição para transações recorrentes.
 * Cada valor representa uma estratégia diferente para calcular o intervalo
 * na geração de novas transações. (ex: Gastos diários, ou Semanais)
 */
public enum RecurrenceInterval {
    DAILY,
    WEEKDAYS,
    WEEKLY,
    MONTHLY
}

