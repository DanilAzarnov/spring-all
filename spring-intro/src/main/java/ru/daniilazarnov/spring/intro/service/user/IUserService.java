package ru.daniilazarnov.spring.intro.service.user;

import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> getUser();

    void saveUser(User user);

}
