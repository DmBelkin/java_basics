import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Students")
public class Student {
    @Column(name = "registration_date")
    private LocalDateTime regDate;

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne (cascade = CascadeType.ALL)
    private Subscriptions studentId;

    private int age;

    public void  setName(String name) {

    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {

    }

    public int getAge() {
        return age;
    }

    public void setRegDate(LocalDateTime regDate) {

    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setStudentId(Subscriptions studentId) {

    }

    public Subscriptions getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return name;
    }
}
