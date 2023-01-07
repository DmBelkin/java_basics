import java.util.concurrent.atomic.AtomicLong;

public class Account {

    private AtomicLong money;
    private String accNumber;
    private boolean isBlocked = false;

    public Account(String accNumber, AtomicLong money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public AtomicLong getMoney() {
        return money;
    }

    public void setMoney(AtomicLong money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    @Override
    public String toString() {
        return "Номер счета: " + accNumber + "\n" +
                "Остаток на счету: " + getMoney() + "\n" +
                "Блокировка: " + isBlocked();
    }
}
