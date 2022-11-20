import jakarta.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int teacherId;

    private int salary;

    private String name;

    private int age;

    public void setTeacherId(int teacherId) {

    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setName(String name) {

    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {

    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {

    }

    public int getAge() {
        return age;
    }
}
