package ua.com.nix.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.com.nix.entity.Lesson;

import java.util.Optional;

public class LessonInfo {

    public Optional<Lesson> getLessonInfo(Session session, Integer studentId) {
        Query<Lesson> getLessonInfoQuery = session.createQuery(
                "select l from Lesson l join " +
                        "l.group g join " +
                        "g.students st where st.id = ?1 and current_timestamp < l.startDateTime order by " +
                        "l.startDateTime",
                Lesson.class);

        getLessonInfoQuery.setMaxResults(1);

        getLessonInfoQuery.setParameter(1, studentId);
        return Optional.ofNullable(getLessonInfoQuery.getSingleResult());

    }

}
