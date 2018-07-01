package ru.daniilazarnov.spring.intro.dao;

import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUser();

    void saveUser(User user);

}
