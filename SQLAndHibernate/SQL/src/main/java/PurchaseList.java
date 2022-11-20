import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "Purchaselist")
public class PurchaseList {
    @Id
    private LocalDateTime subscriptionsDate;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "student_name")
    private String studentName;

    private int price;

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
