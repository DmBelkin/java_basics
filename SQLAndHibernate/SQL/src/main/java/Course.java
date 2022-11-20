import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

    private String description;

    private int duration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions", joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})
    private List<Subscriptions> Id;

    private String name;

    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;
    @Column(name = "students_count",nullable = true)
    private Integer studentsCount;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;


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

    public void setId(List<Subscriptions> courseId ) {
        this.Id = Id;
    }

    public List<Subscriptions> getId() {
        return Id;
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

    public void setTeacherId(Teacher teacherId) {
        this.teacher = teacherId;
    }

    public Teacher getTeacherId() {
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

}

