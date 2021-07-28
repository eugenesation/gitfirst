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

            if (lessonInfo.getLessonInfo(session, studentId).isEmpty()) {
                System.out.println("Student doesn't have lessons now");
            } else {
                Lesson lesson = lessonInfo.getLessonInfo(session, studentId).get();
                System.out.println("Students` " + studentName + " " + studentSurname + " closer lesson is " +
                        lesson.getName() +
                        ", started at " + lesson.getStartDateTime() +
                        ", teacher " + lesson.getTeacher().getName() + " " + lesson.getTeacher().getSurname() +
                        ", topic " + lesson.getLessonTopic().getName());
            }
        }
    }

}
