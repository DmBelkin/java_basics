import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "linkedpurchaselist")
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    private LinkedPurchaseListKey key;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseListKey getKey() {
        return key;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setKey(LinkedPurchaseListKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key.getCourseId() + " - " + key.getStudentId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedPurchaseList)) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return Objects.equals(getKey(), that.getKey());
    }


}
