
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        long money = 100000;
        for (int i = 0; i <= 50; i++) {
            Account account = new Account(Integer.toString(i), new AtomicLong(money));
            bank.setAccounts(account);
        }
        bank.toString();
        System.out.println(bank.getSumAllAccounts());

        for (int i = 0; i <= 25; i++) {
            if (i % 2 ==0 ) {
                bank.transfer(Integer.toString(i), Integer.toString(50 - i),
                        new AtomicLong(7000), bank);
            } else {
                bank.transfer(Integer.toString(i), Integer.toString(50 - i),
                        new AtomicLong(60000), bank);
            }
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        bank.toString();
        System.out.println(bank.getSumAllAccounts());
    }
}
