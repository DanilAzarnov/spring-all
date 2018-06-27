package ru.daniilazarnov.spring.intro.dao.user;

import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public interface IUserDao {

    Optional<User> getUser();

    void saveUser(User user);

}
