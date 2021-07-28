package ua.com.nix.entity;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private Integer score;

    public Mark() {
    }

    public Mark(Student student, Lesson lesson, Integer score) {
        this.student = student;
        this.lesson = lesson;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", lesson=" + lesson +
                ", score=" + score +
                '}';
    }
}
