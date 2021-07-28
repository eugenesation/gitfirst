package ua.com.nix.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "group")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    private String description;

    public Group() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group(String name, Course course, List<Lesson> lessons, List<Student> students, String description) {
        this.name = name;
        this.course = course;
        this.lessons = lessons;
        this.students = students;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", lessons=" + lessons +
                ", students=" + students +
                ", description='" + description + '\'' +
                '}';
    }
}
