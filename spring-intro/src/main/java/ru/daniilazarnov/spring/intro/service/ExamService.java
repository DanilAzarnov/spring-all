package ru.daniilazarnov.spring.intro.service;

import ru.daniilazarnov.spring.intro.domain.Exam;
import ru.daniilazarnov.spring.intro.domain.Question;
import ru.daniilazarnov.spring.intro.domain.User;

import java.util.List;

public interface ExamService {

    Exam startExam(User user, List<Question> questions);

}
