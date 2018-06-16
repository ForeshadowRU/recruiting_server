package edu.omsu.jesper.service.implementation;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void save(User user) throws Exception {
        if (user.getName().length() < 2) {
            throw new Exception();
        }
        userDao.save(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);

    }
}
