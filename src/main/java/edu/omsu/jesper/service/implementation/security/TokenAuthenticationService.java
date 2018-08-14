package edu.omsu.jesper.service.implementation.security;

import com.google.common.collect.ImmutableMap;
import edu.omsu.jesper.dao.implementations.UserDaoImpl;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.TokenService;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TokenAuthenticationService implements UserAuthenticationService {

    private final TokenService tokenService;
    private final UserDaoImpl userDao;

    @Autowired
    public TokenAuthenticationService(TokenService tokenService, UserDaoImpl userDao) {
        this.tokenService = tokenService;
        this.userDao = userDao;
    }

    @Override
    public String login(String username, String password) {
        if (Objects.equals(userDao.get(username).getPassword(), password)) {
            return tokenService.expiring(ImmutableMap.of("username", username));
        } else throw new BadCredentialsException("Wrong username/password");

    }

    @Override
    public User getByToken(String token) {
        return userDao.get(tokenService.verify(token).get("username"));
    }

    @Override
    public void logout(User user) {

    }
}
