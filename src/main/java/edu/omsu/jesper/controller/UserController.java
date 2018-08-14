package edu.omsu.jesper.controller;

import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserAuthenticationService authentication;

    @Autowired
    public UserController(UserAuthenticationService authentication) {
        this.authentication = authentication;
    }

    @GetMapping("/current")
    public User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/logout")
    public boolean logout(@AuthenticationPrincipal final User user) {
        authentication.logout(user);
        return true;
    }
}
