
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {

    @Column(name = "course_id", nullable = true)
    private int courseId;
    @Id
    @Column(name = "student_id", nullable = true)
    private int studentId;
    @Column(name = "subscription_date")
    private LocalDateTime subscriptionsDate;


    public void setCourseId(int courseId) {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setStudentId(int studentId) {

    }

    public int getStudentId() {
        return studentId;
    }

    public void setSubscriptionsDate(LocalDateTime subscriptionsDate) {

    }

    public LocalDateTime getSubscriptionsDate() {
        return subscriptionsDate;
    }
}
