package ua.com.nix.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessontopic_id")
    private LessonTopic lessonTopic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "lesson")
    private List<Mark> marks;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Lesson() {
    }

    public Lesson(String name, LessonTopic lessontopic, Teacher teacher, List<Mark> marks, LocalDateTime startDateTime, Group group) {
        this.name = name;
        this.lessonTopic = lessontopic;
        this.teacher = teacher;
        this.marks = marks;
        this.startDateTime = startDateTime;
        this.group = group;
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

    public LessonTopic getLessonTopic() {
        return lessonTopic;
    }

    public void setLessonTopic(LessonTopic lessonTopic) {
        this.lessonTopic = lessonTopic;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessonTopic=" + lessonTopic +
                ", teacher=" + teacher +
                ", marks=" + marks +
                ", startDateTime=" + startDateTime +
                ", group=" + group +
                '}';
    }
}
