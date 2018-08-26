package ru.daniilazarnov.spring.intro.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.daniilazarnov.spring.intro.domain.User;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExamDaoImplTest {

    @Autowired
    ExamDao examDao;

    @Test
    void getExam() {
        assertNotNull(examDao.getExam(new User("", "")));
    }

}
