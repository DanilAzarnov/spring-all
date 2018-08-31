package ru.daniilazarnov.spring.intro.dao;

import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.User;

public interface ExamDao {

    Exam getExam(User user);
}
