import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Purchaselist")
public class PurchaseList {

    @EmbeddedId
    PurchaseListKey key;

    @Column(name = "subscription_date")
    private LocalDate subscriptionDate;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Column(name = "price")
    private int price;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "studentName: " + getStudentName() + "\n" +
                "subscriptiondate: " + getSubscriptionDate() + "\n" +
                "price" + getPrice() + "\n" +
                "coursename: " + getCourseName();
    }
}
