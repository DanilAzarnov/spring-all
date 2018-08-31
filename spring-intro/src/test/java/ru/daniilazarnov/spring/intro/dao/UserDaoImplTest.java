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
class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    void saveUser() {
        assertFalse(userDao.getUser().isPresent());

        User user = new User("Ivan", "Ivanov");

        userDao.saveUser(user);

        assertTrue(userDao.getUser().isPresent());
        assertEquals(userDao.getUser().get(), user);
    }
}
