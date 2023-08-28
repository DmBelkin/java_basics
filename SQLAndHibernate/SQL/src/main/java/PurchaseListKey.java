import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseListKey implements Serializable {

    @Column(name = "course_name")
    private String courseName;


    @Column(name = "student_name")
    private String studentName;

    public PurchaseListKey(String courseName, String studentName) {
        this.courseName = courseName;
        this.studentName = studentName;
    }

    private PurchaseListKey() {

    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriptionKey)) return false;
        PurchaseListKey that = (PurchaseListKey) o;
        return Objects.equals(getCourseName(), that.getCourseName()) &&
                Objects.equals(getStudentName(), that.getStudentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseName(), getStudentName());
    }

}
