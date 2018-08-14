package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.implementations.UserDaoImpl;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class AuthenticationController {

    private final UserAuthenticationService authentication;
    private final UserDaoImpl userDao;

    @Autowired
    public AuthenticationController(UserAuthenticationService authentication, UserDaoImpl userDao) {
        this.authentication = authentication;
        this.userDao = userDao;
    }

    @PostMapping("/register")
    public String login(@RequestBody User user) {
        userDao.save(user);
        return login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") final String username,
                        @RequestParam("password") final String password) {
        return authentication.login(username, password);
    }
}
