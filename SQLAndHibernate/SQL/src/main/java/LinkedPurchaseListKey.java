import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class LinkedPurchaseListKey {
    @Column(name = "course_id")
    private int courseId;


    @Column(name = "student_id")
    private int studentId;

    public LinkedPurchaseListKey(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public LinkedPurchaseListKey() {

    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionKey)) return false;
        SubscriptionKey that = (SubscriptionKey) o;
        return Objects.equals(getCourseId(), that.getCourseId()) &&
                Objects.equals(getStudentId(), that.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getStudentId());
    }

}
