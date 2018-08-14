package edu.omsu.jesper.service.implementation;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void setCompany(String username, Company company) {
        if (!userDao.checkExistence(username))
            throw new UsernameNotFoundException(String.format("User %s not found", username));
        User user = userDao.get(username);
        user.setCompany(company);
        userDao.update(username, user);
    }

    @Override
    public void setCompany(User user, Company company) {
        setCompany(user.getUsername(), company);
    }
}
