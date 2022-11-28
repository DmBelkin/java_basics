import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {


    @ManyToOne(cascade = CascadeType.ALL)
    private Students student;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
    @Id
    @Column (name = "subscription_date")
    private LocalDate subscriptionsDate;

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
