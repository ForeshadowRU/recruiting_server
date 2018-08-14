package edu.omsu.jesper.service.interfaces.security;

import edu.omsu.jesper.model.User;

public interface UserAuthenticationService {

    String login(String username, String password);

    User getByToken(String token);

    void logout(User user);

}
