package br.com.igor.budgetmanager.domain;

/**
 * Representa a natureza financeira de uma transação no sistema.
 * <p>
 * O uso de um Enum restringe os valores possíveis em tempo de compilação,
 * evitando erros de digitação (como strings "receita" ou "despesa") e
 * garantindo a integridade dos dados no domínio.
 */
public enum TransactionType {
    INCOME,
    EXPENSE
}
