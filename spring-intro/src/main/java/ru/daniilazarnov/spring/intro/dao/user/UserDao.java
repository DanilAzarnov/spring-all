package ru.daniilazarnov.spring.intro.dao.user;

import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public class UserDao implements IUserDao {

    private Optional<User> user;

    public Optional<User> getUser() {
        return user;
    }

    @Override
    public void saveUser(User user) {
        this.user = Optional.of(user);
    }

}
