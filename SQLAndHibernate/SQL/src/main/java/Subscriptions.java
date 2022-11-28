import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Students student;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Course course;
    @Column (name = "subscription_date")
    private LocalDate subscriptionsDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Students getStudentId() {
        return student;
    }

    public void setStudentId(Students student) {
        this.student = student;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }

    public LocalDate getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(LocalDate subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }

    @Override
    public String toString() {
        return "Course: " + getCourseId() + "\n" +
                "Student: " + getStudentId() + "\n" +
                "date: " + getSubscriptionsDate();
    }

}
