import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Students studentId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course courseId;

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public LocalDate getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(LocalDate subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }

    @Column (name = "subscriptions_date")
    private LocalDate subscriptionsDate;
}
