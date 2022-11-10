import jakarta.persistence.*;

@Entity
@Table(name = "skillbox")
public class Course {

    private String description;

    private int duration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;
    @Column(name = "students_count")
    private int studentsCount;
    @Column(name = "teacher_id")
    private int teacherId;
    @Enumerated
    @Column(columnDefinition = "enum")
    private CourseType type;

    public Course() {

    }

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
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
}

