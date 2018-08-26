package edu.omsu.jesper.service.implementation.security;

import com.google.common.collect.ImmutableMap;
import edu.omsu.jesper.dao.implementations.UserDaoImpl;
import edu.omsu.jesper.dto.LoginResponse;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.TokenService;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TokenAuthenticationService implements UserAuthenticationService {

    private final TokenService tokenService;
    private final UserDaoImpl userDao;
    private final PasswordEncoder encoder;
    @Autowired
    public TokenAuthenticationService(TokenService tokenService, UserDaoImpl userDao, PasswordEncoder encoder) {
        this.tokenService = tokenService;
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public LoginResponse getResponse(String username, String password) {
        User user = userDao.get(username);
        if (user == null) throw new UsernameNotFoundException(String.format("No user %s found", username));
        if (Objects.equals(user.getPassword(), password)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.token = tokenService.expiring(ImmutableMap.of("username", username));
            loginResponse.username = user.getUsername();
            loginResponse.email = user.getEmail();
            loginResponse.firstName = user.getFirstName();
            loginResponse.lastName = user.getSecondName();
            if (user.getCompanyId() != null)
                loginResponse.companyId = user.getCompanyId().toString();
            else loginResponse.companyId = null;
            loginResponse.phoneNumber = user.getPhoneNumber();
            return loginResponse;

        } else throw new BadCredentialsException("Wrong username/password");
    }

    @Override
    public String getTokenFor(String username, String password) {
        User user = userDao.get(username);
        if (user == null) throw new UsernameNotFoundException(String.format("No user %s found", username));
        if (Objects.equals(user.getPassword(), password)) {
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
