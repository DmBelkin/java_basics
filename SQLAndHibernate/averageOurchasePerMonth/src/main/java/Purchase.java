import java.time.LocalDateTime;

public class Purchase {

    private LocalDateTime subscriptionsDate;

    private String courseName;

    private String studentName;

    private int price;

    public Purchase(LocalDateTime subscriptionsDate, String courseName) {
        this.subscriptionsDate = subscriptionsDate;
        this.courseName = courseName;
    }

    public void setSubscriptionsDate(LocalDateTime subscriptionsDate) {

    }

    public LocalDateTime getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setCourseName(String courseName) {

    }

    public String getCourseName() {
        return courseName;
    }

    public void setPrice(int price) {

    }

    public int getPrice() {
        return price;
    }

    public void setStudentName(String studentName) {

    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "" + subscriptionsDate;
    }
}
