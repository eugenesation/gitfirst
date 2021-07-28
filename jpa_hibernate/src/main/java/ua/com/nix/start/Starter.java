package ua.com.nix.start;

import org.hibernate.Session;
import ua.com.nix.entity.Lesson;
import ua.com.nix.service.LessonInfo;
import ua.com.nix.util.HibernateUtil;

public class Starter {

    public void start() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            LessonInfo lessonInfo = new LessonInfo();
            int studentId = 1;
            String studentName = "Evgeny", studentSurname = "Smirnov";

            if (lessonInfo.getLessonInfo(session, studentId).isPresent()) {
                Lesson lesson = lessonInfo.getLessonInfo(session, studentId).get();
                System.out.println("Student: " + studentName + " " + studentSurname + "\nCloser lesson is " +
                        lesson.getName() + "\nStarted at " + lesson.getStartDateTime() +
                        "\nTeacher " + lesson.getTeacher().getName() + " " + lesson.getTeacher().getSurname());
            } else {
                System.out.println("Student doesn't have lessons now");
            }
        }
    }

}
