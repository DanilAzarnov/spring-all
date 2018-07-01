package ru.daniilazarnov.spring.intro.service;

import org.springframework.stereotype.Service;
import ru.daniilazarnov.spring.intro.dao.CsvQuestionDao;
import ru.daniilazarnov.spring.intro.domain.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final CsvQuestionDao dao;

    public QuestionServiceImpl(CsvQuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Question> getListQuestion() {
        return dao.getListQuestion();
    }

}
