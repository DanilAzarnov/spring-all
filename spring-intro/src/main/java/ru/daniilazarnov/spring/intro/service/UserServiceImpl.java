package ru.daniilazarnov.spring.intro.service;

import org.springframework.stereotype.Service;
import ru.daniilazarnov.spring.intro.dao.UserDaoImpl;
import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;
import java.util.Scanner;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl dao;
    private final I18nService ms;

    public UserServiceImpl(UserDaoImpl dao, I18nService ms) {
        this.dao = dao;
        this.ms = ms;
    }

    @Override
    public Optional<User> getUser() {
        return dao.getUser();
    }

    @Override
    public User createUser() {
        Scanner in = new Scanner(System.in);

        System.out.println(ms.message("what.is.your.first.name"));

        String firstName = in.nextLine();

        System.out.println(ms.message("what.is.your.last.name"));

        String lastName = in.nextLine();

        User user = new User(firstName, lastName);

        dao.saveUser(user);

        return user;
    }

}
