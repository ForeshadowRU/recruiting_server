package edu.omsu.jesper.service.interfaces.security;

import edu.omsu.jesper.dto.LoginResponse;
import edu.omsu.jesper.model.User;

public interface UserAuthenticationService {

    LoginResponse getResponse(String username, String password);

    String getTokenFor(String username, String password);

    User getByToken(String token);

    void logout(User user);

}
