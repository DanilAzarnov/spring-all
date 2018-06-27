package ru.daniilazarnov.spring.intro.dao;

import ru.daniilazarnov.spring.intro.domain.Question;

import java.util.List;

public interface IQuestionDao {

    List<Question> getListQuestion();

}
