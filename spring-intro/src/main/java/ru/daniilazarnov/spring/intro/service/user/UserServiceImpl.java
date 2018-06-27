package ru.daniilazarnov.spring.intro.service.user;

import ru.daniilazarnov.spring.intro.dao.user.UserDao;
import ru.daniilazarnov.spring.intro.domain.User;

import java.util.Optional;

public class UserServiceImpl implements IUserService {

    private UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Optional<User> getUser() {
        return dao.getUser();
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

}
