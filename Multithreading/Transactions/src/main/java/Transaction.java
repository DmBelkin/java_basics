import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Transaction implements Runnable {

    private String fromAccount;
    private String toAccount;
    private AtomicLong amount;
    private final Bank bank;
    private volatile  boolean isCorrect = false;

    public Transaction(String fromAccount, String toAccount, AtomicLong amount, Bank bank) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println("Thread started");
        if (bank.getAccounts().containsKey(fromAccount) && bank.getAccounts().containsKey(toAccount)) {
            for (Map.Entry<String, Account> map : bank.getAccounts().entrySet()) {
                if (map.getKey().equals(fromAccount)) {
                    if (map.getValue().isBlocked()) {
                        System.out.println("Счет " + fromAccount + " заблокирован");
                    } else {
                        long fromTransaction = map.getValue().getMoney().longValue() - amount.longValue();
                        if (fromTransaction >= 0) {
                            map.getValue().setMoney(new AtomicLong(fromTransaction));
                            isCorrect = true;
                        } else {
                            System.out.println("На счету недостаточно средств");
                        }
                    }
                }
                if (map.getKey().equals(toAccount) && isCorrect) {
                    if (map.getValue().isBlocked()) {
                        System.out.println("Счет " + toAccount + " заблокирован");
                    } else {

                        long toTransaction = map.getValue().getMoney().longValue() + amount.longValue();
                        map.getValue().setMoney(new AtomicLong(toTransaction));
                        System.out.println("Completed");
                    }
                }
            }
        } else {
            System.out.println("Неверный номер счета");
        }
    }
}
