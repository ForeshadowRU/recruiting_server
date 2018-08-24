package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.UserDao;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserAuthenticationService authentication;
    private final UserDao userDao;

    @Autowired
    public UserController(UserAuthenticationService authentication, UserDao userDao) {
        this.authentication = authentication;
        this.userDao = userDao;
    }

    @GetMapping("/current")
    public User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/")
    public List<User> getAll() {
        List<User> userList = userDao.get();
        userList.forEach(user -> user.setPassword(null));
        return userList;
    }

    @GetMapping("/exist/{username}")
    public boolean checkExistenceByUsername(@PathVariable("username") String username) {
        return userDao.checkExistence(username);
    }

    @GetMapping("/logout")
    public boolean logout(@AuthenticationPrincipal final User user) {
        authentication.logout(user);
        return true;
    }
}
