import jakarta.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teachers {
    @Id
    @Column(name = "id", nullable = false)
    private int teacherId;

    private String name;

    private int salary;
    private int age;

    public int getId() {
        return teacherId;
    }

    public void setId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "name: " + getName() + "\n" +
                "id: " + getId() + "\n" +
                "salary: " + getSalary() + "\n" +
                "age: " + getAge();
    }
}
