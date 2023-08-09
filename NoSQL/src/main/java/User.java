import java.time.LocalDate;


public class User implements Comparable<User> {

    private LocalDate registrationDate;

    private double userId;

    private boolean donate;

    private int showQueueNumber;

    public User (LocalDate registrationDate, double userId) {
        this.registrationDate = registrationDate;
        this.userId = userId;
    }

    public User(){}

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public boolean isDonate() {
        return donate;
    }

    public void setDonate(boolean donate) {
        this.donate = donate;
    }

    public int getShowQueueNumber() {
        return showQueueNumber;
    }

    public void setShowQueueNumber(int showQueueNumber) {
        this.showQueueNumber = showQueueNumber;
    }

    @Override
    public String toString() {
        return "user: " + userId + "\s" + "registrationDate: " + registrationDate + " donate: " + donate;
    }

    @Override
    public int compareTo(User user) {
        if (this.registrationDate.isAfter(user.getRegistrationDate())) {
            return 1;
        } else if(this.registrationDate.isBefore(user.getRegistrationDate())) {
            return - 1;
        }
        return 0;
    }
}
