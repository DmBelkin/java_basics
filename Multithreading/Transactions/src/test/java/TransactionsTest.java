
import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicLong;

public class TransactionsTest extends TestCase {

    private final Bank bank = new Bank();

    public void testTransactionTest() { //транзакция менее 50000
        String fromAccNumber = "AS4325B";
        String toAccNumber = "BB2341S";
        bank.setAccounts(new Account(fromAccNumber, new AtomicLong(30000)));
        bank.setAccounts(new Account(toAccNumber, new AtomicLong(40000)));
        Transaction transaction = new Transaction(fromAccNumber, toAccNumber,
                new AtomicLong(10000), bank);
        transaction.run();
        assertEquals( 20000, bank.getBalance(fromAccNumber));
        assertEquals(50000, bank.getBalance(toAccNumber));
    }

    public void testBlockedTransaction() { // транзакция с заблокированным счетом
        String fromAccNumber = "RT0008S";
        String toAccNumber = "BB2341S";
        bank.setAccounts(new Account(fromAccNumber, new AtomicLong(35000)));
        bank.setAccounts(new Account(toAccNumber, new AtomicLong(50000)));
        bank.blockAccount(fromAccNumber, toAccNumber);
        Transaction transaction = new Transaction(fromAccNumber, toAccNumber,
                new AtomicLong(5000), bank);
        transaction.run();
        assertEquals("Счет " + fromAccNumber +  " заблокирован",35000,
                bank.getBalance(fromAccNumber));
        assertEquals(50000, bank.getBalance(toAccNumber));
    }

    public void testTotalAmount() { //подсчет общей суммы
        String fromAccNumber = "RT0008S";
        String toAccNumber = "BB2341S";
        bank.setAccounts(new Account(fromAccNumber, new AtomicLong(35000)));
        bank.setAccounts(new Account(toAccNumber, new AtomicLong(1000)));
        assertEquals(36000, bank.getSumAllAccounts());
    }

    public void testWrongNumber() { //попытка транзакции с несуществующим счетом
        String fromAccNumber = "RT0008S";
        String toAccNumber = "BB2341S";
        bank.setAccounts(new Account(fromAccNumber, new AtomicLong(35000)));
        bank.setAccounts(new Account(toAccNumber, new AtomicLong(10000)));
        Transaction transaction = new Transaction(fromAccNumber, "RE2349U",
                new AtomicLong(2000), bank);
        Transaction transaction1 = new Transaction("RE2349U",toAccNumber,
                new AtomicLong(2000), bank);
        transaction.run();
        transaction1.run();
        assertEquals("Неверный номер счета", 35000, bank.getBalance(fromAccNumber));
        assertEquals("Неверный номер счета", 10000, bank.getBalance(toAccNumber));
    }

    public void testWrongAmount() { //попытка снять больше, чем есть на счете
        String fromAccNumber = "RT0008S";
        String toAccNumber = "BB2341S";
        bank.setAccounts(new Account(fromAccNumber, new AtomicLong(1000)));
        bank.setAccounts(new Account(toAccNumber, new AtomicLong(1000)));
        Transaction transaction = new Transaction(fromAccNumber, toAccNumber,
                new AtomicLong(2000), bank);
        transaction.run();
        assertEquals("На счету недостаточно средств", 1000,
                bank.getBalance(fromAccNumber));
        assertEquals(1000, bank.getBalance(toAccNumber));
    }

    public void testMultiThreading() { // тестирование многопоточного режима transfer с проверкой общей суммы
        long money = 10000;
        for (int i = 1; i <= 6; i++) {
            Account account = new Account(Integer.toString(i), new AtomicLong(money));
            bank.setAccounts(account);
        }
        assertEquals(60000, bank.getSumAllAccounts());
        long amount = 1000;
        for (int i = 1; i <= 5; i++) {
            bank.transfer(Integer.toString(i), Integer.toString(i + 1),
                    new AtomicLong(amount), bank);
            amount += 1000;
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        assertEquals(9000, bank.getBalance("1"));
        assertEquals(9000, bank.getBalance("2"));
        assertEquals(9000, bank.getBalance("3"));
        assertEquals(9000, bank.getBalance("4"));
        assertEquals(9000, bank.getBalance("5"));
        assertEquals(15000, bank.getBalance("6"));
        assertEquals(60000, bank.getSumAllAccounts());
    }
}