import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {

    @EmbeddedId
    SubscriptionKey key;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column (name = "subscription_date")
    private LocalDate subscriptionsDate;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
