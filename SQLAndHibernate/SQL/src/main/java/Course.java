import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int courseId;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')")
    private CourseType type;

    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    private Teachers teacher;
    @Column(name = "students_count")
    private Integer studentsCount;

    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;



    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int courseId ) {
        this.courseId = courseId;
    }

    public int getId() {
        return courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setTeacherId(Teachers teacher) {
        this.teacher = teacher;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public CourseType getType() {
        return type;
    }
    @Override
    public String toString() {
        return "courseId: " + getId() + "\n" +
                "courseName: " + getName() + "\n" +
                "courseType: " + getType() + "\n" +
                "price: " + getPrice() + "\n" +
                "teacher" + getTeacher() + "\n";
    }

    public enum CourseType {
        DESIGN,
        PROGRAMMING,
        MARKETING,
        MANAGEMENT,
        BUSINESS

    }

}

