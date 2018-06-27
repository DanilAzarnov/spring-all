package ru.daniilazarnov.spring.intro.service;

import ru.daniilazarnov.spring.intro.domain.Question;

import java.util.List;

public interface IQuestionService {

    List<Question> getListQuestion();

}
