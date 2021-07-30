package ua.com.nix.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.com.nix.entity.Lesson;

public class LessonInfo {

    public Lesson getLessonInfo(Session session, Integer studentId) {
        Query<Lesson> getLessonInfoQuery = session.createQuery(
                "select l from Lesson l join l.group g join g.students st where st.id = ?1 " +
                        "and current_timestamp < l.startDateTime order by l.startDateTime", Lesson.class);

        getLessonInfoQuery.setMaxResults(1);

        getLessonInfoQuery.setParameter(1, studentId);
        return getLessonInfoQuery.getSingleResult();

    }

}
