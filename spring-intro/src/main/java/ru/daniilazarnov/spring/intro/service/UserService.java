package ru.daniilazarnov.spring.intro.service;

import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser();

    User createUser();

}
