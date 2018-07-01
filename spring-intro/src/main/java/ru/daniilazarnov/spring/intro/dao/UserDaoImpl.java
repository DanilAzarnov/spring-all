package ru.daniilazarnov.spring.intro.dao;

import org.springframework.stereotype.Repository;
import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private Optional<User> user;

    public Optional<User> getUser() {
        return user;
    }

    @Override
    public void saveUser(User user) {
        this.user = Optional.of(user);
    }

}
