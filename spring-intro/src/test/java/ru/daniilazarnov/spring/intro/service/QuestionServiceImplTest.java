package ru.daniilazarnov.spring.intro.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.daniilazarnov.spring.intro.dao.QuestionDao;
import ru.daniilazarnov.spring.intro.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuestionServiceImplTest {

    @MockBean
    QuestionDao questionDao;

    @Autowired
    QuestionService questionService;

    @Test
    void name() {
        when(questionDao.getListQuestion()).thenReturn(List.of(new Question()));

        assertNotNull(questionService.getListQuestion());
        assertFalse(questionService.getListQuestion().isEmpty());
    }
}
