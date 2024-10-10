import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {

    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        int countFebuary = TransactionAnalyzer.countTransactionsByMonth(transactions, "02-2023");
        int countMarch = TransactionAnalyzer.countTransactionsByMonth(transactions, "03-2023");

        Assertions.assertEquals(2, countFebuary, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMarch, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopExpenses() {
        Transaction transaction1 = new Transaction("2023-01-01", -100.0, "Витрата 1");
        Transaction transaction2 = new Transaction("2023-01-02", -200.0, "Витрата 2");
        Transaction transaction3 = new Transaction("2023-01-03", -150.0, "Витрата 3");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        Assertions.assertEquals(3, topExpenses.size(), "Витрат має бути 3");
        Assertions.assertEquals(-200.0, topExpenses.get(0).getAmount(), "Найбільша витрата має бути -200,0");
    }
}