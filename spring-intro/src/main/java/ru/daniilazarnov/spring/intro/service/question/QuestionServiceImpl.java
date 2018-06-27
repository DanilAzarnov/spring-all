package ru.daniilazarnov.spring.intro.service.question;

import ru.daniilazarnov.spring.intro.dao.question.QuestionDao;
import ru.daniilazarnov.spring.intro.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements IQuestionService {

    private QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getListQuestion() {
        return dao.getListQuestion();
    }

}
