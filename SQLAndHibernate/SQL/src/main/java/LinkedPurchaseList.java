import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private  int id;
    @Column(name = "subscription_date", nullable = true)
    private LocalDate subscriptonDate;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
    @Column(nullable = true)
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getSuscriptonDate() {
        return subscriptonDate;
    }

    public void setSuscriptonDate(LocalDate suscriptonDate) {
        this.subscriptonDate = suscriptonDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int course) {
        this.courseId = courseId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "course: " + getCourseId() + "\n"  +
                "student" + getStudentId() + "\n" +
                "price: " + getPrice() + "\n" +
                "date: " + getSuscriptonDate();
    }
}
