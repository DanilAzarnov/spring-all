package ru.daniilazarnov.spring.intro.dao;

import org.springframework.stereotype.Repository;
import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.User;

@Repository
public class ExamDaoImpl implements ExamDao {

    @Override
    public Exam getExam(User user) {
        return new Exam(user);
    }

}
