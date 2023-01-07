
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private Map<String, Account> accounts = new ConcurrentHashMap<>();

    private final Random random = new Random();
    private long totalMoney = 0;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, AtomicLong amount, Bank bank) {
        if (amount.longValue() >= 50000) {
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount.longValue())) {
                    blockAccount(fromAccountNum, toAccountNum);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        Transaction transaction = new Transaction(fromAccountNum, toAccountNum, amount, bank);
        Thread thread = new Thread(transaction);
        thread.start();
    }

    public void blockAccount(String fromAccountNum, String toAccountNum) {
        for (Map.Entry<String, Account> map : accounts.entrySet()) {
            if (map.getKey().equals(fromAccountNum) || map.getKey().equals(toAccountNum)) {
                map.getValue().setBlocked(true);
            }
        }
    }

    public long getBalance(String accountNum) {
        if (accounts.containsKey(accountNum)) {
            for (Map.Entry<String, Account> map : accounts.entrySet()) {
                if (accountNum.equals(map.getKey())) {
                    System.out.println(map.getValue().toString());
                    return map.getValue().getMoney().longValue();
                }
            }
        } else {
            System.out.println("Счет не найден");
        }
        return 0;
    }

    public long getSumAllAccounts() {
        return totalMoney;
    }

    public void setAccounts(Account account) {
        totalMoney += account.getMoney().longValue();
        accounts.put(account.getAccNumber(), account);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public String toString() {
        for (Map.Entry<String, Account> map : getAccounts().entrySet()) {
            System.out.println(map.getValue().toString());
            System.out.println();
        }
        return "";
    }
}
