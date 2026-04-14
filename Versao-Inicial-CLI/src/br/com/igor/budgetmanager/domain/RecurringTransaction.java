package br.com.igor.budgetmanager.domain;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma intenção ou regra de repetição de gastos/ganhos.
 * <p>
 * Atua como uma Factory que gera instâncias de {@link Transaction}
 * baseadas no intervalo definido e no tempo transcorrido.
 */
public class RecurringTransaction {

    private Long id;
    private String description;
    private BigDecimal baseAmount;
    private LocalDate startDate;
    private LocalDate endDate; // Pode ser nulo se for uma repetição infinita
    private RecurrenceInterval interval;
    private Category category;
    /**
     * Variável de estado essencial para não gerar transações duplicadas.
     * Guarda a data da última vez em que as transações foram processadas.
     */
    private LocalDate lastGeneratedDate;


    public RecurringTransaction(String description, BigDecimal baseAmount, LocalDate startDate,
                                RecurrenceInterval interval, Category category) {
        this.description = description;
        this.baseAmount = baseAmount;
        this.startDate = startDate;
        this.interval = interval;
        this.category = category;

        // Inicialmente, se a transação acaba de ser criada,
        // dizemos que o último "dia gerado" é um dia antes da data de início.
        this.lastGeneratedDate = startDate.minusDays(1);
    }

    /**
     * Gera uma lista de transações devidas até a data atual fornecida.
     * * @param currentDate A data limite de processamento (geralmente LocalDate.now()).
     * @return Lista de novas transações prontas para serem salvas no repositório.
     */
    public List<Transaction> generateDueTransactions(LocalDate currentDate) {
        List<Transaction> generatedList = new ArrayList<>();

        // Começamos a verificar a partir do dia seguinte à última geração
        LocalDate dateToProcess = this.lastGeneratedDate.plusDays(1);

        while (!dateToProcess.isAfter(currentDate)) {

            // Verifica limite de data de término (se existir)
            if (this.endDate != null && dateToProcess.isAfter(this.endDate)) {
                break;
            }

            boolean shouldGenerate = false;

            // Avalia as regras de negócio de acordo com o intervalo escolhido
            switch (this.interval) {
                case DAILY:
                    shouldGenerate = true;
                    break;
                case WEEKDAYS:
                    shouldGenerate = !isWeekend(dateToProcess);
                    break;
                case WEEKLY:
                    // Verifica se o dia atual é o mesmo dia da semana da data de início
                    shouldGenerate = dateToProcess.getDayOfWeek() == this.startDate.getDayOfWeek();
                    break;
                case MONTHLY:
                    // Verifica se o dia atual é o mesmo dia do mês da data de início
                    shouldGenerate = dateToProcess.getDayOfMonth() == this.startDate.getDayOfMonth();
                    break;
            }

            if (shouldGenerate) {
                Transaction newTransaction = new Transaction(
                        this.description,
                        this.baseAmount,
                        dateToProcess,
                        this.category
                );
                generatedList.add(newTransaction);
            }

            dateToProcess = dateToProcess.plusDays(1);
        }

        // Atualiza o estado da classe para não duplicar na próxima vez que o método for chamado
        this.lastGeneratedDate = currentDate;

        return generatedList;
    }

    /**
     * Método auxiliar privado para encapsular a lógica de detecção de final de semana.
     */
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    // Getters
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public LocalDate getLastGeneratedDate() { return lastGeneratedDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setId(Long id) { this.id = id; }
}