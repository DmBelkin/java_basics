import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int courseId;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    private Teachers teacherId;
    @Column(name = "students_count")
    private int studentsCount;

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

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setTeacherId(Teachers teacherId) {
        this.teacherId = teacherId;
    }

    public Teachers getTeacher() {
        return teacherId;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setType(CourseType courseType) {
        this.courseType = courseType;
    }

    public CourseType getType() {
        return courseType;
    }

}

